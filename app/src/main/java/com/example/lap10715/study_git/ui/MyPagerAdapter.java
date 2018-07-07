package com.example.lap10715.study_git.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nahuy on 7/7/18.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static final int NUMBER_PAGER = 4;
    private FragmentManager fm;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NowPlayingFragment();
            case 1:
                return new TopRatedFragment();
            case 2:
                return new PopularFragment();
            case 3:
                return new UpComingFragment();
            default:
                return new NowPlayingFragment();

        }
    }

    @Override
    public int getCount() {
        return NUMBER_PAGER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Now playing";
            case 1:
                return "Top rated";
            case 2:
                return "Popular";
            case 3:
                return "Up coming";
            default:
                return "Now playing";
        }
    }
}
