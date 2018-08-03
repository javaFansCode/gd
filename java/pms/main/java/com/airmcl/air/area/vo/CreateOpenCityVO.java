package com.airmcl.air.area.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xuhui
 * @Date 2018/4/16 下午5:26
 */
public class CreateOpenCityVO implements Serializable {

    //省ID
    private int provinceId;

    //市ID
    private int cityId;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public static void main(String[] args) {
        try {

            //String[] arr = {"1520701210","1520756307","1520949676","1520953883","1521033008","1521254624","1521265741","1521296347","1521357025","1521359474","1521535011","1521536625","1521537656","1521545758","1521546947","1521547055","1521547162","1521548372","1521615197","1521775921","1522300899","1522382925","1522476642","1522480136","1522649999","1522667782","1522751669","1522907917","1522915012","1522940757","1522980323","1522986650","1522987566","1523239884","1523461005","1523682787","1523869709"};
            //String[] arr = {"1523603001","1523603177","1523676499","1523691665","1523776809","1524019234"};
            String[] arr = {"1520858980","1522051921","1522149389","1522154931","1522157264","1522158733","1522652741","1522909400","1523849352"};
            for(String seconds: arr){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str = sdf.format(new Date(Long.valueOf(seconds+"000")));
                System.out.println(str);
            }



        }catch (Exception e){
            e.printStackTrace();;
        }

    }
}
