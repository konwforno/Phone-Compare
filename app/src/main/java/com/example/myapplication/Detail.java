package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intentDetail = getIntent();
        String 型号 = intentDetail.getStringExtra("型号");
        String 图片链接 = intentDetail.getStringExtra("图片链接");
        String 价格 = intentDetail.getStringExtra("价格");
        String 发布时间 = intentDetail.getStringExtra("发布时间");
        String 手机类型 = intentDetail.getStringExtra("手机类型");
        String 操作系统 = intentDetail.getStringExtra("操作系统");
        String CPU = intentDetail.getStringExtra("CPU ");
        String CPU频率 = intentDetail.getStringExtra("CPU频率");
        String GPU = intentDetail.getStringExtra("GPU");
        String 运行内存 = intentDetail.getStringExtra("运行内存");
        String 机身容量 = intentDetail.getStringExtra("机身容量");
        String 电池容量 = intentDetail.getStringExtra("电池容量");
        String 充电 = intentDetail.getStringExtra("充电");
        String 屏幕类型 = intentDetail.getStringExtra("屏幕类型");
        String 屏幕大小 = intentDetail.getStringExtra("屏幕大小");
        String 屏幕分辨率 = intentDetail.getStringExtra("屏幕分辨率");
        String 屏幕刷新率 = intentDetail.getStringExtra("屏幕刷新率");
        String 摄像头类型 = intentDetail.getStringExtra("摄像头类型");
        String 后置摄像头 = intentDetail.getStringExtra("后置摄像头");
        String 后置摄像头2 = intentDetail.getStringExtra("后置摄像头2");
        String 后置摄像头3 = intentDetail.getStringExtra("后置摄像头3");
        String 后置摄像头4 = intentDetail.getStringExtra("后置摄像头4");
        String 前置摄像头 = intentDetail.getStringExtra("前置摄像头");


        TextView 价格text = (TextView) findViewById(R.id.f1);
        TextView 发布时间text = (TextView) findViewById(R.id.f2);
        TextView 型号text = (TextView) findViewById(R.id.f3);
        TextView 手机类型text = (TextView) findViewById(R.id.f4);
        TextView 操作系统text = (TextView) findViewById(R.id.f5);
        TextView CPUtext = (TextView) findViewById(R.id.f6);
        TextView CPU频率text = (TextView) findViewById(R.id.f7);
        TextView GPUtext = (TextView) findViewById(R.id.f8);
        TextView 运行内存text = (TextView) findViewById(R.id.f9);
        TextView 机身容量text = (TextView) findViewById(R.id.f10);
        TextView 电池容量text = (TextView) findViewById(R.id.f11);
        TextView 充电text = (TextView) findViewById(R.id.f12);
        TextView 屏幕类型text = (TextView) findViewById(R.id.f13);
        TextView 屏幕大小text = (TextView) findViewById(R.id.f14);
        TextView 屏幕分辨率text = (TextView) findViewById(R.id.f15);
        TextView 屏幕刷新率text = (TextView) findViewById(R.id.f16);
        TextView 摄像头类型text = (TextView) findViewById(R.id.f17);
        TextView 后置摄像头text = (TextView) findViewById(R.id.f18);
        TextView 后置摄像头2text = (TextView) findViewById(R.id.f19);
        TextView 后置摄像头3text = (TextView) findViewById(R.id.f20);
        TextView 后置摄像头4text = (TextView) findViewById(R.id.f21);
        TextView 前置摄像头text = (TextView) findViewById(R.id.f22);
        ImageView 手机图片 = (ImageView) findViewById(R.id.detail_image);


        Picasso.get().load(图片链接).into(手机图片);
        价格text.setText(价格);
        发布时间text.setText(发布时间);
        型号text.setText(型号);
        手机类型text.setText(手机类型);
        操作系统text.setText(操作系统);
        CPUtext.setText(CPU);
        CPU频率text.setText(CPU频率);
        GPUtext.setText(GPU);
        运行内存text.setText(运行内存);
        机身容量text.setText(机身容量);
        电池容量text.setText(电池容量);
        充电text.setText(充电);
        屏幕类型text.setText(屏幕类型);
        屏幕大小text.setText(屏幕大小);
        屏幕分辨率text.setText(屏幕分辨率);
        屏幕刷新率text.setText(屏幕刷新率);
        摄像头类型text.setText(摄像头类型);
        后置摄像头text.setText(后置摄像头);
        后置摄像头2text.setText(后置摄像头2);
        后置摄像头3text.setText(后置摄像头3);
        后置摄像头4text.setText(后置摄像头4);
        前置摄像头text.setText(前置摄像头);





    }
}