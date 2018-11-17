package com.example.poe.tutorstage1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {

    static final String BASE_URL = "http://collingwood.caslab.queensu.ca:5010/";

    public void start(String apiEndpoint) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API api = retrofit.create(API.class);
        if(apiEndpoint.equals("tutors")){
            Call<List<User>> call = api.getTutors();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        List<User> userList = response.body();
                        userList.forEach(user -> System.out.println(user.email));
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    t.printStackTrace();
                }

            });

        } else {
            Call<List<User>> call = api.getUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        List<User> userList = response.body();
                        userList.forEach(user -> System.out.println(user.email));
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    t.printStackTrace();
                }

            });
        }

    }
}
