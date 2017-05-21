package com.example.cnsunrun.debugdemo.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.cnsunrun.debugdemo.R;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.CommunityFragment;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.CopyListFragment;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.MineFragment;
import com.example.cnsunrun.debugdemo.mvp.ui.fragment.QuanziListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cnsunrun on 2017/4/19.
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.bottom_navigation)
    AHBottomNavigation mAhBottomNavigation;

    private int currentTabIndex;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        fragments.add(CopyListFragment.newInstance());
        fragments.add(QuanziListFragment.newInstance());
        fragments.add(CommunityFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        showFragment(fragments.get(0));
        initBottomNav();

    }

    private void showFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

    private void initBottomNav() {

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("主页",
                R.drawable.ic_tab_home);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("圈子",
                R.drawable.ic_tab_quanzi);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("社区",
                R.drawable.ic_tab_community);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("我的",
                R.drawable.ic_tab_mine);

        mAhBottomNavigation.addItem(item1);
        mAhBottomNavigation.addItem(item2);
        mAhBottomNavigation.addItem(item3);
        mAhBottomNavigation.addItem(item4);

        mAhBottomNavigation.setColored(false);
        mAhBottomNavigation.setForceTint(false);
        mAhBottomNavigation.setBehaviorTranslationEnabled(true);
        mAhBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mAhBottomNavigation.setAccentColor(getResources().getColor(R.color.colorPrimaryDark));
        mAhBottomNavigation.setInactiveColor(getResources().getColor(R.color.colorPrimaryDark));
        mAhBottomNavigation.setCurrentItem(0);
        mAhBottomNavigation.setDefaultBackgroundColor(
                getResources().getColor(R.color.colorPrimary));

        mAhBottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {

            if (currentTabIndex != position) {
                FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                trx.hide(fragments.get(currentTabIndex));
                if (!fragments.get(position).isAdded()) {
                    trx.add(R.id.content, fragments.get(position));
                }
                trx.show(fragments.get(position)).commit();
            }
            currentTabIndex = position;

            return true;
        });
    }
}
