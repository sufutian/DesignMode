package sdk.login.tvos.com.sufutian;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by sufutian on 2016/11/10/10:03.
 */

public class MyApplication extends Application {

    /**
     * 内存泄漏检测工具
     */
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }


    //在自己的Application中添加如下代码
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context
                .getApplicationContext();
        return application.refWatcher;
    }
}
