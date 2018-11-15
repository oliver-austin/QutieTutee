package com.example.poe.tutorstage1;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Body;
import retrofit2.http.Path;


public interface API {

    @GET("user")
    Call<List<User>> getUsers();

    @GET("user/tutors")
    Call<List<User>> getTutors();

    @GET("user/{email}/{tutor}/get")
    Call<User> getUser(@Path("email") String email, @Path("tutor") boolean tutor);

    @POST("user/new")
    Call<User> newUser(@Body User newUser);

    @PUT("user/{email}/{tutor}/update")
    Call<User> updateUser(@Path("email") String email, @Path("tutor") boolean tutor, @Body User user);

}
