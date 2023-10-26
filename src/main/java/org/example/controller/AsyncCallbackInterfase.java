package org.example.controller;

public interface AsyncCallbackInterfase {
    void onComplete(String result);
    void onError(Exception e);
}
