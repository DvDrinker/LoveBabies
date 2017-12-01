package com.lanou.entity;

/**
 * Created by lanou on 2017/12/1.
 */
public class GoodsCondition {
    private Integer conditionId;
//    primary key
    private Integer goods_id;
//    goods foreign key

    private String pinpai;

    private String jinkouGuochan;

    private Double jiage;

    private String baozhuang;

    private String fenlei;

    private String shiyongnianling;

    private String zhonglei;

    private String xinghaoKuanshi;

    private String kouwei;

    private String rongliang;

    private String chima;

    private String nanNvkuan;

    private String caizhi;

    private String gongneng;

    private String leixing;

    private String danshuangmian;

    private String yanse;

    private String houdu;

    private String jieduan;

    private String koujing;

    private String shifoudaishoubing;

    private String shifouganwen;

    private String kongxingliuliang;

    private String ISOFIXzhuangzhi;

    private String anzhuangfangshi;

    private String luntai;

    private String jijie;

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getJinkouGuochan() {
        return jinkouGuochan;
    }

    public void setJinkouGuochan(String jinkouGuochan) {
        this.jinkouGuochan = jinkouGuochan;
    }

    public Double getJiage() {
        return jiage;
    }

    public void setJiage(Double jiage) {
        this.jiage = jiage;
    }

    public String getBaozhuang() {
        return baozhuang;
    }

    public void setBaozhuang(String baozhuang) {
        this.baozhuang = baozhuang;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    public String getShiyongnianling() {
        return shiyongnianling;
    }

    public void setShiyongnianling(String shiyongnianling) {
        this.shiyongnianling = shiyongnianling;
    }

    public String getZhonglei() {
        return zhonglei;
    }

    public void setZhonglei(String zhonglei) {
        this.zhonglei = zhonglei;
    }

    public String getXinghaoKuanshi() {
        return xinghaoKuanshi;
    }

    public void setXinghaoKuanshi(String xinghaoKuanshi) {
        this.xinghaoKuanshi = xinghaoKuanshi;
    }

    public String getKouwei() {
        return kouwei;
    }

    public void setKouwei(String kouwei) {
        this.kouwei = kouwei;
    }

    public String getRongliang() {
        return rongliang;
    }

    public void setRongliang(String rongliang) {
        this.rongliang = rongliang;
    }

    public String getChima() {
        return chima;
    }

    public void setChima(String chima) {
        this.chima = chima;
    }

    public String getNanNvkuan() {
        return nanNvkuan;
    }

    public void setNanNvkuan(String nanNvkuan) {
        this.nanNvkuan = nanNvkuan;
    }

    public String getCaizhi() {
        return caizhi;
    }

    public void setCaizhi(String caizhi) {
        this.caizhi = caizhi;
    }

    public String getGongneng() {
        return gongneng;
    }

    public void setGongneng(String gongneng) {
        this.gongneng = gongneng;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getDanshuangmian() {
        return danshuangmian;
    }

    public void setDanshuangmian(String danshuangmian) {
        this.danshuangmian = danshuangmian;
    }

    public String getYanse() {
        return yanse;
    }

    public void setYanse(String yanse) {
        this.yanse = yanse;
    }

    public String getHoudu() {
        return houdu;
    }

    public void setHoudu(String houdu) {
        this.houdu = houdu;
    }

    public String getJieduan() {
        return jieduan;
    }

    public void setJieduan(String jieduan) {
        this.jieduan = jieduan;
    }

    public String getKoujing() {
        return koujing;
    }

    public void setKoujing(String koujing) {
        this.koujing = koujing;
    }

    public String getShifoudaishoubing() {
        return shifoudaishoubing;
    }

    public void setShifoudaishoubing(String shifoudaishoubing) {
        this.shifoudaishoubing = shifoudaishoubing;
    }

    public String getShifouganwen() {
        return shifouganwen;
    }

    public void setShifouganwen(String shifouganwen) {
        this.shifouganwen = shifouganwen;
    }

    public String getKongxingliuliang() {
        return kongxingliuliang;
    }

    public void setKongxingliuliang(String kongxingliuliang) {
        this.kongxingliuliang = kongxingliuliang;
    }

    public String getISOFIXzhuangzhi() {
        return ISOFIXzhuangzhi;
    }

    public void setISOFIXzhuangzhi(String ISOFIXzhuangzhi) {
        this.ISOFIXzhuangzhi = ISOFIXzhuangzhi;
    }

    public String getAnzhuangfangshi() {
        return anzhuangfangshi;
    }

    public void setAnzhuangfangshi(String anzhuangfangshi) {
        this.anzhuangfangshi = anzhuangfangshi;
    }

    public String getLuntai() {
        return luntai;
    }

    public void setLuntai(String luntai) {
        this.luntai = luntai;
    }

    public String getJijie() {
        return jijie;
    }

    public void setJijie(String jijie) {
        this.jijie = jijie;
    }

    public GoodsCondition() {

    }

    @Override
    public String toString() {
        return "GoodsCondition{" +
                "conditionId=" + conditionId +
                ", goods_id=" + goods_id +
                ", pinpai='" + pinpai + '\'' +
                ", jinkouGuochan='" + jinkouGuochan + '\'' +
                ", jiage=" + jiage +
                ", baozhuang='" + baozhuang + '\'' +
                ", fenlei='" + fenlei + '\'' +
                ", shiyongnianling='" + shiyongnianling + '\'' +
                ", zhonglei='" + zhonglei + '\'' +
                ", xinghaoKuanshi='" + xinghaoKuanshi + '\'' +
                ", kouwei='" + kouwei + '\'' +
                ", rongliang='" + rongliang + '\'' +
                ", chima='" + chima + '\'' +
                ", nanNvkuan='" + nanNvkuan + '\'' +
                ", caizhi='" + caizhi + '\'' +
                ", gongneng='" + gongneng + '\'' +
                ", leixing='" + leixing + '\'' +
                ", danshuangmian='" + danshuangmian + '\'' +
                ", yanse='" + yanse + '\'' +
                ", houdu='" + houdu + '\'' +
                ", jieduan='" + jieduan + '\'' +
                ", koujing='" + koujing + '\'' +
                ", shifoudaishoubing='" + shifoudaishoubing + '\'' +
                ", shifouganwen='" + shifouganwen + '\'' +
                ", kongxingliuliang='" + kongxingliuliang + '\'' +
                ", ISOFIXzhuangzhi='" + ISOFIXzhuangzhi + '\'' +
                ", anzhuangfangshi='" + anzhuangfangshi + '\'' +
                ", luntai='" + luntai + '\'' +
                ", jijie='" + jijie + '\'' +
                '}';
    }
}
