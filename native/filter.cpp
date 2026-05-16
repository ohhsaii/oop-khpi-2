#include "../native-headers/ua_khpi_oop_lab16_NativeThresholdFilter.h"
#include <jni.h>

JNIEXPORT jintArray JNICALL Java_ua_khpi_oop_lab16_NativeThresholdFilter_filter
  (JNIEnv *env, jobject obj, jintArray input, jint threshold) {

    // отримуємо довжину та елементи масиву
    jsize len = env->GetArrayLength(input);
    jint *body = env->GetIntArrayElements(input, 0);

    // створюємо новий масив для результату
    jintArray result = env->NewIntArray(len);
    jint *resultBody = env->GetIntArrayElements(result, 0);

    // виконуємо фільтрацію
    for (int i = 0; i < len; i++) {
        resultBody[i] = (body[i] >= threshold) ? 1 : 0;
    }

    // звільняємо пам'ять
    env->ReleaseIntArrayElements(input, body, JNI_ABORT);
    env->ReleaseIntArrayElements(result, resultBody, 0);

    return result;
}