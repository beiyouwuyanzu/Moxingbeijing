package com.beiyouwuyanzu.moxingbeijing.base;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.beiyouwuyanzu.huadongcaidan.MainActivity;
//import com.beiyouwuyanzu.huadongcaidan.R;
import com.beiyouwuyanzu.moxingbeijing.MainActivity;
import com.beiyouwuyanzu.moxingbeijing.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import static android.content.ContentValues.TAG;

//import com.beiyouwuyanzu.huadongcaidan.MainActivity;

/**
 * 五个标签页的基类
 * 
 * @author Kevin
 * @date 2015-10-18
 */
public class BasePager {

	public Activity mActivity;

	public TextView tvTitle;
	public Button btnMenu;
	public FrameLayout flContent;// 空的帧布局对象, 要动态添加布局

	public View mRootView;// 当前页面的布局对象

	public BasePager(Activity activity) {
		mActivity = activity;
		mRootView = initView();
	}

	// 初始化布局
	public View initView() {
		View view = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		btnMenu = (Button) view.findViewById(R.id.btn_menu);
		flContent = (FrameLayout) view.findViewById(R.id.fl_content);

		btnMenu.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				Log.i(TAG, "onClick: 按钮被点击了");
				toggle();
			}
		});

		return view;
	}

	/**
	 * 打开或者关闭侧边栏
	 */
	protected void toggle() {
		MainActivity mainUI = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUI.getSlidingMenu();
		slidingMenu.toggle();// 如果当前状态是开, 调用后就关; 反之亦然
	}

	// 初始化数据
	public void initData() {

	}
}
