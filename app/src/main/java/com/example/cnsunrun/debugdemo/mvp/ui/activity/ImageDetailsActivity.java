package com.example.cnsunrun.debugdemo.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.ImageDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnsunrun on 2017/4/24.
 */

public class ImageDetailsActivity extends AppCompatActivity {


    @Bind(R.id.tv_index)
    TextView mIndex;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;
    private ArrayList<String> images_url;
    private int index;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        ButterKnife.bind(this);
        index = getIntent().getIntExtra("index", -1);
        images_url = getIntent().getStringArrayListExtra("images_url");

        initView();
    }

    private void initView() {
        mIndex.setText((index + 1) + " / " + images_url.size());
        ImageViewPagerAdapter mAdapter = new ImageViewPagerAdapter(getSupportFragmentManager(), images_url);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mIndex.setText((position + 1) + " / " + images_url.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.setCurrentItem(index);
    }

    private static class ImageViewPagerAdapter extends FragmentPagerAdapter {

        private List<String> urls;

        public ImageViewPagerAdapter(FragmentManager fm, List<String> urls) {
            super(fm);
            this.urls = urls;
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailsFragment.newInstance(urls.get(position));
        }

        @Override
        public int getCount() {
            return urls.size();
        }
    }
}
