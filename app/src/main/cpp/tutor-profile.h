//
// Created by Tyler Lee on 2018-11-13.
//

#ifndef COLLINGWOODREPO_TUTOR_PROFILE_H
#define COLLINGWOODREPO_TUTOR_PROFILE_H

#include <jni.h>

extern "C" {
JNIEXPORT void JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_saveProfile(JNIEnv *env, jobject, jlong ptr,
                                                                  jstring userNameJava,
                                                                  jstring userCoursesJava,
                                                                  jstring userBioJava,
                                                                  jstring userContactJava,
                                                                  jdouble userRateJava);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getUserName(JNIEnv *env, jobject,
                                                                  jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getStudentCourse(JNIEnv *env, jobject,
                                                                       jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getEmail(JNIEnv *env, jobject,
                                                               jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getPassword(JNIEnv *env, jobject,
                                                                  jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getTutorCourse(JNIEnv *env, jobject,
                                                                     jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getTutor(JNIEnv *env, jobject,
                                                               jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getBio(JNIEnv *env, jobject,
                                                             jlong ptr);
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getContact(JNIEnv *env, jobject,
                                                                 jlong ptr);
JNIEXPORT jdouble JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getRate(JNIEnv *env, jobject,
                                                              jlong ptr);
JNIEXPORT jint JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_getStatus(JNIEnv *env, jobject,
                                                                jlong ptr);
}
#endif //COLLINGWOODREPO_TUTOR_PROFILE_H
