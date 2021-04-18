package com.alifyacode.aplikasigithubuser.Connection;

import com.alifyacode.aplikasigithubuser.Model.ResponseSearch;
import com.alifyacode.aplikasigithubuser.Model.User;
import com.alifyacode.aplikasigithubuser.Model.UserDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/users")
    Call<List<User>> getGithubUser(@Header("Authentication") String token);
    @GET("/search/users")
    Call<ResponseSearch> getGithubSearch(
            @Query("q") String username
    );
    @GET("users/{username}")
    Call<UserDetail> getUserDetail(@Path("username") String username);
    @GET("/users/{username}/followers")
    Call<List<User>> getUserFollowers(@Path("username") String username);
    @GET("/users/{username}/following")
    Call<List<User>> getUserFollowing(@Path("username") String username);
}
