package com.example.chapter3.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * 使用 ViewPa ger 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {


        private TabLayout tabLayout;
        private ViewPager viewPager;

        private MyAdapter adapter;
        private final String[] titles = {"friends", "neighbour", "colleague"};
        private  String[][] names = {
                {"lihua","xiaoming","zhangsan","lisi"},
                {"huniu","goudan","shanyu","xiaoduan"},
                {"Amanda","Lily","Jack","Sam"}
        };

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ch3ex3);

            //实例化
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            tabLayout = (TabLayout) findViewById(R.id.tablayout);

            //ViewPager的适配器
            adapter = new MyAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            //绑定
            tabLayout.setupWithViewPager(viewPager);
        }

        class MyAdapter extends FragmentPagerAdapter {
            public MyAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                PlaceholderFragment myFragment = new PlaceholderFragment();
                Bundle args = new Bundle();
                args.putStringArray("names",names[position]);
                myFragment.setArguments(args);
                return myFragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            //重写这个方法，将设置每个Tab的标题
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }


        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面



        // TODO: ex3-2, 添加 TabLayout 支持 Tab
    }

}
