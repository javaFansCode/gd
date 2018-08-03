package com.airmcl.basae.utils;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * @Author xuhui
 * @Date 2018/6/14 上午10:31
 *
 * 生成编号工具类
 *
 */
public class GenerateCodeUtils {

    /**
     * 纯字母
     */
    private static final String ALL_ABC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 纯数字
     */
    private static final String ALL_NUMBER = "0123456789";

    /**
     * 数字+字母
     */
    private static final String NUMBER_AND_ABC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * 生成类型
     */
    //public enum GenerateType {
    //    ALL_ABC, ALL_NUMBER, NUMBER_AND_ABC
    //}

    /**
     * 生成不带-的UUID
     * @return
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 生成指定长度的编码
     * @param length 生成编码长度
     * @param type 生成编码组成结果：  1英文 2数字 3英文+数字
     * @return
     */
    public static String generateCodeByLength(int length, int type) {
        String result = "";
        String assemble;

        if (BaseConst.GENERATE_TYPE_ALL_ABC == type) {
            assemble = ALL_ABC;
        }else if(BaseConst.GENERATE_TYPE_ALL_NUMBER == type){
            assemble = ALL_NUMBER;
        }else {
            assemble = NUMBER_AND_ABC;
        }

        char[] rands = new char[length];
        for (int i = 0; i < rands.length; i++) {
            int rand = (int)(Math.random() * assemble.length());
            result = result + String.valueOf(assemble.charAt(rand));
        }
        return result;
    }

    /**
     * 编号生成
     * @param prefix 前缀
     * @param suffix 后缀
     * @param length 总长度
     * @param type  1英文 2数字 3英文+数字
     */
    public static String generateCodeByLength(String prefix, String suffix, int length, int type){
        String result = "";
        String assemble;

        if (BaseConst.GENERATE_TYPE_ALL_ABC == type) {
            assemble = ALL_ABC;
        }else if(BaseConst.GENERATE_TYPE_ALL_NUMBER == type){
            assemble = ALL_NUMBER;
        }else {
            assemble = NUMBER_AND_ABC;
        }

        char[] rands = new char[length];
        for (int i = 0; i < rands.length; i++) {
            int rand = (int)(Math.random() * assemble.length());
            result = result + String.valueOf(assemble.charAt(rand));
        }

        if(StringUtils.isNotBlank(prefix)){
            result = prefix + result.substring(prefix.length(), result.length());
        }
        if(StringUtils.isNotBlank(suffix)){
            result = result.substring(0, result.length() - suffix.length()) + suffix;
        }
        return result;
    }

}
