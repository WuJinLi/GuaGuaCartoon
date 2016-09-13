package com.wu.my.guagua.activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wu.my.guagua.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText editText_register_usrename, editText_register_password,
            editText_register_rpassword;
    private ImageView imageView_register_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        imageView_register_back.setOnClickListener(new View.OnClickListener() {
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
    }

    private void initView() {
        editText_register_usrename = (EditText) findViewById(R.id.editText_register_usrename);
        editText_register_password = (EditText) findViewById(R.id.editText_register_password);
        editText_register_rpassword = (EditText) findViewById(R.id.editText_register_rpassword);
        imageView_register_back = (ImageView) findViewById(R.id.imageView_register_back);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_register_submit:
//                Log.i("submit","submit");
//                String username = editText_register_usrename.getText() + "";
//                String rpassword = editText_register_rpassword.getText() + "";
//                String password = editText_register_password.getText() + "";
//                if (username == null || password == null || rpassword == null) {
//                    Toast.makeText(RegisterActivity.this, "用户信息为空，请确认", Toast.LENGTH_SHORT).show();
//                    break;
//                } else if (!(password.equals(rpassword))) {
//                    Toast.makeText(RegisterActivity.this, "两次密码不一致，请确认", Toast.LENGTH_SHORT).show();
//                    break;
//                } else {
//                    SharedPreferences sharedPreferences = getSharedPreferences("userinfo",
//                            MODE_APPEND);
//                    SharedPreferences.Editor edit = sharedPreferences.edit();
//                    edit.putString("username", username);
//                    edit.putString("password", password);
//                    edit.commit();
//                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
////                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
////                    finish();
//                }
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                break;
            case R.id.button_register_cancle:
                Log.i("cancle","cancle");
                editText_register_usrename.setText("");
                editText_register_rpassword.setText("");
                editText_register_password.setText("");
                break;
        }
    }
}
