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
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getUserName(JNIEnv *env, jobject,
                                                                  jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStudentCourse(JNIEnv *env, jobject,
                                                                       jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getEmail(JNIEnv *env, jobject,
                                                               jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getPassword(JNIEnv *env, jobject,
                                                                  jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getTutorCourse(JNIEnv *env, jobject,
                                                                     jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getTutor(JNIEnv *env, jobject,
                                                               jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getBio(JNIEnv *env, jobject,
                                                             jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getContact(JNIEnv *env, jobject,
                                                                 jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getLocation(JNIEnv *env, jobject,
                                                                  jlong ptr);
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getRate(JNIEnv *env, jobject,
                                                              jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStatus(JNIEnv *env, jobject,
                                                                jlong ptr);
}
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getAvailable(JNIEnv *env, jobject ,
                                                                   jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getDuration(JNIEnv *env, jobject ,
                                                                  jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getInSession(JNIEnv *env, jobject ,
                                                                   jlong ptr);
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorStatusActivity_getStars(JNIEnv *env, jobject ,
                                                               jlong ptr);


}
#endif //COLLINGWOODREPO_TUTOR_STATUS_H
