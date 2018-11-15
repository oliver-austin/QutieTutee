package com.example.poe.tutorstage1;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("user")
    Call<List<User>> getUsers();

    @GET("user/tutors")
    Call<List<User>> getTutors();
}
