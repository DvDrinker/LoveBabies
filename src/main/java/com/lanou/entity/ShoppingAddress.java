package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class ShoppingAddress {
    private Integer addressId;
    private String name;
    private String city;
    private String address;
    private String phone;
    private String telephone;
    private Integer uId;
    private Integer deleteId;
    private Integer defaltId;

    @Override
    public String toString() {
        return "ShoppingAddress{" +
                "addressId=" + addressId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uId=" + uId +
                ", deleteId=" + deleteId +
                ", defaltId=" + defaltId +
                '}';
    }

    public Integer getDefaltId() {
        return defaltId;
    }

    public void setDefaltId(Integer defaltId) {
        this.defaltId = defaltId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public ShoppingAddress() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }
}
