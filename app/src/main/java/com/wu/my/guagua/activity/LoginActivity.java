package com.wu.my.guagua.activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wu.my.guagua.R;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInput_Login_username;
    private TextInputLayout textInput_Login_password;
    private EditText editText_Login_password;
    private EditText editText_Login_username;
    private TextView textView_Login_register;
    private ImageView imageView_Login_back;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //顶部导航设置监听事件，功能相当于返回键
        imageView_Login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        try {
                            Instrumentation inst = new Instrumentation();
                            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                        } catch (Exception e) {
                        }
                    }
                }.start();
            }
        });

        registe();

    }


    /**
     * 初始化UI
     */
    private void initView() {
        textInput_Login_username = (TextInputLayout) findViewById(R.id.textInput_Login_username);
        textInput_Login_password = (TextInputLayout) findViewById(R.id.textInput_Login_password);
        editText_Login_username = (EditText) findViewById(R.id.editText_Login_username);
        editText_Login_password = (EditText) findViewById(R.id.editText_Login_password);
        imageView_Login_back = (ImageView) findViewById(R.id.imageView_Login_back);
        textView_Login_register = (TextView) findViewById(R.id.textView_Login_register);
    }

    /**
     * button的点击事件
     */
    public void onClick(View view) {
    }

    /**
     * 注册
     */
    private void registe() {
        textView_Login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


}

