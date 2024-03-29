//
// Created by Poe on 11/5/2018.
//
#include <jni.h>
#include <string>

#ifndef TUTORSTAGE1_STUDENTPROFILE_H
#define TUTORSTAGE1_STUDENTPROFILE_H

extern "C"{
JNIEXPORT void JNICALL
    Java_com_example_poe_tutorstage1_StudentProfileActivity_saveProfile(JNIEnv *env, jobject , jlong ptr,
        jstring userNameJava, jstring userCourseJava);

JNIEXPORT jstring JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getUserName(JNIEnv *env, jobject ,
                                                                            jlong ptr);
JNIEXPORT jstring JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getStudentCourse(JNIEnv *env, jobject ,
                                                                                 jlong ptr);
JNIEXPORT jstring JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getEmail(JNIEnv *env, jobject ,
                                                                         jlong ptr);
JNIEXPORT jstring JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getPassword(JNIEnv *env, jobject ,
                                                                            jlong ptr);
JNIEXPORT jstring JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getTutorCourse(JNIEnv *env, jobject ,
                                                                               jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getContact(JNIEnv *env, jobject ,
                                                                   jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getLocation(JNIEnv *env, jobject ,
                                                                   jlong ptr);
JNIEXPORT jint JNICALL
        Java_com_example_poe_tutorstage1_StudentProfileActivity_getTutor(JNIEnv *env, jobject ,
                                                                         jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getStatus(JNIEnv *env, jobject,
                                                                jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getAvailable(JNIEnv *env, jobject ,
                                                                     jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getDuration(JNIEnv *env, jobject ,
                                                                    jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getInSession(JNIEnv *env, jobject ,
                                                                     jlong ptr);
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_StudentProfileActivity_getStars(JNIEnv *env, jobject ,
                                                                 jlong ptr);
};
#endif TUTORSTAGE1_STUDENTPROFILE_H
