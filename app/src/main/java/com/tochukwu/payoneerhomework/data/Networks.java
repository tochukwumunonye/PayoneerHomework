
package com.tochukwu.payoneerhomework.data;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Networks {

    @SerializedName("applicable")
    private List<Applicable> mApplicable;

    public List<Applicable> getApplicable() {
        return mApplicable;
    }

    public void setApplicable(List<Applicable> applicable) {
        mApplicable = applicable;
    }

}
