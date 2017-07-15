package com.example.wind.osnews;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wind.osnews.fragment.DiscoverFragment;
import com.example.wind.osnews.fragment.HomeFragment;
import com.example.wind.osnews.fragment.MineFragment;
import com.example.wind.osnews.fragment.JuheFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import butterknife.BindView;
import butterknife.ButterKnife;

//fragmentTransaction变量定义为全局变量，导致只能commit一次，所以只要将FragmentTransaction变量定义为局部变量即可。

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.picture)
    RadioButton picture;
    @BindView(R.id.discover)
    RadioButton discover;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.login)
    RadioButton login;
    private Fragment f1, f2, f3, f4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDrawer();

        initFragment();

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_tabs);
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
                        Toast.makeText(MainActivity.this, "YYYY", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void initDrawer() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //开源库
        new DrawerBuilder().withActivity(this).build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        final PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Free Play");
        SecondaryDrawerItem item3=new SecondaryDrawerItem().withIdentifier(3).withName("Custom");
        SecondaryDrawerItem item4=new SecondaryDrawerItem().withIdentifier(4).withName("Settings");
        SecondaryDrawerItem item5=new SecondaryDrawerItem().withIdentifier(5).withName("About");
//        MakeCircle.getCircleBitmap(

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.abg)
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
                .withThreeSmallProfileImages(true)
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
                        Toast.makeText(MainActivity.this,"you clicked the item"+position,Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
                .withSliderBackgroundColor(0xaa433053)
                .withAccountHeader(headerResult)
                .build();

//        result.openDrawer();
//        result.closeDrawer();
        result.addItem(new DividerDrawerItem());
//        result.addStickyFooterItem(new PrimaryDrawerItem().withName("StickyFooterItem"));

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

//        result.getDrawerLayout().setBackgroundColor(0xaa433053);
    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableHome = getResources().getDrawable(R.drawable.tab_home_bg);
        drawableHome.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        home.setCompoundDrawables(null, drawableHome, null, null);//只放上面

        Drawable drawableTweet = getResources().getDrawable(R.drawable.tab_picture_bg);
        drawableTweet.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        picture.setCompoundDrawables(null, drawableTweet, null, null);//只放上面

        Drawable drawableDiscover = getResources().getDrawable(R.drawable.tab_discover_bg);
        drawableDiscover.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        discover.setCompoundDrawables(null, drawableDiscover, null, null);//只放上面

        Drawable drawableMine = getResources().getDrawable(R.drawable.tab_mine_bg);
        drawableMine.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mine.setCompoundDrawables(null, drawableMine, null, null);//只放上面

        Drawable drawableLogin = getResources().getDrawable(R.drawable.ic_add);
        drawableLogin.setBounds(0, 8, 74, 84);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        login.setCompoundDrawables(null, drawableLogin, null, null);//只放上面
    }

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

}

