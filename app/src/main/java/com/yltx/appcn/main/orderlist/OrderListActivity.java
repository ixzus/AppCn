package com.yltx.appcn.main.orderlist;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yltx.appcn.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/order/OrderListActivity")
public class OrderListActivity extends RxAppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private Fragment waitFragment;
    private Fragment dealFragment;
    private Fragment rejectFragment;
    private Fragment refuseFragment;
    private Fragment finishFragment;
    private List<Fragment> viewList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    private int curIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);
        initToolbar(this);
        toolbar("待接单", true, null);
        initFragment();
        try {
            curIndex = getIntent().getIntExtra("orderType", 0);
        } catch (Exception e) {
            curIndex = 0;
            e.printStackTrace();
        }
        if (curIndex > 0 && curIndex < viewList.size()) {
            viewPager.setCurrentItem(curIndex);
            tabLayout.getTabAt(curIndex).select();
        }
    }

    private void initFragment() {
        viewList.clear();
        titleList.clear();
        titleList.add("待接单");
        titleList.add("待办理");
        titleList.add("已驳回");
        titleList.add("已拒单");
        titleList.add("已完成");
        waitFragment = OrderListFragment.newInstance("WAIT", "");
        dealFragment = OrderListFragment.newInstance("DEAL", "");
        rejectFragment = OrderListFragment.newInstance("REJECT", "");
        refuseFragment = OrderListFragment.newInstance("REFUSE", "");
        finishFragment = OrderListFragment.newInstance("FINISH", "");
        for (String s : titleList) {
            tabLayout.addTab(tabLayout.newTab().setText(s));
        }
        viewList.add(waitFragment);
        viewList.add(dealFragment);
        viewList.add(rejectFragment);
        viewList.add(refuseFragment);
        viewList.add(finishFragment);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return viewList.get(position);
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }

        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbar(titleList.get(position), true, null);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initToolbar(final Activity activity) {
        if (findViewById(com.ixzus.applibrary.R.id.toolbar) != null) {
            if (activity instanceof AppCompatActivity) {
                setSupportActionBar((Toolbar) findViewById(com.ixzus.applibrary.R.id.toolbar));
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    setActionBar((android.widget.Toolbar) findViewById(com.ixzus.applibrary.R.id.toolbar));
                    getActionBar().setDisplayShowTitleEnabled(false);
                }
            }
        }

        if (findViewById(com.ixzus.applibrary.R.id.toolbar_back) != null) {
            findViewById(com.ixzus.applibrary.R.id.toolbar_back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }

    }

    protected void toolbar(String centerText, boolean isBack, String backText) {
        if (isBack) {
            findViewById(com.ixzus.applibrary.R.id.toolbar_back).setVisibility(View.VISIBLE);
            findViewById(com.ixzus.applibrary.R.id.toolbar_line).setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(backText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_title)).setText(centerText);
        }

    }
}
