package com.airmcl.air.beautician.entity;
/**
 * State枚举
 * 1已审核，2未审核  3下架 0删除
 */
public enum StateEnum {

    AUDITED(1,"已审核"),
    UNAUDITED(2,"未审核"),
    NONE(3,"下架"),
    DELETE(0,"收获完")

    ;


    StateEnum(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }



    public static  StateEnum fromCode(int code)
    {
        for(StateEnum item : values())
        {
            if(item.code==code)
            {
                return item;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private   Integer code ;
    private   String  msg;



    public static String getMsg(Integer index) {
        for (StateEnum code : StateEnum.values()) {
            if (code.getCode() == index) {
                return code.getMsg();
            }
        }
        return null;
    }


}