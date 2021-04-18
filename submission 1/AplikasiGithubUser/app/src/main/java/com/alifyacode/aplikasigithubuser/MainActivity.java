package com.alifyacode.aplikasigithubuser;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private TypedArray dataPhoto;
    private String[] dataName,dataUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new UserAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(MainActivity.this, UserDetail.class);

                ArrayList<User> users = new ArrayList<>();
                User user = new User();
                user.setPhoto(dataPhoto.getResourceId(i, -1));
                user.setName(dataName[i]);
                user.setUsername(dataUsername[i]);
                users.add(user);
                moveWithObject.putParcelableArrayListExtra(UserDetail.EXTRA_USER, users);
                startActivity(moveWithObject);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataPhoto = getResources().obtainTypedArray(R.array.avatar);
    }

    private void addItem() {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();
            user.setPhoto(dataPhoto.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            users.add(user);
        }
        adapter.setUsers(users);
    }}
