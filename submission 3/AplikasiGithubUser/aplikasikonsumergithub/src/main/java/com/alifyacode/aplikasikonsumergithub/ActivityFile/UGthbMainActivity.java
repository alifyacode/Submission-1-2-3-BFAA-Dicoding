package com.alifyacode.aplikasikonsumergithub.ActivityFile;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasikonsumergithub.R;
import com.alifyacode.aplikasikonsumergithub.TheAdapters.UGthbAdaptFav;

import static com.alifyacode.aplikasikonsumergithub.DatabasesStructure.UGthb_DbContract.UGthbClmn.U_Gthb_KONTEN_URI;

public class UGthbMainActivity extends AppCompatActivity {

    RecyclerView rcyVw;
    UGthbAdaptFav adptUsrFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugthb_main);

        rcyVw = findViewById(R.id.rvUsr);
        rcyVw.setHasFixedSize(true);
        rcyVw.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState == null){
            new Favorite().execute();
        }
    }

    private class Favorite extends AsyncTask<Void,Void, Cursor> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Cursor doInBackground(Void... voids) {
            return getApplicationContext().getContentResolver().query(U_Gthb_KONTEN_URI,null,null,null,null);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Cursor crsr) {
            super.onPostExecute(crsr);
            adptUsrFav = new UGthbAdaptFav(getApplicationContext());
            adptUsrFav.setCursor(crsr);
            adptUsrFav.notifyDataSetChanged();
            rcyVw.setAdapter(adptUsrFav);
        }
    }
}