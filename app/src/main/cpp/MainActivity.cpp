//
// Created by Shira Eisen on 2018-11-10.
//

#include <jni.h>
#include <string>
#include "User.cpp"

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_example_poe_tutorstage1_MainActivity(JNIEnv *env, jobject, jstring emailAddress,
                                                jstring password) {
    const char *pathToEmail = env->GetStringUTFChars(emailAddress, NULL);
    const char *pathToPwrd = env->GetStringUTFChars(password, NULL);
    std::string emailAddressJava = std::string(pathToEmail);
    std::string passwordJava = std::string(pathToPwrd);
    return env->NewStringUTF(emailAddressJava.c_str());
    }

JNIEXPORT jlong JNICALL //creates C++ object and returns pointer to it
Java_com_example_poe_tutorstage1_MainActivity_newUser(JNIEnv *env, jobject, jobject JavaUser) {
    jclass user = env->GetObjectClass(JavaUser);
    jfieldID nameId = env->GetFieldID(user, "name", "Ljava/lang/String;");
    jstring nameObjectJava = (jstring)env->GetObjectField(JavaUser, nameId);
    jfieldID emailId = env->GetFieldID(user, "email", "Ljava/lang/String;");
    jstring emailObjectJava = (jstring)env->GetObjectField(JavaUser, emailId);
    jfieldID pwrdId = env->GetFieldID(user, "pwrd", "Ljava/lang/String;");
    jstring pwrdObjectJava = (jstring)env->GetObjectField(JavaUser, pwrdId);
    jfieldID sCourseId = env->GetFieldID(user, "s_course", "Ljava/lang/String;");
    jstring sCourseObjectJava = (jstring)env->GetObjectField(JavaUser, sCourseId);
    jfieldID tCourseId = env->GetFieldID(user, "t_courses", "Ljava/lang/String;");
    jstring tCourseObjectJava = (jstring)env->GetObjectField(JavaUser, tCourseId);
    jfieldID locationId = env->GetFieldID(user, "location", "Ljava/lang/String;");
    jstring locationObjectJava = (jstring)env->GetObjectField(JavaUser, locationId);

    const char *cstrName = env->GetStringUTFChars(nameObjectJava, NULL);
    std::string nameStr = cstrName;

    const char *cstrEmail = env->GetStringUTFChars(emailObjectJava, NULL);
    std::string emailStr = cstrEmail;

    const char *cstrPwrd = env->GetStringUTFChars(pwrdObjectJava, NULL);
    std::string pwrdStr = cstrPwrd;

    const char *cstrS_Course = env->GetStringUTFChars(sCourseObjectJava, NULL);
    std::string s_courseStr = cstrS_Course;

    const char *cstrT_Course = env->GetStringUTFChars(tCourseObjectJava, NULL);
    std::string t_courseStr = cstrT_Course;

    const char *cstrLocation = env->GetStringUTFChars(locationObjectJava, NULL);
    std::string locationStr = cstrLocation;

    return (long)(new User(nameStr, emailStr, pwrdStr, s_courseStr,
                           t_courseStr, locationStr));
    }
}


