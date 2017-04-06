package com.github.chengang.capp.business;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.github.chengang.base.acitivity.BaseActivity;
import com.github.chengang.base.adapter.BaseViewPagerAdapter;
import com.github.chengang.capp.R;
import com.github.chengang.widgets.RecyclerImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.squareup.picasso.MemoryPolicy.NO_CACHE;
import static com.squareup.picasso.MemoryPolicy.NO_STORE;

public class SplashActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    @Bind(R.id.ivGuide1)
    RecyclerImageView ivGuide1;

    @Bind(R.id.ivGuide2)
    RecyclerImageView ivGuide2;

    @Bind(R.id.ivGuide3)
    RecyclerImageView ivGuide3;

    @Bind(R.id.ivGuide4)
    RecyclerImageView ivGuide4;

    @Bind(R.id.ivGuide5)
    RecyclerImageView ivGuide5;

    @Bind(R.id.ivCloseGuide)
    RecyclerImageView ivCloseGuide;

    @Bind(R.id.btnStart)
    Button btnStart;

    @Bind(R.id.viewPagerGuide)
    ViewPager viewPager;

    private BaseViewPagerAdapter viewPagerAdapter;

    private List<View> viewList;

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //将关闭的按钮置顶
        ivCloseGuide.bringToFront();

        viewPager.addOnPageChangeListener(this);
        btnStart.setOnClickListener(this);
        ivCloseGuide.setOnClickListener(this);

        viewList = new ArrayList<>();
    }

    @Override
    protected void initData() {
        int[] imgResIds = new int[]{R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3, R.drawable.guide_image4, R.drawable.guide_image5};

        initGuideImg(imgResIds);

        viewPagerAdapter = new BaseViewPagerAdapter(viewList);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void HandleIntent(Intent intent) {

    }

    private void initGuideImg(int[] imgResIds) {
        LayoutInflater inflater = getLayoutInflater();
        for (int imgResId : imgResIds) {
            View view = inflater.inflate(R.layout.splash_item, null);
//            ((ImageView) view.findViewById(R.id.image_view)).setImageResource(imgResId);
            RecyclerImageView imageView = (RecyclerImageView) view.findViewById(R.id.image_view);
            Picasso.with(this).load(imgResId).memoryPolicy(NO_CACHE, NO_STORE).into(imageView);
            viewList.add(view);
        }

    }

    /*-------------------------viewPager滑动监听-----------------------*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 4) {
            btnStart.setVisibility(View.VISIBLE);
        } else {
            btnStart.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageSelected(int position) {
        initButtomGuide();
        switch (position) {
            case 0:
                Picasso.with(this).load(R.drawable.welcome_selected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide1);
                break;
            case 1:
                Picasso.with(this).load(R.drawable.welcome_selected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide2);
                break;
            case 2:
                Picasso.with(this).load(R.drawable.welcome_selected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide3);
                break;
            case 3:
                Picasso.with(this).load(R.drawable.welcome_selected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide4);
                break;
            default:
                Picasso.with(this).load(R.drawable.welcome_selected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide5);
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*-------------------------viewPager滑动监听--end-----------------------*/

    /**
     * 重置引导页下标
     */
    private void initButtomGuide() {
        Picasso.with(this).load(R.drawable.welcome_unselected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide1);
        Picasso.with(this).load(R.drawable.welcome_unselected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide2);
        Picasso.with(this).load(R.drawable.welcome_unselected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide3);
        Picasso.with(this).load(R.drawable.welcome_unselected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide4);
        Picasso.with(this).load(R.drawable.welcome_unselected).memoryPolicy(NO_CACHE, NO_STORE).into(ivGuide5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                toLogin();
                break;
            case R.id.ivCloseGuide:
                toLogin();
                break;
        }

    }

    private void toLogin(){
        Intent loginIntent = new Intent(this, HomeActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
