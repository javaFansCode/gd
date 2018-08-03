package com.airmcl.air.oss;

        import com.aliyun.oss.ClientConfiguration;
        import com.aliyun.oss.OSSClient;
        import com.aliyun.oss.common.auth.Credentials;
        import com.aliyun.oss.common.auth.DefaultCredentialProvider;
        import com.aliyun.oss.common.auth.DefaultCredentials;

/**
 * @Author xuhui
 * @Date 2018/6/11 下午2:43
 */
public class OssClient {

    protected static OSSClient ossClient;

    public static OSSClient getOSSClient() {
        if (ossClient == null) {
            ClientConfiguration conf = new ClientConfiguration().setSupportCname(false);
            Credentials credentials = new DefaultCredentials(OssConfig.OSS_ACCESS_KEY_ID, OssConfig.OSS_ACCESS_KEY_SECRET);
            ossClient = new OSSClient(OssConfig.OSS_ENDPOINT, new DefaultCredentialProvider(credentials), conf);
        }
        return ossClient;
    }
}
