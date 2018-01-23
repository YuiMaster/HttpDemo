package com.yui.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jane on 2018/1/22.
 */

public class SettingPersonInfoBean implements Parcelable {
    private String trueName;
    private String hospitalName;
    private String schoolName;
    private String specialityName;
    private String titleName;
    private String headImg;
    private String userType;
    private String sex;
    private String mobile;
    private int hospitalId;
    private int titleId;
    private int specialityId;
    private int schoolId;
    private String licenceStatus;
    private String email;
    private String description;
    private int provinceId;
    private String province;
    private int cityId;
    private String city;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getLicenceStatus() {
        return licenceStatus;
    }

    public void setLicenceStatus(String licenceStatus) {
        this.licenceStatus = licenceStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.trueName);
        dest.writeString(this.hospitalName);
        dest.writeString(this.schoolName);
        dest.writeString(this.specialityName);
        dest.writeString(this.titleName);
        dest.writeString(this.headImg);
        dest.writeString(this.userType);
        dest.writeString(this.sex);
        dest.writeString(this.mobile);
        dest.writeInt(this.hospitalId);
        dest.writeInt(this.titleId);
        dest.writeInt(this.specialityId);
        dest.writeInt(this.schoolId);
        dest.writeString(this.licenceStatus);
        dest.writeString(this.email);
        dest.writeString(this.description);
        dest.writeInt(this.provinceId);
        dest.writeString(this.province);
        dest.writeInt(this.cityId);
        dest.writeString(this.city);
    }

    public SettingPersonInfoBean() {
    }

    protected SettingPersonInfoBean(Parcel in) {
        this.trueName = in.readString();
        this.hospitalName = in.readString();
        this.schoolName = in.readString();
        this.specialityName = in.readString();
        this.titleName = in.readString();
        this.headImg = in.readString();
        this.userType = in.readString();
        this.sex = in.readString();
        this.mobile = in.readString();
        this.hospitalId = in.readInt();
        this.titleId = in.readInt();
        this.specialityId = in.readInt();
        this.schoolId = in.readInt();
        this.licenceStatus = in.readString();
        this.email = in.readString();
        this.description = in.readString();
        this.provinceId = in.readInt();
        this.province = in.readString();
        this.cityId = in.readInt();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<SettingPersonInfoBean> CREATOR = new Parcelable.Creator<SettingPersonInfoBean>() {
        @Override
        public SettingPersonInfoBean createFromParcel(Parcel source) {
            return new SettingPersonInfoBean(source);
        }

        @Override
        public SettingPersonInfoBean[] newArray(int size) {
            return new SettingPersonInfoBean[size];
        }
    };
}
