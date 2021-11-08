package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.NamespaceContext;

public class PlaceholderFragment extends Fragment {

    private String[] namelist;
    private ListView my_listView;
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View viewRoot = inflater.inflate(R.layout.fragment_placeholder, container, false);
        Bundle bundle = this.getArguments();
        my_listView = viewRoot.findViewById(R.id.list);
        animationView = viewRoot.findViewById(R.id.animation_task3);
        namelist = bundle.getStringArray("names");
        return viewRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView, "alpha", 1, 0f);
//                animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(1000);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (getContext(), android.R.layout.simple_list_item_1, namelist);
                my_listView.setAdapter(adapter);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(my_listView, "alpha", 0, 1f);
//                animator2.setInterpolator(new LinearInterpolator());
                animator2.setDuration(1000);

                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator2);
                animatorSet.start();
            }
        }, 5000);
    }

}