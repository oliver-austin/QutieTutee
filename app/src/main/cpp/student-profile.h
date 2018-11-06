//
// Created by Poe on 11/5/2018.
//
#include <jni.h>
#ifndef TUTORSTAGE1_STUDENTPROFILE_H
#define TUTORSTAGE1_STUDENTPROFILE_H

extern "C"{
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileEditActivity_saveProfile(JNIEnv *env, jobject,
                                                                        jstring userName);
};
#endif TUTORSTAGE1_STUDENTPROFILE_H
