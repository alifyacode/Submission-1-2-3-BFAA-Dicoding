package com.alifyacode.aplikasigithubuser.TheAdapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.TheFragments.UGthbFol1Fr;
import com.alifyacode.aplikasigithubuser.TheFragments.UGthbFol2Fr;

import java.util.Objects;

public class UGthbViewPageAdapt extends FragmentPagerAdapter {
    Fragment frgmnt = null;
    private final Context cntxt;
    public UGthbViewPageAdapt(Context cntxt, FragmentManager framan) {
        super(framan, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.cntxt = cntxt;
    }

    private final int[] U_GTHB_TAB_NAME = new int[]{
            R.string.fol2,
            R.string.fol1
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                frgmnt = new UGthbFol1Fr();
                break;
            case 1:
                frgmnt = new UGthbFol2Fr();
                break;
        }
        return Objects.requireNonNull(frgmnt);
    }


    @Override
    public int getCount() {
        return U_GTHB_TAB_NAME.length;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return cntxt.getResources().getString(U_GTHB_TAB_NAME[position]);
    }
}
