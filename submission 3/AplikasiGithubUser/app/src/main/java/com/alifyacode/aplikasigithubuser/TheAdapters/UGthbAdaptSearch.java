package com.alifyacode.aplikasigithubuser.TheAdapters;

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

public class UGthbAdaptSearch extends RecyclerView.Adapter<UGthbAdaptSearch.UVHolder> {

    private List<UsrGthb> usrgthblst ;
    private UsrGthb usr;
    private Intent intnt;
    public UGthbAdaptSearch(List<UsrGthb> usrgthblst) {
        this.usrgthblst = usrgthblst;
    }

    @NonNull
    @Override
    public UGthbAdaptSearch.UVHolder onCreateViewHolder(@NonNull ViewGroup prnt, int viewType) {
        return new UGthbAdaptSearch.UVHolder(LayoutInflater.from(prnt.getContext()).inflate(R.layout.itm_usr,prnt,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UGthbAdaptSearch.UVHolder hldr, int position) {
        usr = usrgthblst.get(position);
        hldr.u_gthb_name.setText(usr.getLogin());
        hldr.u_gthb_url.setText(usr.getUrl());
        Glide.with(hldr.itemView.getContext())
                .load(usr.getAvatarUrl())
                .into(hldr.u_gthb_img);
    }

    @Override
    public int getItemCount() {
        return usrgthblst.size();
    }

    public class UVHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView u_gthb_img;
        TextView u_gthb_url,u_gthb_name;
        UVHolder(@NonNull View itemView) {
            super(itemView);
            u_gthb_img = itemView.findViewById(R.id.img_user);
            u_gthb_name = itemView.findViewById(R.id.name);
            u_gthb_url = itemView.findViewById(R.id.url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View vw) {
            usr = usrgthblst.get(getAdapterPosition());
            intnt = new Intent(vw.getContext(), UGthbDetailActivity.class);
            intnt.putExtra("DATA_USER",usr);
            vw.getContext().startActivity(intnt);
        }
    }
}
