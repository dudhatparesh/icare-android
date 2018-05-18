package com.enggdream.unitedway.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.modal.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.et_number)
    EditText etNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_ok)
    public void onClickProvider() {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra(Constant.Key.MOBILE_NUMBER,etNumber.getText().toString());
            startActivity(intent);
        }
    }
