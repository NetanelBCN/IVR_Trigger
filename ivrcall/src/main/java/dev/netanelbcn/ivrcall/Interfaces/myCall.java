package dev.netanelbcn.ivrcall.Interfaces;

import dev.netanelbcn.ivrcall.Models.ApiResponse;
import dev.netanelbcn.ivrcall.Models.CallPreferences;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface myCall {

    @POST("/")
    Call<ApiResponse> makeCallout(@Body CallPreferences request);

}
