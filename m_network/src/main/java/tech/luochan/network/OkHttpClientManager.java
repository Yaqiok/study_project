package tech.luochan.network;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import tech.luochan.network.interceptors.LoggingInterceptor;

public class OkHttpClientManager {

    public static synchronized OkHttpClient getHttpClient() {
        try {
            X509TrustManager manager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            final TrustManager[] trustAllCerts = new TrustManager[]{manager};
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext
                    .getSocketFactory();

            return new OkHttpClient()
                    .newBuilder()
//                    .addInterceptor(new RetryIntercepter(RETRY_MAX)) //设置重试次数最大3次
                    .sslSocketFactory(sslSocketFactory, manager)
                    .hostnameVerifier((hostname, session) -> true)
                    .readTimeout(8, TimeUnit.SECONDS)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void getSync(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(url)
                            .get()
                            .build();
                    Call call = client.newCall(request);
                    Response response = call.execute();
                    if (response.isSuccessful()) {
                        // success ok
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void getAsyn(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code();
                String result = response.body().string();

            }
        });
    }

    public void post(String url, String key, String value) {
//        OkHttpClient client = new OkHttpClient();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        FormBody body = new FormBody.Builder()
                .add(key, value)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Accept", "image/webp")
                .addHeader("Charset", "UTF-8")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {

                }
            }
        });
    }

}
