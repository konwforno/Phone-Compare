package com.example.myapplication.ui.compare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.data.Data1;
import com.example.myapplication.data.Data2;
import com.example.myapplication.databinding.FragmentCompareBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CompareFragment extends Fragment {

    private CompareViewModel compareViewModel;
    private FragmentCompareBinding binding;
    ArrayList<Data1> dataArrayList1;
    ArrayList<Data2> dataArrayList2;
    DatabaseReference mDatabase;
    TextView 价格text, 发布时间text, 型号text, 手机类型text, 操作系统text, CPUtext, CPU频率text, GPUtext, 运行内存text, 机身容量text, 电池容量text, 充电text, 屏幕类型text, 屏幕大小text, 屏幕分辨率text, 屏幕刷新率text, 摄像头类型text, 后置摄像头text, 后置摄像头2text, 后置摄像头3text, 后置摄像头4text,
            前置摄像头text, 价格text1, 发布时间text1, 型号text1, 手机类型text1, 操作系统text1, CPUtext1, CPU频率text1, GPUtext1, 运行内存text1, 机身容量text1, 电池容量text1, 充电text1, 屏幕类型text1, 屏幕大小text1, 屏幕分辨率text1, 屏幕刷新率text1, 摄像头类型text1, 后置摄像头text1, 后置摄像头2text1, 后置摄像头3text1, 后置摄像头4text1, 前置摄像头text1;
    ImageView 图片1, 图片2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        compareViewModel =
                new ViewModelProvider(this).get(CompareViewModel.class);


        mDatabase = FirebaseDatabase.getInstance().getReference("对比");


        binding = FragmentCompareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dataArrayList1 = new ArrayList<>();
        dataArrayList2 = new ArrayList<>();
        loadDatainCompareView();
        图片1 = root.findViewById(R.id.i1);
        价格text = root.findViewById(R.id.t1);
        发布时间text = root.findViewById(R.id.t2);
        型号text = root.findViewById(R.id.t3);
        手机类型text = root.findViewById(R.id.t4);
        操作系统text = root.findViewById(R.id.t5);
        CPUtext = root.findViewById(R.id.t6);
        CPU频率text = root.findViewById(R.id.t7);
        GPUtext = root.findViewById(R.id.t8);
        运行内存text = root.findViewById(R.id.t9);
        机身容量text = root.findViewById(R.id.t10);
        电池容量text = root.findViewById(R.id.t11);
        充电text = root.findViewById(R.id.t12);
        屏幕类型text = root.findViewById(R.id.t13);
        屏幕大小text = root.findViewById(R.id.t14);
        屏幕分辨率text = root.findViewById(R.id.t15);
        屏幕刷新率text = root.findViewById(R.id.t16);
        摄像头类型text = root.findViewById(R.id.t17);
        后置摄像头text = root.findViewById(R.id.t18);
        后置摄像头2text = root.findViewById(R.id.t19);
        后置摄像头3text = root.findViewById(R.id.t20);
        后置摄像头4text = root.findViewById(R.id.t21);
        前置摄像头text = root.findViewById(R.id.t22);

        图片2 = root.findViewById(R.id.i2);
        价格text1 = root.findViewById(R.id.d1);
        发布时间text1 = root.findViewById(R.id.d2);
        型号text1 = root.findViewById(R.id.d3);
        手机类型text1 = root.findViewById(R.id.d4);
        操作系统text1 = root.findViewById(R.id.d5);
        CPUtext1 = root.findViewById(R.id.d6);
        CPU频率text1 = root.findViewById(R.id.d7);
        GPUtext1 = root.findViewById(R.id.d8);
        运行内存text1 = root.findViewById(R.id.d9);
        机身容量text1 = root.findViewById(R.id.d10);
        电池容量text1 = root.findViewById(R.id.d11);
        充电text1 = root.findViewById(R.id.d12);
        屏幕类型text1 = root.findViewById(R.id.d13);
        屏幕大小text1 = root.findViewById(R.id.d14);
        屏幕分辨率text1 = root.findViewById(R.id.d15);
        屏幕刷新率text1 = root.findViewById(R.id.d16);
        摄像头类型text1 = root.findViewById(R.id.d17);
        后置摄像头text1 = root.findViewById(R.id.d18);
        后置摄像头2text1 = root.findViewById(R.id.d19);
        后置摄像头3text1 = root.findViewById(R.id.d20);
        后置摄像头4text1 = root.findViewById(R.id.d21);
        前置摄像头text1 = root.findViewById(R.id.d22);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadDatainCompareView() {
        mDatabase.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                Data1 data = snapshot.child("对比一").getValue(Data1.class);
                Data2 data2 = snapshot.child("对比二").getValue(Data2.class);


                dataArrayList1.add(data);
                dataArrayList2.add(data2);
                价格text.setText(data.get价格());
                发布时间text.setText(data.get发布时间());
                型号text.setText(data.get型号());
                手机类型text.setText(data.get手机类型());
                操作系统text.setText(data.get操作系统());
                CPUtext.setText(data.getCPU());
                CPU频率text.setText(data.getCPU频率());
                GPUtext.setText(data.getGPU());
                运行内存text.setText(data.get运行内存());
                机身容量text.setText(data.get机身容量());
                电池容量text.setText(data.get电池容量());
                充电text.setText(data.get充电());
                屏幕类型text.setText(data.get屏幕类型());
                屏幕大小text.setText(data.get屏幕大小());
                屏幕分辨率text.setText(data.get屏幕分辨率());
                屏幕刷新率text.setText(data.get屏幕分辨率());
                摄像头类型text.setText(data.get摄像头类型());
                后置摄像头text.setText(data.get后置摄像头());
                后置摄像头2text.setText(data.get后置摄像头2());
                后置摄像头3text.setText(data.get后置摄像头3());
                后置摄像头4text.setText(data.get后置摄像头4());
                前置摄像头text.setText(data.get前置摄像头());


                价格text1.setText(data2.get价格());
                发布时间text1.setText(data2.get发布时间());
                型号text1.setText(data2.get型号());
                手机类型text1.setText(data2.get手机类型());
                操作系统text1.setText(data2.get操作系统());
                CPUtext1.setText(data2.getCPU());
                CPU频率text1.setText(data2.getCPU频率());
                GPUtext1.setText(data2.getGPU());
                运行内存text1.setText(data2.get运行内存());
                机身容量text1.setText(data2.get机身容量());
                电池容量text1.setText(data2.get电池容量());
                充电text1.setText(data2.get充电());
                屏幕类型text1.setText(data2.get屏幕类型());
                屏幕大小text1.setText(data2.get屏幕大小());
                屏幕分辨率text1.setText(data2.get屏幕分辨率());
                屏幕刷新率text1.setText(data2.get屏幕分辨率());
                摄像头类型text1.setText(data2.get摄像头类型());
                后置摄像头text1.setText(data2.get后置摄像头());
                后置摄像头2text1.setText(data2.get后置摄像头2());
                后置摄像头3text1.setText(data2.get后置摄像头3());
                后置摄像头4text1.setText(data2.get后置摄像头4());
                前置摄像头text1.setText(data2.get前置摄像头());
                Picasso.get().load(data.get图片链接()).into(图片1);
                Picasso.get().load(data2.get图片链接()).into(图片2);

            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }


}