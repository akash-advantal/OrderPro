package com.orderpro.customer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.merchant.orderpro.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout back_btn_sign_up;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back_btn_sign_up = (LinearLayout) findViewById(R.id.back_btn_sign_up);
        btn_signup = (Button) findViewById(R.id.btn_signup);

        back_btn_sign_up.setOnClickListener(this);
        btn_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_btn_sign_up:
                onBackPressed();
                break;
            case R.id.btn_signup:
                startActivity(new Intent(SignUpActivity.this, OTPActivity.class));
                break;

        }
    }
}
