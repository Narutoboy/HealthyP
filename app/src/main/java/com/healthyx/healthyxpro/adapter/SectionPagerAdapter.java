package com.healthyx.healthyxpro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 03-11-2017.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList();
    private final List<String> mFragmentTitles = new ArrayList();

    @Override
    public String toString() {
        return "SectionPagerAdapter{}";
    }
    public void addFragments(Fragment fragment, String title) {
        this.mFragmentList.add(fragment);
        this.mFragmentTitles.add(title);
    }
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
