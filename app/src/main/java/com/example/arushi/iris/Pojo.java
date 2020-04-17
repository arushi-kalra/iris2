package com.example.arushi.iris;

import com.google.gson.annotations.SerializedName;

public class Pojo {
    @SerializedName("Prediction")
    private String  Prediction;

    public String getPrediction() {
        return Prediction;
    }

    public void setPrediction(String prediction) {
        Prediction = prediction;
    }
}
