//
// Created by Tyler Lee on 2018-11-17.
//
#include <jni.h>
#include "tutor-status.h"
#include "User.cpp"

extern "C" {
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_setActive(JNIEnv *env, jobject, jlong ptr){
    User *obj = (User *) ptr;
    obj->setStatus(1);
}
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_setInactive(JNIEnv *env, jobject, jlong ptr){
    User *obj = (User *) ptr;
    obj->setStatus(0);
}

JNIEXPORT jint JNICALL

Java_com_example_poe_tutorstage1_TutorStatusActivity_getStatus(JNIEnv *env, jobject,
                                                                jlong ptr) {
    User *obj = (User *) ptr;
    int status = obj->getStatus();
    return status;
}
}