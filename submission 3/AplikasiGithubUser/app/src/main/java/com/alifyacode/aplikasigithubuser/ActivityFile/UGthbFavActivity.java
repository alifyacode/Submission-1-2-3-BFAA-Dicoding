package com.alifyacode.aplikasigithubuser.ActivityFile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.TheAdapters.UGthbAdaptFav;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UGthbHelp;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;

import java.util.ArrayList;

public class UGthbFavActivity extends AppCompatActivity {
    ArrayList<UsrGthb> ugthblist =  new ArrayList<>();
    UGthbAdaptFav theadapterFav;
    RecyclerView resvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugthb_fav);
        new UGthbHelp(getApplicationContext()).open();
        ugthblist = UGthbHelp.getDataUsrGthb();
        resvi = findViewById(R.id.rvUsr);
        resvi.setLayoutManager(new LinearLayoutManager(this));
        resvi.setHasFixedSize(true);
        theadapterFav = new UGthbAdaptFav(getApplicationContext());
        resvi.setAdapter(theadapterFav);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        ugthblist = UGthbHelp.getDataUsrGthb();
        theadapterFav.shwUsrGthbLst(ugthblist);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new UGthbHelp(getApplicationContext()).close();
    }
}


