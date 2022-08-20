package com.qxy.minitiktok.logic.dao;

/**
 * @Classname UserInfo
 * @Description: 用户信息
 * @Created by 康斯坦丁
 * @Date 2022/8/20 22:19
 */
public class UserInfo {
    //用户头像，小
    private String avatar;
    //用户头像大
    private String avatar_larger;

    private String captcha;
    //所在城市（地级市）
    private String city;

    private String client_key;
    //所在国家
    private String country;

    private String desc_url;
    //错误码描述
    private String description;
    //所在区
    private String district;
    //账号类型
    //EAccountM：普通企业号
    //EAccountS：认证企业号
    //EAccountK：品牌企业号
    private String e_account_role;
    //错误码
    private int error_code;
    //性别
    private int gender;

    private String log_id;
    //昵称
    private String nickname;
    //用户在当前应用的唯一标识
    private String open_id;
    //所在省份或直辖市
    private String province;
    //用户在当前开发者账号下的唯一标识（未绑定开发者账号没有该字段）
    private String union_id;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar_larger(String avatar_larger) {
        this.avatar_larger = avatar_larger;
    }

    public String getAvatar_larger() {
        return this.avatar_larger;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    public String getClient_key() {
        return this.client_key;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setDesc_url(String desc_url) {
        this.desc_url = desc_url;
    }

    public String getDesc_url() {
        return this.desc_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setE_account_role(String e_account_role) {
        this.e_account_role = e_account_role;
    }

    public String getE_account_role() {
        return this.e_account_role;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return this.gender;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getLog_id() {
        return this.log_id;
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

}
