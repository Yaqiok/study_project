package tech.luochan.study.activity;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.luochan.base.activity.BaseActivity;
import tech.luochan.network.Api;
import tech.luochan.network.service.ApiService;
import tech.luochan.study.R;
import timber.log.Timber;

public class RKUpgradeDownloadActivity extends BaseActivity {

    private boolean mAcceptRanges = false;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_rkupgrade_download;
    }

    @Override
    protected void initData() {
//      checkVersion();
        downloadPackage();

    }

    private void downloadPackage() {
        Call<ResponseBody> call = Api.getInstance().create(ApiService.class).downloadPackage();
        Timber.d("download package call request url %s", call.request().url());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Timber.d("response code %s", response.code());
                if (response.code() == 206) {

                } else {

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                Timber.e("onFailure %s", t.getMessage());
            }
        });
    }

    private void checkVersion() {
        Call<ResponseBody> call = Api.getInstance().create(ApiService.class).checkVersion(9, "1.0.1.385");//.getBook(1220562);
        Timber.d("call request url %s", call.request().url());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    String respBody = null;
                    try {
                        respBody = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Timber.d("response body string: " + respBody);
                    Headers headers = response.headers();
                    Set<String> names = headers.names();
                    for (String str : names) {
                        Timber.d("response header name[" + str + "], value[" + headers.get(str) + "]");
                    }

                    try {
                        JSONObject jsonObject = new JSONObject(respBody);
                        int code = jsonObject.getInt("code");
                        if (code == 0) {
                            //有新版本
                            JSONObject data = jsonObject.getJSONObject("data");

                            String mTargetURI = data.getString("update_url");
                            String forceUpdate = data.getString("force_update");  //1: 强制； 2:可选

                            Timber.d("mTargetURI " + mTargetURI);
                        } else {
                            //没有新版本
                            Timber.d(jsonObject.getString("msg"));
                        }
                    } catch (JSONException e) {
                        Timber.e("JSONException error " + e.getLocalizedMessage());
                    }

                } else {
                    Timber.d("server error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Timber.e("onFailure " + t.getMessage());
            }
        });
    }
}