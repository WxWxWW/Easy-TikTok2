package com.qxy.minitiktok.logic.dao;

/**
 * @Classname User
 * @Description: TODO
 * @Created by 康斯坦丁
 * @Date 2022/8/18 19:51
 */
public class User {
    //头像
    private String avatar;
    //城市
    private String city;
    //国家
    private String country;
    //错误码描述
    private String description;
    //账号类型
    private String e_account_role;
    //错误码
    private String error_code;
    //性别
    private String gender;
    //昵称
    private String nickname;
    //用于唯一标识用户的id
    private String open_id;
    //省份
    private String province;
    //用户在当前开发者账号下的唯一标识
    private String union_id;


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setE_account_role(String e_account_role) {
        this.e_account_role = e_account_role;
    }

    public String getE_account_role() {
        return this.e_account_role;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_code() {
        return this.error_code;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getOpen_id() {
        return this.open_id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }

    public String getUnion_id() {
        return this.union_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "avatar='" + avatar + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", e_account_role='" + e_account_role + '\'' +
                ", error_code='" + error_code + '\'' +
                ", gender='" + gender + '\'' +
                ", nickname='" + nickname + '\'' +
                ", open_id='" + open_id + '\'' +
                ", province='" + province + '\'' +
                ", union_id='" + union_id + '\'' +
                '}';
    }
}
