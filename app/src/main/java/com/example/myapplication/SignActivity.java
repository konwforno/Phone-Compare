package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private FirebaseAuth mAuth;
    private TextView mTextView;
    private Button signUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mEmail = findViewById(R.id.email_reg);
        mPass = findViewById(R.id.pass_reg);
        signUpBtn = findViewById(R.id.registration_btn);
        mTextView = findViewById(R.id.textView);
        mAuth = FirebaseAuth.getInstance();


        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignActivity.this , SignInActivity.class));
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    private void createUser ()
    {
        String email = mEmail.getText().toString(); //创建email变量，将mEmail的EditText输入的值转换成字符串并传给email变量
        String pass = mPass.getText().toString(); //创建pass变量，将mPass的EditText输入的值转换成字符串并传给pass变量

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {//判断邮箱是否为空并且是否对应邮箱格式
            if (!pass.isEmpty()) {//如果密码不为空，创建用户的邮箱和密码给数据库
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) { //注册成功后，显示“注册成功”提示，并且跳转到登录界面
                                Toast.makeText(SignActivity.this, "注册成功!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignActivity.this, SignInActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {//注册失败后，显示“注册失败”提示
                        Toast.makeText(SignActivity.this, "注册失败 !!", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {//如果密码为空，则"密码设置错误"
                mPass.setError("密码设置错误");
            }
        } else if (email.isEmpty()) {//如果邮箱为空，则"邮箱格式不允许"
            mEmail.setError("邮箱格式不允许");
        } else {//其他情况，则"邮箱格式不允许"
            mEmail.setError("请输入正确邮箱");
        }
    }
}