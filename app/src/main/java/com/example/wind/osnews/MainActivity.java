package com.example.wind.osnews;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.wind.osnews.fragment.DiscoverFragment;
import com.example.wind.osnews.fragment.HomeFragment;
import com.example.wind.osnews.fragment.MineFragment;
import com.example.wind.osnews.fragment.JuheFragment;
import com.maning.themelibrary.SkinManager;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

//fragmentTransaction变量定义为全局变量，导致只能commit一次，所以只要将FragmentTransaction变量定义为局部变量即可。

public class MainActivity extends BaseActivity {

    /*@BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.picture)
    RadioButton picture;
    @BindView(R.id.discover)
    RadioButton discover;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.login)
    RadioButton login;*/
    BottomBar bottomBar;
    private Fragment f1, f2, f3, f4;

    private int robotCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        initDrawer();

        initFragment();

        initBottomBar();

       /* RadioGroup rg = (RadioGroup) findViewById(R.id.rg_tabs);
        //改变tab栏图片大小,用了bottombar,不用了
        changeImageSize();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                switch (checkedId) {
                    case R.id.home:
                        ft.show(f1).hide(f2).hide(f3).hide(f4).commit();
                        break;
                    case R.id.picture:
                        ft.show(f2).hide(f1).hide(f3).hide(f4).commit();
                        break;
                    case R.id.discover:
                        ft.show(f3).hide(f2).hide(f1).hide(f4).commit();
                        break;
                    case R.id.mine:
                        ft.show(f4).hide(f2).hide(f3).hide(f1).commit();
                        break;
                    case R.id.login:
                        Toast.makeText(MainActivity.this, "在我的BGM里,没人能打败我!", Toast.LENGTH_SHORT).show();
                }
            }
        });*/


    }

    private void initBottomBar() {

        final BottomBarTab robot = bottomBar.getTabWithId(R.id.tab_robot);
        robot.setBadgeCount(1);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                switch (tabId) {
                    case R.id.tab_home:
                        ft.show(f1).hide(f2).hide(f3).hide(f4).commit();
                        break;
                    case R.id.tab_news:
                        ft.show(f2).hide(f1).hide(f3).hide(f4).commit();
                        break;
                    case R.id.tab_discover:
                        ft.show(f3).hide(f2).hide(f1).hide(f4).commit();
                        break;
                    case R.id.tab_mine:
                        ft.show(f4).hide(f2).hide(f3).hide(f1).commit();
                        break;
                    case R.id.tab_robot:
                        if(robotCount==0){
                            Toast.makeText(MainActivity.this, "在我的BGM里,没人能打败我!", Toast.LENGTH_SHORT).show();
                            robotCount++;
                            robot.removeBadge();
                        }
                        break;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void initDrawer() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //开源库
        new DrawerBuilder().withActivity(this).build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        final PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Free Play");
        SwitchDrawerItem item3 = new SwitchDrawerItem().withIdentifier(3).withName("Mode")
                .withChecked(false).withOnCheckedChangeListener(checkedChangeListener);
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Settings");
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(5).withName("About");

        final AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.sea2)
                .addProfiles(
                        new ProfileDrawerItem().withName("Song Da").withEmail("youysong@gmail.com")
                                .withIcon(getResources().getDrawable(R.drawable.meizi)))
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return true;
                    }
                })
                .addProfiles(new ProfileDrawerItem().withIcon(getResources().getDrawable(R.drawable.cat)))
                .addProfiles(new ProfileDrawerItem().withIcon(getResources().getDrawable(R.drawable.he)))
                .withSelectionListEnabledForSingleProfile(false)
//                .withThreeSmallProfileImages(true)
                .build();
//        headerResult.getHeaderBackgroundView().setAdjustViewBounds(true);
//        headerResult.getView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
//    //create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        item5
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        Toast.makeText(MainActivity.this, "you clicked the item" + position, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
//                .withSliderBackgroundColor(0xaa433053)
                .withAccountHeader(headerResult)
                .withTranslucentStatusBar(false)
                .withFullscreen(true)
                .build();

        result.setFullscreen(true);
//        result.openDrawer();
//        result.closeDrawer();
        result.addItem(new DividerDrawerItem());
//        result.addStickyFooterItem(new PrimaryDrawerItem().withName("StickyFooterItem"));

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

//        result.getDrawerLayout().setBackgroundColor(0xaa433053);
    }

//    private void changeImageSize() {
//        //定义底部标签图片大小
//        Drawable drawableHome = getResources().getDrawable(R.drawable.tab_home_bg);
//        drawableHome.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
//        home.setCompoundDrawables(null, drawableHome, null, null);//只放上面
//
//        Drawable drawableTweet = getResources().getDrawable(R.drawable.tab_picture_bg);
//        drawableTweet.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
//        picture.setCompoundDrawables(null, drawableTweet, null, null);//只放上面
//
//        Drawable drawableDiscover = getResources().getDrawable(R.drawable.tab_discover_bg);
//        drawableDiscover.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
//        discover.setCompoundDrawables(null, drawableDiscover, null, null);//只放上面
//
//        Drawable drawableMine = getResources().getDrawable(R.drawable.tab_mine_bg);
//        drawableMine.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
//        mine.setCompoundDrawables(null, drawableMine, null, null);//只放上面
//
//        Drawable drawableLogin = getResources().getDrawable(R.drawable.ic_add);
//        drawableLogin.setBounds(0, 8, 74, 84);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
//        login.setCompoundDrawables(null, drawableLogin, null, null);//只放上面
//    }

    private void initFragment() {
        f1 = new HomeFragment();
        f2 = new JuheFragment();
        f3 = new DiscoverFragment();
        f4 = new MineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, f1, "home")
                .add(R.id.container, f2, "picture")
                .add(R.id.container, f3, "discover")
                .add(R.id.container, f4, "mine")
                .commit();
        getSupportFragmentManager().beginTransaction()
                .hide(f2)
                .hide(f3)
                .hide(f4)
                .commit();
    }

    private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            //改变主题:自动根据当前主题改变白天和黑夜
            SkinManager.changeSkin(MainActivity.this);
            //改变主题:指定主题
            //SkinManager.changeSkin(this,R.style.DayTheme);
            //重启当前Activity
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            //重要:做一个自定义动画,避免出现闪烁现象
            overridePendingTransition(com.maning.themelibrary.R.anim.mn_theme_activity_enter, com.maning.themelibrary.R.anim.mn_theme_activity_exit);
            finish();
        }
    };

}

