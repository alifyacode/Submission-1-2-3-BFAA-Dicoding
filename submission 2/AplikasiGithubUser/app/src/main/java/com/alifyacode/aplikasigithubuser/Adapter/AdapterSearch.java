package com.alifyacode.aplikasigithubuser.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alifyacode.aplikasigithubuser.Model.User;
import com.alifyacode.aplikasigithubuser.R;
import com.alifyacode.aplikasigithubuser.Ui.DetailActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.UserViewHolder> {

    private List<User> userList ;

    public AdapterSearch(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public AdapterSearch.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearch.UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tv_name.setText(user.getLogin());
        holder.tv_url.setText(user.getUrl());
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatarUrl())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView tv_url,tv_name;
        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_user);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_url = itemView.findViewById(R.id.tv_url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            User user = userList.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("DATA_USER",user);
            v.getContext().startActivity(intent);
        }
    }
}