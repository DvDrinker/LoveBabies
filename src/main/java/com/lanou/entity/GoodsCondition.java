package com.lanou.entity;

/**
 * Created by lanou on 2017/12/1.
 */
public class GoodsCondition {
   private Integer conditionId;
   //主键

   private Integer goods_id;
   //商品外键

   private String condition_name;
   //属性名：例如品牌

   private String condition_value;
   //属性值：例如帮宝适

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getGood_id() {
        return goods_id;
    }

    public void setGood_id(Integer good_id) {
        this.goods_id = good_id;
    }

    public String getCondition_name() {
        return condition_name;
    }

    public void setCondition_name(String condition_name) {
        this.condition_name = condition_name;
    }

    public String getCondtion_value() {
        return condition_value;
    }

    public void setCondtion_value(String condtion_value) {
        this.condition_value = condtion_value;
    }

    public GoodsCondition() {
    }

    @Override
    public String toString() {
        return "GoodsCondition{" +
                "conditionId=" + conditionId +
                ", goods_id=" + goods_id +
                ", condition_name='" + condition_name + '\'' +
                ", condition_value='" + condition_value + '\'' +
                '}';
    }
}
