package com.example.poe.tutorstage1;

        import java.io.Serializable;

public class User implements Serializable {
    public User(){
        message = "test";
    }
    private String message;

    public String getMessage() {
        return message;
    }
}
