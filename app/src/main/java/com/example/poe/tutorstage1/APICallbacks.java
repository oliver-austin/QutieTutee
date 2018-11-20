package com.example.poe.tutorstage1;

import android.content.Intent;
import android.support.annotation.NonNull;

import java.io.Serializable;

import okhttp3.ResponseBody;

public interface APICallbacks extends Serializable {
    void onSuccess(@NonNull User user);
    void onFail(@NonNull ResponseBody error);
}
