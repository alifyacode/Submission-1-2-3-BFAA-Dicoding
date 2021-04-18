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

import java.util.List;

public class UGthbAdaptUser extends RecyclerView.Adapter<UGthbAdaptUser.UVHolder> {
    private Context cntx;
    private List<UsrGthb> usrGthbList ;

    public UGthbAdaptUser(Context cntx, List<UsrGthb> usrGthbList) {
        this.cntx = cntx;
        this.usrGthbList = usrGthbList ;
    }

    @NonNull
    @Override
    public UGthbAdaptUser.UVHolder onCreateViewHolder(@NonNull ViewGroup prnt, int viewType) {
        return new UGthbAdaptUser.UVHolder(LayoutInflater.from(prnt.getContext()).inflate(R.layout.itm_usr,prnt,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UGthbAdaptUser.UVHolder hldr, int position) {
        hldr.gthb_usr_name.setText(usrGthbList .get(position).getLogin());
        hldr.gthb_usr_url.setText(usrGthbList .get(position).getHtmlUrl());
        Glide.with(hldr.itemView.getContext())
                .load(usrGthbList .get(position).getAvatarUrl())
                .into(hldr.gthb_img);
    }

    @Override
    public int getItemCount() {
        return usrGthbList .size();
    }

    //ganti baris ini
    public class UVHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //

        ImageView gthb_img;
        TextView gthb_usr_url,gthb_usr_name;
        UVHolder(@NonNull View itemView) {
            super(itemView);
            gthb_img = itemView.findViewById(R.id.img_user);
            gthb_usr_name = itemView.findViewById(R.id.name);
            gthb_usr_url = itemView.findViewById(R.id.url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intnt = new Intent(cntx, UGthbDetailActivity.class);
            intnt.putExtra("DATA_USER",usrGthbList .get(getAdapterPosition()));
            v.getContext().startActivity(intnt);
        }
    }
}
