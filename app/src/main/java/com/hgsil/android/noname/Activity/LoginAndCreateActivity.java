package com.hgsil.android.noname.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;


import com.hgsil.android.noname.Adapter.MyFragmentPagerAdapter;
import com.hgsil.android.noname.Fragement.LoginAndCreateActivity.Image1;
import com.hgsil.android.noname.Fragement.LoginAndCreateActivity.Image2;
import com.hgsil.android.noname.Fragement.LoginAndCreateActivity.Image3;
import com.hgsil.android.noname.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class LoginAndCreateActivity extends FragmentActivity implements View.OnClickListener{
    private ViewPager mViewPager ;
    private MyFragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> mFragments  = new ArrayList<>();

    private ImageView tabCircle1;
    private ImageView tabCircle2;
    private ImageView tabCircle3;
    private List<ImageView> mCircles = new ArrayList<>();

    private CardView create;
    private CardView login;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    resetTabBtn(1);
                    break;
                case 2:
                    resetTabBtn(2);
                    break;
                case 3:
                    resetTabBtn(3);
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_loginandcreate);
        mViewPager = (ViewPager) findViewById(R.id.loginandcreate_viewpager);
        initView();

        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragments);
        mViewPager.setAdapter(mFragmentPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int currentIndex;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Message message = new Message();
                switch (position)
                {
                    case 0:
                        message.what = 1 ;
                        mHandler.sendMessage(message);
                        break;
                    case 1:
                        message.what = 2 ;
                        mHandler.sendMessage(message);
                        break;
                    case 2:
                        message.what = 3 ;
                        mHandler.sendMessage(message);
                        break;
                }

                currentIndex = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        create.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    protected void resetTabBtn(int numberOfSelect)
    {
        for (int i = 0; i <mCircles.size() ; i++) {
            if (i == (numberOfSelect-1))
                mCircles.get(i).setImageResource(R.mipmap.tab_circle_touch);
            else
                mCircles.get(i).setImageResource(R.mipmap.tab_circle_notouch);
        }

    }


    private void initView(){
        create = (CardView)findViewById(R.id.loginandcreate_create_cardview);
        login = (CardView)findViewById(R.id.loginandcreate_login_cardview);

        tabCircle1 = (ImageView)findViewById(R.id.loginandcreate_tab_circle1);
        tabCircle2 = (ImageView)findViewById(R.id.loginandcreate_tab_circle2);
        tabCircle3 = (ImageView)findViewById(R.id.loginandcreate_tab_circle3);
        mCircles.add(tabCircle1);
        mCircles.add(tabCircle2);
        mCircles.add(tabCircle3);
        resetTabBtn(1);

        Image1 image1 = new Image1();
        Image2 image2 = new Image2();
        Image3 image3 = new Image3();

        mFragments.add(image1);
        mFragments.add(image2);
        mFragments.add(image3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginandcreate_create_cardview:
            case R.id.loginandcreate_login_cardview:
        }
    }
}
