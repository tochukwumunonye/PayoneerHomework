
package com.tochukwu.payoneerhomework.data;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Style {

    @SerializedName("language")
    private String mLanguage;

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

}
