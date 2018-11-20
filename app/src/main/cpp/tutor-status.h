//
// Created by Tyler Lee on 2018-11-17.
//
#include <jni.h>
#include <string>

#ifndef COLLINGWOODREPO_TUTOR_STATUS_H
#define COLLINGWOODREPO_TUTOR_STATUS_H

#include <jni.h>
extern "C" {
/*
Java_com_example_poe_tutorstage1_TutorStatusActivity_setStatus(JNIEnv *env, jobject, jlong ptr,
                                                                  jint setActive,
                                                                  jint setInactive,
                                                                  jint getStatus);
                                                                  */
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_setActive(JNIEnv *env, jobject, jlong ptr);

JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_setInactive(JNIEnv *env, jobject, jlong ptr);

JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStatus(JNIEnv *env, jobject, jlong ptr);




}
#endif //COLLINGWOODREPO_TUTOR_STATUS_H
