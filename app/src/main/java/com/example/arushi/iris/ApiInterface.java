package com.example.arushi.iris;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("predict")
    Call<Pojo> getAPIResponse(
            @Field("sepal_length") String sepal_length,
            @Field("sepal_width") String sepal_width,
            @Field("petal_length") String petal_length ,
            @Field("petal_width") String petal_width);



}
