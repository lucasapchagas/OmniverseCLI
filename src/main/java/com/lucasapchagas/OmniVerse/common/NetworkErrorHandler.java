package com.lucasapchagas.OmniVerse.common;



public class NetworkErrorHandler {

    public static void handleErrorCode(String TAG, int code, Object body) {
        System.out.println(TAG + ": Error while doing network operation " + code + " " + body);

    }

}
