package com.alifyacode.aplikasigithubuser.TheFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.ApiHelp.UGthbApiServ;
import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.TheAdapters.UGthbAdaptUser;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UGthbFol1Fr extends Fragment {
    private static Retrofit rtrf;
    UGthbApiServ api_srvc;
    UsrGthb usr;
    ProgressBar redload;
    View vw;
    private static Retrofit Rtrfh(){
        if (rtrf == null){
            rtrf = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return rtrf;
    }

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup cntn, Bundle svdInstSt) {
        vw = inf.inflate(R.layout.fragment_ugthb_fol2, cntn, false);
        shwdataFol1ugthb(vw);
        return vw;
    }

    private void shwdataFol1ugthb(View vw){
        redload = vw.findViewById(R.id.rdld);
        RecyclerView rcyv = vw.findViewById(R.id.rvUsr);
        rcyv.setLayoutManager(new LinearLayoutManager(getContext()));
        usr = Objects.requireNonNull(getActivity()).getIntent().getParcelableExtra("DATA_USER");
        api_srvc = Rtrfh().create(UGthbApiServ.class);
        Call<List<UsrGthb>> summon = api_srvc.getUsrFol1(Objects.requireNonNull(usr).getLogin());
        summon.enqueue(new Callback<List<UsrGthb>>() {
            @Override
            public void onResponse(Call<List<UsrGthb>> summon, Response<List<UsrGthb>> reply) {
                UGthbAdaptUser adapterUser;
                redload.setVisibility(View.GONE);
                rcyv.setAdapter(new UGthbAdaptUser(getContext(),reply.body()));
            }

            @Override
            public void onFailure(Call<List<UsrGthb>> summon, Throwable put) {

            }
        });
    }
}