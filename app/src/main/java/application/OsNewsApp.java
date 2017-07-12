package application;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by wind on 17-7-12.
 */

public class OsNewsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this,"http://www.oschina.net/");
    }
}
