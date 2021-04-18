package com.alifyacode.aplikasigithubuser.ActivityFile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.ApiHelp.UGthbApiServ;
import com.alifyacode.aplikasigithubuser.ApiHelp.UGthbSearchRespon;
import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.TheAdapters.UGthbAdaptSearch;
import com.alifyacode.aplikasigithubuser.TheAdapters.UGthbAdaptUser;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UGthbMainActivity extends AppCompatActivity {
    UGthbAdaptUser adptrusr;
    ProgressBar redload;
    RecyclerView rsvw;
    ImageView ftusr,Favftusr;
    SearchView srchfrusr;
    UGthbApiServ apiservfrusr;
    private static Retrofit rtrf;

    public static Retrofit getRetro(){
        if (rtrf == null){
            rtrf = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return rtrf;
    }

    private void srchgthbusr(String username){
        apiservfrusr = getRetro().create(UGthbApiServ.class);
        Call<UGthbSearchRespon> summon = apiservfrusr.getUGthbSrch(username);
        summon.enqueue(new Callback<UGthbSearchRespon>() {
            @Override
            public void onResponse(Call<UGthbSearchRespon> summon, Response<UGthbSearchRespon> reply) {
                if (reply.body() != null){
                    rsvw.setAdapter(new UGthbAdaptSearch(reply.body().getItems()));
                }
            }

            @Override
            public void onFailure(Call<UGthbSearchRespon> summon, Throwable put) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugthb_main);
        rsvw = findViewById(R.id.rvUsr);
        srchfrusr = findViewById(R.id.srch);
        redload = findViewById(R.id.rdld);
        rsvw.setLayoutManager(new LinearLayoutManager(this));
        srchfrusr.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                srchgthbusr(newText);
                return false;
            }
        });
        if (getSupportActionBar() != null){
        getSupportActionBar().hide();
    }
    ftusr = findViewById(R.id.sttngs);
    Favftusr = findViewById(R.id.ftfav);
        ftusr.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), UGthbSettingActivity.class)));
        Favftusr.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), UGthbFavActivity.class)));
        apiservfrusr = getRetro().create(UGthbApiServ.class);
        Call<List<UsrGthb>> summon = apiservfrusr.getUsrGthb("4430d5ce7975b0a45010a866781db971b42a76bb");
        summon.enqueue(new Callback<List<UsrGthb>>() {
        @Override
        public void onResponse(Call<List<UsrGthb>> summon, Response<List<UsrGthb>> reply) {
            if (reply.body() != null){
                adptrusr = new UGthbAdaptUser(getApplicationContext(),reply.body());
                rsvw.setAdapter(adptrusr);
                redload.setVisibility(View.GONE);

            }

        }

        @Override
        public void onFailure(Call<List<UsrGthb>> summon, Throwable put) {

        }
    });
}}