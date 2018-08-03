package com.airmcl.air.oss;

import java.io.*;
import java.net.URI;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Date;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airmcl.air.oss.entity.MddAttachment;
import com.airmcl.air.oss.entity.MddAttachmentExample;
import com.airmcl.air.oss.service.MddAttachmentService;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.ResponseCode;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.els.base.core.entity.ResponseResult;

/**
 * @Author xuhui
 * @Date 2018/6/11 下午12:44
 */
@Controller
@RequestMapping("oss")
public class PostObjectPolicy {
    private static Logger logger = LoggerFactory.getLogger(PostObjectPolicy.class);
    @Resource
    protected MddAttachmentService mddAttachmentService;

    private static final String ATTACHMENT_STORAGE = "aliyunOSS";

    @RequestMapping(method = RequestMethod.GET, value = "service/getPolicy")
    @ResponseBody
    public ResponseResult<Map<String, String>> getPolicy(String fileType){
        Map<String, String> respMap = new LinkedHashMap<>();
        // 检测文件类型是否合法，合法返回文件存储地址
        String filePath = getFileType(fileType);
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, filePath);

            String postPolicy = OssClient.getOSSClient().generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = OssClient.getOSSClient().calculatePostSignature(postPolicy);

            //String callbackUrl = "http://47.100.96.113:38080/air-pms/oss/service/callback";
            Properties pro = new Properties();
            InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream("conf.properties");
            pro.load(in);
            String  callbackUrl = pro.getProperty("oss.callback");
            JSONObject object = new JSONObject();
            object.put("callbackUrl", callbackUrl);

            //object.put("callbackBody","{\"filename\":${object},\"size\":${size},\"mimeType\":${mimeType},\"height\":${imageInfo.height},\"width\":${imageInfo.width}}");
            //object.put("callbackBodyType","application/json");

            object.put("callbackBody", "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}&bucket=${bucket}&format=${imageInfo.format}&etag=${etag}}");
            object.put("callbackBodyType", "application/json");

