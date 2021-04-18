package com.alifyacode.aplikasigithubuser.Ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.alifyacode.aplikasigithubuser.Adapter.ViewPagerAdapter;
import com.alifyacode.aplikasigithubuser.Connection.ApiService;
import com.alifyacode.aplikasigithubuser.Connection.RetrofitConfiguration;
import com.alifyacode.aplikasigithubuser.Model.User;
import com.alifyacode.aplikasigithubuser.Model.UserDetail;
import com.alifyacode.aplikasigithubuser.R;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView repo,follower,following,username;
    private ImageView avatar;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this,getSupportFragmentManager());
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setElevation(0);
        setDataDetailUser();


        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail " + user.getLogin());
        }
    }

    private void setDataDetailUser(){
        user = getIntent().getParcelableExtra("DATA_USER");
        if (user != null){
            progressBar = findViewById(R.id.progressBar);
            repo = findViewById(R.id.tv_repo);
            follower = findViewById(R.id.tv_followers);
            following = findViewById(R.id.tv_following);
            username = findViewById(R.id.tv_username);
            avatar = findViewById(R.id.image_user_detail);

            final LinearLayout linearLayout = findViewById(R.id.linear_layout);
            ApiService apiService = RetrofitConfiguration.getRetrofit().create(ApiService.class);
            Call<UserDetail> call = apiService.getUserDetail(user.getLogin());
            call.enqueue(new Callback<UserDetail>() {
                @Override
                public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                    if (response.body() != null){
                        repo.setText(String.valueOf(response.body().getPublicRepos()));
                        follower.setText(String.valueOf(response.body().getFollowers()));
                        following.setText(String.valueOf(response.body().getFollowing()));
                        username.setText(response.body().getName());
                        Glide.with(getApplicationContext())
                                .load(response.body().getAvatarUrl())
                                .into(avatar);
                        username.setVisibility(View.VISIBLE);
                        avatar.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);

                    }
                }

                @Override
                public void onFailure(Call<UserDetail> call, Throwable t) {

                }
            });
        }
    }
}