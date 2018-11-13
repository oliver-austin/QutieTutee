//
// Created by Tyler Lee on 2018-11-13.
//

#ifndef COLLINGWOODREPO_TUTOR_PROFILE_H
#define COLLINGWOODREPO_TUTOR_PROFILE_H

#include <jni.h>

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_TutorProfileActivity_saveProfile(JNIEnv *env, jobject ,
                                                                  jstring userName, jstring userClassTeach, jstring userContact,
                                                                  jstring userRate, jstring userBio);

#endif //COLLINGWOODREPO_TUTOR_PROFILE_H