            String callbackString = object.toString();
            String base64CallbackBody = BinaryUtil.toBase64String(callbackString.getBytes("utf-8"));
            respMap.put("accessid", OssConfig.OSS_ACCESS_KEY_ID);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", filePath);
            respMap.put("host", OssConfig.OSS_HOST);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            respMap.put("callback", base64CallbackBody);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseResult.success(respMap);
    }

    @RequestMapping(value = "service/callback")
    @ResponseBody
    public ResponseResult<OutFileInfo> ossCallback(HttpServletRequest request, HttpServletResponse response){
        OutFileInfo result = new OutFileInfo();
        try {
            String ossCallbackBody = getPostBody(request.getInputStream(), Integer.parseInt(request.getHeader("content-length")));
            if (StringUtils.isBlank(ossCallbackBody)){
                throw new CommonException("参数为空");
            }
            // 检测ossCallbackBody是否合法
            Map<String,String> map = parameterAnalysis(ossCallbackBody);
            //String ossCallbackBody = GetPostBody(request.getInputStream(), Integer.parseInt(request.getHeader("content-length")));

            System.out.println("ossCallbackBody: "+ossCallbackBody);

            boolean ret = verifyOSSCallbackRequest(request, ossCallbackBody);
            System.out.println("verify result:" + ret);
            System.out.println("OSS Callback Body:" + ossCallbackBody);
            if(!ret){
                return ResponseResult.fail(ResponseCode.ERROR,null);
            }
            result.setFileName(map.get("filename"));
            result.setFiseSize(map.get("size"));
            result.setHeight(map.get("height"));
            result.setWidth(map.get("width"));
            result.setMimeType(map.get("mimeType"));

            String imageModel = map.get("filename").substring(0,map.get("filename").lastIndexOf("/")+1);
            logger.info("oss imageModel is-----" + imageModel);

            MddAttachmentExample mddAttachmentExample = new MddAttachmentExample();
            mddAttachmentExample.createCriteria().andBucketEqualTo(map.get("bucket")).andSha1EqualTo(map.get("etag")).andImagemodelEqualTo(imageModel);
            List<MddAttachment> mddAttachments = this.mddAttachmentService.queryAllObjByExample(mddAttachmentExample);
            if(null != mddAttachments && mddAttachments.size() > 0){
                return ResponseResult.success(result);
            }
            //新增记录至附件表
            MddAttachment mddAttachment = new MddAttachment();
            logger.info("oss filename" + map.get("filename"));
            mddAttachment.setUrl(map.get("filename"));
            System.out.println("oss x:var" + map.get("x:var"));
            mddAttachment.setImageheight(map.get("height"));
            mddAttachment.setImagewidth(map.get("width"));
            mddAttachment.setImagetype(map.get("format"));
            mddAttachment.setFilesize(Integer.valueOf(map.get("size")));
            mddAttachment.setMimetype(map.get("mimeType"));
            Long timeLong = (Long)DateUtil.getTimeLong();
            mddAttachment.setCreatetime(timeLong.intValue());
            mddAttachment.setUploadtime(timeLong.intValue());
            mddAttachment.setStorage(ATTACHMENT_STORAGE);

            mddAttachment.setImagemodel(imageModel);
            mddAttachment.setBucket(map.get("bucket"));
            //文件 sha1编码 这里使用阿里云的etag
            mddAttachment.setSha1(map.get("etag"));
            this.mddAttachmentService.addObj(mddAttachment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseResult.success(result);
    }

    /**
     * 获取请求体中的参数
     * @param is
     * @param contentLen
     * @return
     */
    public String getPostBody(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    // Should not happen.
                    if (readLengthThisTime == -1) {
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return new String(message);
            } catch (IOException e) {
            }
        }
        return "";
    }

    /**
     * 验证oss回调是否有效
     * @param request
     * @param ossCallbackBody
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    protected boolean verifyOSSCallbackRequest(HttpServletRequest request, String ossCallbackBody) throws NumberFormatException, IOException
    {
        boolean ret = false;
        String autorizationInput = new String(request.getHeader("Authorization"));
        String pubKeyInput = request.getHeader("x-oss-pub-key-url");

        System.out.println("Authorization: "+autorizationInput);
        System.out.println("x-oss-pub-key-url: "+pubKeyInput);

        byte[] authorization = BinaryUtil.fromBase64String(autorizationInput);
        byte[] pubKey = BinaryUtil.fromBase64String(pubKeyInput);
        String pubKeyAddr = new String(pubKey);
        System.out.println("pubKeyAddr: "+pubKeyAddr);
        if (!pubKeyAddr.startsWith("http://gosspublic.alicdn.com/") && !pubKeyAddr.startsWith("https://gosspublic.alicdn.com/"))
        {
            System.out.println("pub key addr must be oss addrss");
            return false;
        }
        String retString = executeGet(pubKeyAddr);
        retString = retString.replace("-----BEGIN PUBLIC KEY-----", "");
        retString = retString.replace("-----END PUBLIC KEY-----", "");
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        String decodeUri = java.net.URLDecoder.decode(uri, "UTF-8");
        String authStr = decodeUri;
        if (queryString != null && !queryString.equals("")) {
            authStr += "?" + queryString;
        }
        authStr += "\n" + ossCallbackBody;
        ret = doCheck(authStr, authorization, retString);
        return ret;
    }

    @SuppressWarnings({ "finally" })
    public String executeGet(String url) {
        BufferedReader in = null;

        String content = null;
        try {
            // 定义HttpClient
            @SuppressWarnings("resource")
            //DefaultHttpClient client = new DefaultHttpClient();
            CloseableHttpClient client = HttpClientBuilder.create().build();
            // 实例化HTTP方法
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            content = sb.toString();
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }

    public static boolean doCheck(String content, byte[] sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = BinaryUtil.fromBase64String(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            boolean bverify = signature.verify(sign);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 检测文件类型输入是否正确
     * @param fileType
     * @return
     */
    protected String getFileType(String fileType){
        Map<String,String> fileTypeMap = new HashMap<>();
        fileTypeMap.put("bcPath",FileTypePathEnum.beauticianPath.getValue());
        fileTypeMap.put("bhPath",FileTypePathEnum.beauticianHeadpicPath.getValue());
        fileTypeMap.put("sPath",FileTypePathEnum.servicePath.getValue());
        fileTypeMap.put("sbPath",FileTypePathEnum.serviceBannerPath.getValue());
        fileTypeMap.put("btPath",FileTypePathEnum.beauty.getValue());
        fileTypeMap.put("bPath",FileTypePathEnum.banner.getValue());
        String a = fileTypeMap.toString();
        System.out.println("map"+a);
        System.out.println("fileType"+fileType);
        if(fileTypeMap.containsKey(fileType)){
            return fileTypeMap.get(fileType);
        }else{
            throw new CommonException("文件类型错误,按照文档类型输入！");
        }
    }

    /**
     * 回调参数返回一串字符。需要对着字符做解析，并返回一个map集合以供流程便捷使用
     * @param ossCallbackBody oss回调参数字符串
     * @return
     */
    protected Map<String,String> parameterAnalysis(String ossCallbackBody){
        if(StringUtils.isBlank(ossCallbackBody)){
            throw new CommonException("尚未加载到回调参数！请求无效");
        }
        Map<String,String> map = new HashMap<>();
        String[] str = ossCallbackBody.split("&");
        for (int i = 0; i < str.length; i++) {
            String[] ss = str[i].split("=");
            map.put(ss[0],ss[1].replace("\"",""));
        }
        return map;
    }


}
