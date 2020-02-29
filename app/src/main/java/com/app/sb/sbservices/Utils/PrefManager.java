package com.app.sb.sbservices.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "SbServices";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL_ID = "email_id";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "name";
    private static final String USER_ID = "user_id";
    private static final String INCLUSION = "inclusion";
    private static final String ORDER_ID= "order_id";
    private static final String REFERAL_ID= "referral_id";
    private static final String SERVICE_ID = "service_id";
    private static final String LAND_MARK = "landmark";
    private static final String DOOR_NUM = "doorNumber";
    private static final String LOCTAION = "location";
    private static final String TOTAL_PRICE = "totalprice";
    private static final String PRESENT_REWARD_POINTS = "presentRewad";
    private static final String DEDUCT_PRICE = "deductPrice";
    private static final String REWARDS_POINTS = "rewardpoints";
    private static final String COUPON_AMOUNT = "couponAmopunt";
    private static final String COUPON_CODE = "couponCode";
    private static final String S_DATE = "s_date";
    private static final String CUTTING_REWARDPOINTS = "cuttingpoints";
    private static final String FACEBOOK_APP_ID = "facebookAppId";
    private static final String devceid = "facebookAppId";
    private static final String registrationtoken = "facebookAppId";

    public PrefManager(Context context) {
        int PRIVATE_MODE = 0;
        pref = context.getApplicationContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.commit();
    }

    public void storeValue(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, object.toString());
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        }
        editor.apply();
    }

    public String getUserId() {
        return pref.getString(USER_ID, "");
    }
    public void setUserId(String userId) {
        editor.putString(USER_ID, userId);
        editor.commit();
    }
  public String getDevceid() {
        return pref.getString(devceid, "");
    }
    public void setDevceid(String devceid) {
        editor.putString(devceid, devceid);
        editor.commit();
    }
 public String getRegistrationtoken() {
        return pref.getString(registrationtoken, "");
    }
    public void setRegistrationtoken(String registrationtoken) {
        editor.putString(registrationtoken, registrationtoken);
        editor.commit();
    }

    public void setServiceId(String serviceId) {
        editor.putString(SERVICE_ID, serviceId);
        editor.commit();
    }
    public String getServiceId() {
        return pref.getString(SERVICE_ID, "");
    }

    public static String getINCLUSION() {
        return INCLUSION;
    }
    public void setInclusion(String inclusion) {
        editor.putString(INCLUSION, inclusion);
        editor.commit();
    }

    public void setDeductPrice(String deductPrice) {
        editor.putString(DEDUCT_PRICE, deductPrice);
        editor.commit();
    }
    public String getDeductPrice() {
        return pref.getString(DEDUCT_PRICE, "");
    }

    public void setCuttingRewardpoints(String cuttingRewardpoints)
    {
        editor.putString(CUTTING_REWARDPOINTS,cuttingRewardpoints);
        editor.commit();
    }

    public String getCuttingRewardpoints(){
        return pref.getString(CUTTING_REWARDPOINTS,"");
    }


    public void setsDate(String sDate) {
        editor.putString(S_DATE, sDate);
        editor.commit();
    }
    public String getsDate() {
        return pref.getString(S_DATE, "");
    }

    public void setRewardsPoints(String rewardsPoints) {
        editor.putString(REWARDS_POINTS, rewardsPoints);
        editor.commit();
    }
    public String getRewardsPoints() {
        return pref.getString(REWARDS_POINTS, "");
    }

    public String getPresentRewardPoints() {
        return pref.getString(PRESENT_REWARD_POINTS, "");
    }
    public void setPresentRewardPoints(String presentRewardPoints) {
        editor.putString(PRESENT_REWARD_POINTS, presentRewardPoints);
        editor.commit();
    }

    public void setPrice(String price) {
        editor.putString("price", price);
        editor.commit();
    }
    public String getPrice() {
        return pref.getString("price", "");
    }
    public String getFacebookAppId() {
        return pref.getString(FACEBOOK_APP_ID, "");
    }
    public void setFacebookAppId(String facebookAppId) {
        editor.putString(FACEBOOK_APP_ID, facebookAppId);
        editor.commit();
    }
     public void setTotalPrice(String totalPrice) {
        editor.putString(TOTAL_PRICE, totalPrice);
        editor.commit();
    }
    public String getTotalPrice() {
        return pref.getString(TOTAL_PRICE, "");
    }

    public void setCouponCode(String couponCode) {
        editor.putString(COUPON_CODE, couponCode);
        editor.commit();
    }
    public String getCouponCode() {
        return pref.getString(COUPON_CODE, "");
    }

    public void setCouponAmount(String couponAmount) {
        editor.putString(COUPON_AMOUNT, couponAmount);
        editor.commit();
    }
    public String getCouponAmount() {
        return pref.getString(COUPON_AMOUNT, "");
    }




    public String getString(String key) {
        return pref.getString(key, "");
    }

    public String getEmailId() {


        return pref.getString(EMAIL_ID, "");
    }
    public void setEmailId(String emailId) {
        editor.putString(EMAIL_ID, emailId);
        editor.commit();
    }
    public void setPhoneNumber(String phoneNumber) {
        editor.putString(PHONE_NUMBER, phoneNumber);
        editor.commit();
    }

    public String getPhoneNumber() {

        return pref.getString(PHONE_NUMBER, "");
    }

    public void setUsername(String username) {

        editor.putString(USERNAME, username);
        editor.commit();
    }

    public String getUsername() {
        return pref.getString(USERNAME, "");
    }


    public boolean getBoolean(String key) {
        return pref.getBoolean(key, false);
    }


    public String getOrderId() {
        return pref.getString(ORDER_ID, "");
    }

    public void setOrderId(String orderId) {
        editor.putString(ORDER_ID, orderId);
        editor.commit();
    }


    public void setLoctaion(String loctaion) {
        editor.putString(LOCTAION, loctaion);
        editor.commit();
    }

    public String getLoctaion() {
        return pref.getString(LOCTAION, "");
    }

    public void setLandMark(String landMark) {
        editor.putString(LAND_MARK, landMark);
        editor.commit();
    }
    public String getLandMark() {
        return pref.getString(LAND_MARK, "");
    }

    public void setDoorNum(String doorNum) {
        editor.putString(DOOR_NUM, doorNum);
        editor.commit();
    }
    public String getDoorNum() {
        return pref.getString(DOOR_NUM, "");
    }

    public void logout() {
        editor = pref.edit();
        editor.clear();
        editor.apply();
    }


}
