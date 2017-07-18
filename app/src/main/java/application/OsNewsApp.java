package application;

import android.app.Application;

import com.example.wind.osnews.R;
import com.itheima.retrofitutils.ItheimaHttp;
import com.maning.themelibrary.SkinManager;

/**
 * Created by wind on 17-7-12.
 */

public class OsNewsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ItheimaHttp.init(this,"http://www.oschina.net/");
//        ItheimaHttp.init(this,"http://api.laifudao.com/");
//        ItheimaHttp.init(this,"http://v.juhe.cn/");

        //设置白天主题的和夜间主题
        SkinManager.setThemeID(R.style.DayTheme, R.style.NightTheme);
    }
}
