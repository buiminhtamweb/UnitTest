package com.example.unittest.data;

public class Connect {
    private static final String PHONE = "0987654321";
    private static final String PASS = "654321";

    public interface Callback{
        void onSuccess();
        void onFail();
    }
    public void signIn(String phone, String pass, Callback callback){
        if(phone.equals(PHONE) && pass.equals(PASS))
            callback.onSuccess();
        else callback.onFail();
    }

}
