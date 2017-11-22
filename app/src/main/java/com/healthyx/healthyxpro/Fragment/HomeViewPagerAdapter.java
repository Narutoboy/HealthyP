package com.healthyx.healthyxpro.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList();
    private final List<String> mFragmentTitles = new ArrayList();

    public HomeViewPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    public Fragment getItem(int position) {

        return (Fragment) this.mFragmentList.get(position);
    }

    public CharSequence getPageTitle(int position) {

        return (CharSequence) this.mFragmentTitles.get(position);
    }

    public int getCount() {
        return this.mFragmentTitles.size();
    }

    public void addFragments(Fragment fragment, String title) {
        this.mFragmentList.add(fragment);
        this.mFragmentTitles.add(title);
    }
}
