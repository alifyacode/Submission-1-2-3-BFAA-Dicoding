package com.alifyacode.aplikasigithubuser;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetail extends AppCompatActivity implements View.OnClickListener {
    String name,username;
    int path;

    public static final String EXTRA_USER = "test_extra_user";

    TextView txtName, txtUserName;

    CircleImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        txtName = findViewById(R.id.txt_usernamedetail);
        txtUserName = findViewById(R.id.txt_namedetail);
        imagePhoto = findViewById(R.id.img_fotodetail);

        ArrayList<User> user = getIntent().getParcelableArrayListExtra(EXTRA_USER);
        path = user.get(0).getPhoto();
        imagePhoto.setImageResource(path);
        name = user.get(0).getName();
        txtName.setText(name);
        username = user.get(0).getUsername();
        txtUserName.setText(username);
    }
    @Override
    public void onClick(View view) {
        //
    }
}
