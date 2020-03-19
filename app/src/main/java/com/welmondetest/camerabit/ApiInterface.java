package com.welmondetest.camerabit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface ApiInterface {

    @Multipart
    @POST("BarCodeService.svc/GetDrivingLicenseData")
    Call<Img_Pojo> uploadImage(@Field("Base64Barcode") String image);
}
