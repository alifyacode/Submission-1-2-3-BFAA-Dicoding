package com.alifyacode.aplikasigithubuser.ActivityFile;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.alifyacode.aplikasigithubuser.ApiHelp.UGthbApiServ;
import com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract;
import com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbHlpr;
import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.TheAdapters.UGthbViewPageAdapt;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UGthbDet;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UGthbHelp;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;
import com.bumptech.glide.Glide;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.alifyacode.aplikasigithubuser.DatabasesStructure.UGthb_DbContract.UGthbClmn.UGthb_Table;

public class UGthbDetailActivity extends AppCompatActivity {
    ArrayList<UsrGthb> UGTHBList = new ArrayList<>();
    MaterialFavoriteButton tmblfav;
    ViewPager v_Pgr;
    UGthbHelp uGthbHlp;
    UsrGthb GthbUsr;
    UGthbApiServ Gthbapiserv;
    TabLayout tbLyt;
    UGthbViewPageAdapt adptr;
    UGthb_DbHlpr u_Gthb_Db_Help;
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

    private boolean FOUND(String username){
        String change = UGthb_DbContract.UGthbClmn.U_Gthb_Name + "=?";
        String[] changeArg = {username};
        String limit = "1";
        uGthbHlp = new UGthbHelp(this);
        uGthbHlp.open();
        GthbUsr = getIntent().getParcelableExtra("DATA_USER");
        u_Gthb_Db_Help = new UGthb_DbHlpr(getApplicationContext());
        SQLiteDatabase database = u_Gthb_Db_Help.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = database.query(UGthb_Table,null,change,changeArg,null,null,null,limit);
        boolean found = (cursor.getCount() > 0 );
        cursor.close();
        return found;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugthb_detail);
        adptr = new UGthbViewPageAdapt(this,getSupportFragmentManager());
        tbLyt = findViewById(R.id.tablayt);
        v_Pgr = findViewById(R.id.vp);
        v_Pgr.setAdapter(adptr);
        tbLyt.setupWithViewPager(v_Pgr);
        tbLyt.setElevation(0);
        GthbUsr = getIntent().getParcelableExtra("DATA_USER");
        if (GthbUsr != null){
            ProgressBar barbndr = findViewById(R.id.crclload);
            TextView ikt = findViewById(R.id.u_gthb_fol_2);
            TextView mngkt = findViewById(R.id.u_gthb_fol_1);
            TextView ugthbname = findViewById(R.id.ugthbname);
            TextView ugthbre = findViewById(R.id.ugthbstorage);
            ImageView ugtft = findViewById(R.id.U_GTHB_SASSHIN);
            final LinearLayout linearLayout = findViewById(R.id.linlay);
            Gthbapiserv = getRetro().create(UGthbApiServ.class);
            Call<UGthbDet> summon = Gthbapiserv.getUGthbDet(GthbUsr.getLogin());
            summon.enqueue(new Callback<UGthbDet>() {

                @Override
                public void onResponse(Call<UGthbDet> summon, Response<UGthbDet> reply) {
                    if (reply.body() != null){
                        mngkt.setText(String.valueOf(reply.body().getFollowers()));
                        ugthbre.setText(String.valueOf(reply.body().getPublicRepos()));
                        ikt.setText(String.valueOf(reply.body().getFollowing()));
                        ugthbname.setText(reply.body().getName());
                        Glide.with(getApplicationContext())
                                .load(reply.body().getAvatarUrl())
                                .into(ugtft);
                        ugthbname.setVisibility(View.VISIBLE);
                        ugtft.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        barbndr.setVisibility(View.GONE);

                    }
                }

                @Override
                public void onFailure(Call<UGthbDet> summon, Throwable put) {

                }
            });
        }
        tmblfav = findViewById(R.id.tmblfavuser);
        if (FOUND(GthbUsr.getLogin())){
            tmblfav.setFavorite(true);
            UGTHBList = UGthbHelp.getDataUsrGthb();
            tmblfav.setOnFavoriteChangeListener((buttonView, favorite) -> {
                if (favorite){
                    uGthbHlp.userInsert(GthbUsr);
                    Toast.makeText(UGthbDetailActivity.this, "tambah ke favorite", Toast.LENGTH_SHORT).show();
                }

                else {
                    uGthbHlp.userDelete(String.valueOf(GthbUsr.getId()));
                    Toast.makeText(UGthbDetailActivity.this, "hapus dari favorite", Toast.LENGTH_SHORT).show();
                }
            });
        }

        else {
            tmblfav.setOnFavoriteChangeListener((buttonView, favorite) -> {
                if (favorite){
                    uGthbHlp.userInsert(GthbUsr);
                    Toast.makeText(UGthbDetailActivity.this, "tambah ke favorite", Toast.LENGTH_SHORT).show();
                }else {
                    uGthbHlp.userDelete(String.valueOf(GthbUsr.getId()));
                    Toast.makeText(UGthbDetailActivity.this, "hapus dari favorite", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
