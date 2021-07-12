package tech.luochan.network.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("version/check")
    Call<ResponseBody> checkVersion(@Query("type") int type, @Query("version") String version);

    @GET("book/{id}")
    Call<ResponseBody> getBook(@Path("id") int id);

    @GET("files/version/2021/pboxhardware1.0.0.525.zip")
    Call<ResponseBody> downloadPackage();

}
