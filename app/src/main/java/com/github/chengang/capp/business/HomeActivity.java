package com.github.chengang.capp.business;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.github.chengang.base.acitivity.BaseActivity;
import com.github.chengang.capp.MessageFragment;
import com.github.chengang.capp.MineFragment;
import com.github.chengang.capp.MyFragmentPagerAdapter;
import com.github.chengang.capp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.mViewPager)
    ViewPager mViewPager;

    @Bind(R.id.mTabLayout)
    TabLayout mTabLayout;

    private List<Fragment> fragmentList;

    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_home);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        fragmentList = new ArrayList<>();
        fragmentList.add(MessageFragment.newInstance("menuMessage"));
        fragmentList.add(MineFragment.newInstance("menuMine"));
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("信息");
        mTabLayout.getTabAt(1).setText("我的");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void HandleIntent(Intent intent) {

    }
}
