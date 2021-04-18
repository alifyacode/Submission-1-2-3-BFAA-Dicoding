package com.alifyacode.aplikasigithubuser.TheAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.ActivityFile.UGthbDetailActivity;
import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UGthbAdaptFav extends RecyclerView.Adapter<UGthbAdaptFav.UsrGthbVwHldr> {
    private Context cntx;
    private ArrayList<UsrGthb> usrgthblst ;
    private Intent intnt;

    public UGthbAdaptFav(Context cntx) {
        this.cntx = cntx;
    }

    public void shwUsrGthbLst(ArrayList<UsrGthb> usrGthbArryLst){
        this.usrgthblst = usrGthbArryLst;
    }

    @NonNull
    @Override
    public UGthbAdaptFav.UsrGthbVwHldr onCreateViewHolder(@NonNull ViewGroup prnt, int vwTp) {
        return new UGthbAdaptFav.UsrGthbVwHldr(LayoutInflater.from(prnt.getContext()).inflate(R.layout.itm_usr,prnt,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UGthbAdaptFav.UsrGthbVwHldr hldr, int pstn) {
        hldr.text_name.setText(usrgthblst.get(pstn).getLogin());
        hldr.text_url.setText(usrgthblst.get(pstn).getHtmlUrl());
        Glide.with(hldr.itemView.getContext())
                .load(usrgthblst.get(pstn).getAvatarUrl())
                .into(hldr.img);

    }

    @Override
    public int getItemCount() {
        return usrgthblst.size();
    }


    public class UsrGthbVwHldr extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView text_url,text_name;
        UsrGthbVwHldr(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_user);
            text_name = itemView.findViewById(R.id.name);
            text_url = itemView.findViewById(R.id.url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View vw) {
            intnt = new Intent(cntx, UGthbDetailActivity.class);
            intnt.putExtra("DATA_USER",usrgthblst.get(getAdapterPosition()));
            vw.getContext().startActivity(intnt);
        }
    }
}
