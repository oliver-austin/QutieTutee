//
// Created by Poe on 11/17/2018.
//

#ifndef TUTORSTAGE1_TUTOR_LIST_H
#define TUTORSTAGE1_TUTOR_LIST_H

#include <jni.h>

extern "C"{
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorListActivity_getStudentCourse(JNIEnv *env, jobject ,
jlong ptr);
}


#endif TUTORSTAGE1_TUTOR_LIST_H
