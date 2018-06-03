package personal.system.com.dhwanitaskabhinav.rest;

import java.util.Map;

import personal.system.com.dhwanitaskabhinav.model.BaseApiResponseModel;
import personal.system.com.dhwanitaskabhinav.model.StateResponseModel;
import personal.system.com.dhwanitaskabhinav.model.LoginResponseModel;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponseModel> getLoginResult(
            @FieldMap Map<String, String> params);

    @GET("master/get-state")
    Call<StateResponseModel> getStateResult(@Header("token") String token);

    @FormUrlEncoded
    @POST("district/create")
    Call<BaseApiResponseModel> createDistrict(@Header("token") String token,
                                              @FieldMap Map<String, String> params, @FieldMap Map<String,Integer> params2);

    @GET("user/logout")
    Call<StateResponseModel> doLogout(@Header("token") String token);

}

