
package com.tochukwu.payoneerhomework.data;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Interaction {

    @SerializedName("code")
    private String mCode;
    @SerializedName("reason")
    private String mReason;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String reason) {
        mReason = reason;
    }

}
