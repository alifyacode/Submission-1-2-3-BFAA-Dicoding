package com.alifyacode.aplikasigithubuser.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.Ui.Fragment.FollowersFragment;
import com.alifyacode.aplikasigithubuser.Ui.Fragment.FollowingFragment;

import java.util.Objects;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final Context context;
    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FollowersFragment();
                break;
            case 1:
                fragment = new FollowingFragment();
                break;
        }
        return Objects.requireNonNull(fragment);
    }


    private final int[] TAB_NAME = new int[]{
            R.string.followers,
            R.string.following
    };
    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_NAME[position]);
    }
}
