package com.example.poe.tutorstage1;

import android.support.annotation.NonNull;

import java.io.Serializable;

public interface APICallbacks extends Serializable {
    User onSuccess(@NonNull User user);
    void onError(@NonNull Throwable throwable);
}
