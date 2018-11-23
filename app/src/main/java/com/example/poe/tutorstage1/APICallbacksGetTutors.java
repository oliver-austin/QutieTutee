package com.example.poe.tutorstage1;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public interface APICallbacksGetTutors extends Serializable {
    void onSuccess(@NonNull List<User> users);
}
