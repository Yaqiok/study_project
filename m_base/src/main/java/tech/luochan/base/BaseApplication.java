package tech.luochan.base;

import android.app.Application;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
                return super.createStackElementTag(element) + "#" + element.getMethodName();
            }
        });
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}
