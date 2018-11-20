package com.example.poe.tutorstage1;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController implements Serializable {

    static final String BASE_URL = "http://collingwood.caslab.queensu.ca:5010/";

    public void start(int select, User user, @Nullable APICallbacks callbacks) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API api = retrofit.create(API.class);
        switch(select){
            case 0:                 //Get all users
                Call<List<User>> call = api.getUsers();
                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.isSuccessful()) {
                            List<User> userList = response.body();
                            userList.forEach(user ->
                            callbacks.onSuccess(user));
                        } else {
                            ResponseBody error = response.errorBody();
                            callbacks.onFail(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        t.printStackTrace();
                    }

                });

            case 1:                 //Get all tutors
                Call<List<User>> call2 = api.getTutors();
                call2.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.isSuccessful()) {
                            List<User> userList = response.body();
                            userList.forEach(user -> callbacks.onSuccess(user));
                        } else {
                            ResponseBody error = response.errorBody();
                            callbacks.onFail(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                    t.printStackTrace();
                }

                });



            case 2:                 //Get specific user
                Call<User> call3 = api.getUser(user.getEmail(), user.getTutor());
                call3.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            System.out.println("USER. SUCCESS CODE"+response.code());
                            User user = response.body();
                            callbacks.onSuccess(user);
                            return;
                        } else {
                            System.out.println("USER. FAIL CODE"+response.code());
                            ResponseBody error = response.errorBody();
                            callbacks.onFail(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }

                });



            case 3:
                Call<User> call4 = api.newUser(user);
                call4.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            int code = response.code();
                        } else {
                            ResponseBody error = response.errorBody();
                            callbacks.onFail(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }

                });

            case 4:                 //Update specific user
                Call<User> call5 = api.updateUser(user.getEmail(), user.getTutor(), user);
                call5.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            System.out.println("Successful API call");
                        } else {
                            ResponseBody error = response.errorBody();
                            callbacks.onFail(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }

                });
        }

    }
}
