package com.alifyacode.aplikasigithubuser.ApiHelp;

import com.alifyacode.aplikasigithubuser.UsersConfiguration.UGthbDet;
import com.alifyacode.aplikasigithubuser.UsersConfiguration.UsrGthb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UGthbApiServ {
    @GET("/users")
    Call<List<UsrGthb>> getUsrGthb(@Header("Authorization") String token);

    @GET("/users/{username}/followers")
    Call<List<UsrGthb>> getUsrFol1(@Path("username") String username);

    @GET("/users/{username}/following")
    Call<List<UsrGthb>> getUsrFol2(@Path("username") String username);

    @GET("/search/users")
    Call<UGthbSearchRespon> getUGthbSrch(
            @Query("q") String username
    );

    @GET("users/{username}")
    Call<UGthbDet> getUGthbDet(@Path("username") String username);
}
