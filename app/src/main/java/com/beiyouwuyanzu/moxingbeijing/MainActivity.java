package com.beiyouwuyanzu.moxingbeijing;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.util.Log;
import android.view.Window;

import com.beiyouwuyanzu.moxingbeijing.fragment.ContentFragment;
import com.beiyouwuyanzu.moxingbeijing.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends  SlidingFragmentActivity {

    private static final String TAG_LEFT_MENU ="TAG_LEFT_MENU";
    private static final String TAG_CONTENT ="TAG_CONTENT" ;
    private static final String TAG = "MainActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.left);
        SlidingMenu slidingMenu = getSlidingMenu();//新建了一个slidingmenu
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 全屏触摸
        slidingMenu.setBehindOffset(200);// 屏幕预留200像素宽度
        Log.i(TAG, "onCreate: 准备加载Fragement");
        initFragment();
        Log.i(TAG, "onCreate: init加载完毕，为什么还会崩啊");

    }

    private void initFragment() {

        FragmentManager fm = getSupportFragmentManager();//新建了一个fragmentmanager管理器
        FragmentTransaction transaction = fm.beginTransaction();// 开始事务
        Log.i(TAG, "initFragment: 即将替换左边的");
        transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),
                TAG_LEFT_MENU);// 用fragment替换帧布局;参1:帧布局容器的id;参2:是要替换的fragment;参3:标记
        Log.i(TAG, "initFragment: 吧左边的替换完成");
        transaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
        Log.i(TAG, "initFragment: 右边的替换完成");
        transaction.commit();// 提交事务
        Log.i(TAG, "initFragment: 提交完成");
    }

}
