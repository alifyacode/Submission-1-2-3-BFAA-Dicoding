package com.alifyacode.aplikasikonsumergithub.TheAdapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasikonsumergithub.ActivityFile.UGthbDetailActivity;
import com.alifyacode.aplikasikonsumergithub.R;
import com.alifyacode.aplikasikonsumergithub.UsersConfiguration.UsrGthb;
import com.bumptech.glide.Glide;

public class UGthbAdaptFav extends RecyclerView.Adapter<UGthbAdaptFav.UsrGthbVwHldr> {
    private Context cntx;
    private Cursor crsr;
    public UGthbAdaptFav(Context cntx) {
        this.cntx = cntx;
    }

    public void setCursor(Cursor crsr) {
        this.crsr = crsr;
    }

    private UsrGthb ctchItmDt(int pstn){
        if (!crsr.moveToPosition(pstn)){
            throw new IllegalStateException("INVALID");
        }
        return new UsrGthb(crsr);
    }
    @NonNull
    @Override
    public UGthbAdaptFav.UsrGthbVwHldr onCreateViewHolder(@NonNull ViewGroup parent, int vwTyp) {
        return new UsrGthbVwHldr(LayoutInflater.from(parent.getContext()).inflate(R.layout.itm_usr,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UGthbAdaptFav.UsrGthbVwHldr hldr, int pstn) {
        hldr.txt_name.setText(ctchItmDt(pstn).getLogin());
        hldr.txt_url.setText(ctchItmDt(pstn).getHtmlUrl());
        Glide.with(hldr.itemView.getContext())
                .load(ctchItmDt(pstn).getAvatarUrl())
                .into(hldr.img);
    }

    @Override
    public int getItemCount() {
        if (crsr == null) return 0;
        return crsr.getCount();
    }

    public class UsrGthbVwHldr extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView txt_url,txt_name;
        UsrGthbVwHldr(@NonNull View itmVw) {
            super(itmVw);
            img = itmVw.findViewById(R.id.img_user);
            txt_name = itmVw.findViewById(R.id.name);
            txt_url = itmVw.findViewById(R.id.url);
            itmVw.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intnt = new Intent(cntx, UGthbDetailActivity.class);
            intnt.putExtra("DATA_USER",ctchItmDt(getAdapterPosition()));
            v.getContext().startActivity(intnt);
        }
    }
}
