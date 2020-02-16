package com.example.unittest.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.unittest.R;
import com.example.unittest.Utils.FormatTextUtil;
import com.example.unittest.data.Connect;


public class LoginActivity extends AppCompatActivity {

    EditText editTextPass;
    EditText editTextPhone;
    Button btnSignIn;
    Connect connect;
    TextView tvErr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        disableWarning();

        editTextPass = findViewById(R.id.edt_pass);
        editTextPhone = findViewById(R.id.edt_phone);
        btnSignIn = findViewById(R.id.btn_sign_in);
        tvErr = findViewById(R.id.tv_err);

        connect = new Connect();

        btnSignIn.setOnClickListener((v)->{
            if(validate()){
                connect.signIn(editTextPhone.getText().toString(),
                        editTextPass.getText().toString(),
                        new Connect.Callback() {
                            @Override
                            public void onSuccess() {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                tvErr.setVisibility(View.GONE);
                            }

                            @Override
                            public void onFail() {
                                tvErr.setText(R.string.err_account_null);
                                tvErr.setVisibility(View.VISIBLE);
                            }
                        });
            }
        });


    }

    boolean validate(){
        if(FormatTextUtil.getPhoneNumber(editTextPhone.getText().toString()).equals("")){
            return false;
        }else return editTextPass.getText().toString().trim().length() >= 6;

    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }


}
