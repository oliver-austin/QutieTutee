
//
// Created by Shira Eisen on 2018-11-16.
//

#include <jni.h>
#include <string>
#include "User.cpp"

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_LandingActivity_getName(JNIEnv *env, jobject, jlong ptr){
    User *obj = (User *)ptr;
    std::string name = obj->getName();
    return env->NewStringUTF(name.c_str());
    }
}