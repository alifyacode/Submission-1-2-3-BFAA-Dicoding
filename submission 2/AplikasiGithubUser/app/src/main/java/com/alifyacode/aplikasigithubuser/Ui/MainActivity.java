package com.alifyacode.aplikasigithubuser.Ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.Adapter.AdapterSearch;
import com.alifyacode.aplikasigithubuser.Adapter.AdapterUser;
import com.alifyacode.aplikasigithubuser.Connection.ApiService;
import com.alifyacode.aplikasigithubuser.Connection.RetrofitConfiguration;
import com.alifyacode.aplikasigithubuser.Model.ResponseSearch;
import com.alifyacode.aplikasigithubuser.Model.User;
import com.alifyacode.aplikasigithubuser.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView rv;
    private ShimmerFrameLayout shimmerFrameLayout;
    private SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        getDataUser();
        init();


    }

    private void init() {
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
    private void initViews() {
        rv = findViewById(R.id.rv_user);
        sv = findViewById(R.id.sv_user);
        progressBar = findViewById(R.id.progressBar);
        shimmerFrameLayout = findViewById(R.id.shimmer_layout);
        rv.setLayoutManager(new LinearLayoutManager(this));
        shimmerFrameLayout.startShimmer();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getSearchUser(newText);
                return false;
            }
        });
    }
    private void getDataUser(){
        ApiService apiService = RetrofitConfiguration.getRetrofit().create(ApiService.class);
        Call<List<User>> call = apiService.getGithubUser("4430d5ce7975b0a45010a866781db971b42a76bb");
        call.enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                AdapterUser adapterUser = new AdapterUser(getApplicationContext(),response.body());
                rv.setAdapter(adapterUser);
                shimmerFrameLayout.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                shimmerFrameLayout.stopShimmer();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
    private void getSearchUser(String username){
        ApiService apiService = RetrofitConfiguration.getRetrofit().create(ApiService.class);
        Call<ResponseSearch> call = apiService.getGithubSearch(username);
        call.enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {

                if (response.body() != null){
                    AdapterSearch adapterSearch = new AdapterSearch(response.body().getItems());
                    rv.setAdapter(adapterSearch);
                }
            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {

            }
        });
    }
}






