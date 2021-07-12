package tech.luochan.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.luochan.network.interceptors.LoggingInterceptor;

public class Api {

    private static Api mInstance;
    private Retrofit mRetrofit;

    private final static String BASE_URL = "https://api-test.pbox.skymesh.cn:30443/";
//    private final static String BASE_URL = "https://api.douban.com/v2/";

    private Api() {
        init();
    }

    private void init() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .retryOnConnectionFailure(true)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClientManager.getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Api getInstance() {
        if (null == mInstance) {
            synchronized (Api.class) {
                if (null == mInstance) {
                    mInstance = new Api();
                }
            }
        }
        return mInstance;
    }

    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }


}
