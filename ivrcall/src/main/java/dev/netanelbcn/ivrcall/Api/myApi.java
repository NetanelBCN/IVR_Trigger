package dev.netanelbcn.ivrcall.Api;

import dev.netanelbcn.ivrcall.Interfaces.myCall;
import dev.netanelbcn.ivrcall.Models.ApiResponse;
import dev.netanelbcn.ivrcall.Models.CallPreferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myApi {

    private final myCall apiService;

    /**
     * Constructor for initializing Retrofit and myCall interface.
     *
     * @param baseUrl The base URL of the API.
     */
    public myApi(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(myCall.class);
    }

    /**
     * Makes the API call to initiate the callout.
     *
     * @param callPreferences The request body containing call preferences.
     * @param callback        The callback to handle the API response.
     */
    public void makeCall(CallPreferences callPreferences, Callback<ApiResponse> callback) {
        Call<ApiResponse> call = apiService.makeCallout(callPreferences);
        call.enqueue(callback);
    }
}
