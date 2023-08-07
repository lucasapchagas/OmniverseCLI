package com.lucasapchagas.OmniVerse.extern.api;

import com.lucasapchagas.OmniVerse.common.BasicUser;
import com.lucasapchagas.OmniVerse.common.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiInterface {

    @GET("/user/{id}")
    Call<User> getUserById(@Path("id") String id);

    @GET("/user")
    Call<List<User>> getUserList();

    @DELETE("/user/{id}")
    Call<User> deleteUserById(@Path("id") String id);

    @POST("/user")
    Call<User> registerUser(@Body BasicUser user);

    @PUT("/user")
    Call<User> updateUser(@Body BasicUser user);

}
