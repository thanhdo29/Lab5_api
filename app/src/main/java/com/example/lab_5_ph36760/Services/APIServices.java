package com.example.lab_5_ph36760.Services;

import com.example.lab_5_ph36760.Model.Distributor;
import com.example.lab_5_ph36760.Model.Response_Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIServices {
    //Sử dụng máy ảo android studio thì localhost thay thành id 10.0.0.2
    //Đối với máy thật ta sử dụng ip của máy
    //Base_URL là url của api

    public static String BASE_URL = "http://10.0.2.2:3000/api/";

    //Annotations @GET cho method GET và url phương gọi

    @GET("get-list-distributors")
    Call<Response_Model<ArrayList<Distributor>>> getListDistributos();
    //Call giá trị trả về của api

    @GET("get-list-caytrongs")
    Call<Response_Model<ArrayList<Tree>>> getListCaytrong();
    @GET("search-distributors")
    Call<Response_Model<ArrayList<Distributor>>> searchDistributor(@Query("key") String key);

    @POST("add-distributors")
    Call<Response_Model<Distributor>> addDistributor(@Body Distributor distributor);

    //Param url sẽ bỏ vào {}
    @DELETE("delete-distributor-by-id/{id}")
    Call<Response_Model<Distributor>> deleteDistributorById(@Path("id") String id);

    @PUT("update-distributor/{id}")
    Call<Response_Model<Distributor>> updateDistributorById(@Path("id") String id, @Body Distributor distributor);
}
