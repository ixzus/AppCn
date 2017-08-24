package com.yltx.appcn;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.FragmentUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.main.home.HomeFragment;
import com.yltx.appcn.main.my.MyInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/app/MainActivity")
public class MainActivity extends RxAppCompatActivity {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_home)
    TextView mainHome;
    @BindView(R.id.main_my)
    TextView mainMy;
    @BindView(R.id.main_menu)
    LinearLayout mainMenu;
    //
    private HomeFragment homeFragment;
    private MyInfoFragment myFragment;
    private int index = R.id.main_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFragment(index);
    }

    @OnClick({R.id.main_home, R.id.main_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                showFragment(R.id.main_home);
                break;
            case R.id.main_my:
                showFragment(R.id.main_my);
                break;
        }
    }

    private void showFragment(@IdRes int position) {
        index = position;
        showIcon(index);
        if (R.id.main_home == index) {
            if (null != myFragment) {
                FragmentUtils.hideFragment(myFragment);
            }
            if (null == homeFragment) {
                homeFragment = HomeFragment.newInstance(null, null);
                FragmentUtils.addFragment(getSupportFragmentManager(), homeFragment, R.id.main_frame);
            } else {
                FragmentUtils.showFragment(homeFragment);
            }
            return;
        }
        if (R.id.main_my == index) {
            if (null != homeFragment) {
                FragmentUtils.hideFragment(homeFragment);
            }
            if (null == myFragment) {
//                myFragment = MyFragment.newInstance(null, null);

                myFragment = MyInfoFragment.newInstance(null, null);
                FragmentUtils.addFragment(getSupportFragmentManager(), myFragment, R.id.main_frame);
            } else {
                FragmentUtils.showFragment(myFragment);
            }
            return;
        }
    }

    private void showIcon(@IdRes int position) {
        Drawable drawable;
        if (R.id.main_home == position) {
            drawable = getResources().getDrawable(R.mipmap.main_home_press);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mainHome.setCompoundDrawables(null, drawable, null, null);
            mainHome.setTextColor(getResources().getColor(R.color.tv_menu_press));

            drawable = getResources().getDrawable(R.mipmap.main_my_normal);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mainMy.setCompoundDrawables(null, drawable, null, null);
            mainMy.setTextColor(getResources().getColor(R.color.tv_menu_normal));

            return;
        }
        if (R.id.main_my == position) {
            drawable = getResources().getDrawable(R.mipmap.main_my_press);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mainMy.setCompoundDrawables(null, drawable, null, null);
            mainMy.setTextColor(getResources().getColor(R.color.tv_menu_press));

            drawable = getResources().getDrawable(R.mipmap.main_home_normal);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mainHome.setCompoundDrawables(null, drawable, null, null);
            mainHome.setTextColor(getResources().getColor(R.color.tv_menu_normal));

            return;
        }
    }

    private void goNext() {
        ARouter.getInstance().build("/login/loginActivity").navigation(MainActivity.this);
        finish();
    }

}
