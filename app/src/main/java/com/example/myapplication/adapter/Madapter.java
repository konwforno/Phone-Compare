package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;

import com.example.myapplication.Detail;
import com.example.myapplication.R;
import com.example.myapplication.data.Data;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Madapter extends ArrayAdapter<Data> {
    int m=1;


    // constructor for our list view adapter.
    public Madapter(@NonNull Context context, ArrayList<Data> dataArrayList) {
        super(context, 0, dataArrayList);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {//如果view为空
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_gv_item, parent, false);
        }

        Data data = getItem(position);
        TextView name= listitemView.findViewById(R.id.idTVtext);
        ImageView image = listitemView.findViewById(R.id.idIVimage);
        name.setText(data.get型号()); //设置手机型号名
        Picasso.get().load(data.get图片链接()).into(image);//利用Picasso库将图片链接设置到imageView中显示图片



        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Intent intent = new Intent(view.getContext(), Detail.class);
                intent.putExtra("价格", data.get价格());
                intent.putExtra("型号", data.get型号());
                intent.putExtra("发布时间", data.get发布时间());
                intent.putExtra("手机类型", data.get手机类型());
                intent.putExtra("操作系统", data.get操作系统());
                intent.putExtra("CPU", data.getCPU());
                intent.putExtra("CPU频率", data.getCPU频率());
                intent.putExtra("GPU", data.getGPU());
                intent.putExtra("运行内存", data.get运行内存());
                intent.putExtra("机身容量", data.get机身容量());
                intent.putExtra("电池容量", data.get电池容量());
                intent.putExtra("充电", data.get充电());
                intent.putExtra("屏幕类型", data.get屏幕类型());
                intent.putExtra("屏幕大小", data.get屏幕大小());
                intent.putExtra("屏幕分辨率", data.get屏幕分辨率());
                intent.putExtra("屏幕刷新率", data.get屏幕刷新率());
                intent.putExtra("摄像头类型", data.get摄像头类型());
                intent.putExtra("后置摄像头", data.get后置摄像头());
                intent.putExtra("后置摄像头2", data.get后置摄像头2());
                intent.putExtra("后置摄像头3", data.get后置摄像头3());
                intent.putExtra("后置摄像头4", data.get后置摄像头4());
                intent.putExtra("前置摄像头", data.get前置摄像头());
                intent.putExtra("图片链接", data.get图片链接());
                view.getContext().startActivity(intent);
                DatabaseReference hDatabase;
                hDatabase = FirebaseDatabase.getInstance().getReference("历史").push();

                String 价格 = data.get价格().toString();
                String 图片链接 = data.get图片链接().toString();
                String 型号 = data.get型号().toString();
                String 发布时间 = data.get发布时间().toString();
                String 手机类型 = data.get手机类型().toString();
                String 操作系统 = data.get操作系统().toString();
                String CPU = data.getCPU().toString();
                String CPU频率 = data.getCPU频率().toString();
                String GPU = data.getGPU().toString();
                String 运行内存 = data.get运行内存().toString();
                String 机身容量 = data.get机身容量().toString();
                String 电池容量 = data.get电池容量().toString();
                String 充电 = data.get充电().toString();
                String 屏幕类型 = data.get屏幕类型().toString();
                String 屏幕大小 = data.get屏幕大小().toString();
                String 屏幕分辨率 = data.get屏幕分辨率().toString();
                String 屏幕刷新率 = data.get屏幕刷新率().toString();
                String 摄像头类型 = data.get摄像头类型().toString();
                String 后置摄像头 = data.get后置摄像头().toString();
                String 后置摄像头2 = data.get后置摄像头2().toString();
                String 后置摄像头3 = data.get后置摄像头3().toString();
                String 后置摄像头4 = data.get后置摄像头4().toString();
                String 前置摄像头 = data.get前置摄像头().toString();


                hDatabase.child("价格").setValue(价格);
                hDatabase.child("图片链接").setValue(图片链接);
                hDatabase.child("型号").setValue(型号);
                hDatabase.child("发布时间").setValue(发布时间);
                hDatabase.child("手机类型").setValue(手机类型);
                hDatabase.child("操作系统").setValue(操作系统);
                hDatabase.child("CPU").setValue(CPU);
                hDatabase.child("CPU频率").setValue(CPU频率);
                hDatabase.child("GPU ").setValue(GPU);
                hDatabase.child("运行内存 ").setValue(运行内存);
                hDatabase.child("机身容量").setValue(机身容量);
                hDatabase.child("电池容量").setValue(电池容量);
                hDatabase.child("充电 ").setValue(充电);
                hDatabase.child("屏幕类型").setValue(屏幕类型);
                hDatabase.child("屏幕大小").setValue(屏幕大小);
                hDatabase.child("屏幕分辨率").setValue(屏幕分辨率);
                hDatabase.child("屏幕刷新率").setValue(屏幕刷新率);
                hDatabase.child("摄像头类型").setValue(摄像头类型);
                hDatabase.child("后置摄像头").setValue(后置摄像头);
                hDatabase.child("后置摄像头2").setValue(后置摄像头2);
                hDatabase.child("后置摄像头3").setValue(后置摄像头3);
                hDatabase.child("后置摄像头4").setValue(后置摄像头4);
                hDatabase.child("前置摄像头").setValue(前置摄像头);
            }


        });
        listitemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getContext(), " LONG Item clicked is : " + data.get型号(), Toast.LENGTH_SHORT).show();
                ArrayList<Data> dataArrayList;
                DatabaseReference mDatabase;
                DatabaseReference nDatabase;
                mDatabase = FirebaseDatabase.getInstance().getReference().child("对比").child("对比一");
                nDatabase = FirebaseDatabase.getInstance().getReference().child("对比").child("对比二");


                    String 价格 = data.get价格().toString();
                    String 图片链接 = data.get图片链接().toString();
                    String 型号 = data.get型号().toString();
                    String 发布时间 = data.get发布时间().toString();
                    String 手机类型 = data.get手机类型().toString();
                    String 操作系统 = data.get操作系统().toString();
                    String CPU = data.getCPU().toString();
                    String CPU频率 = data.getCPU频率().toString();
                    String GPU = data.getGPU().toString();
                    String 运行内存 = data.get运行内存().toString();
                    String 机身容量 = data.get机身容量().toString();
                    String 电池容量 = data.get电池容量().toString();
                    String 充电 = data.get充电().toString();
                    String 屏幕类型 = data.get屏幕类型().toString();
                    String 屏幕大小 = data.get屏幕大小().toString();
                    String 屏幕分辨率 = data.get屏幕分辨率().toString();
                    String 屏幕刷新率 = data.get屏幕刷新率().toString();
                    String 摄像头类型 = data.get摄像头类型().toString();
                    String 后置摄像头 = data.get后置摄像头().toString();
                    String 后置摄像头2 = data.get后置摄像头2().toString();
                    String 后置摄像头3 = data.get后置摄像头3().toString();
                    String 后置摄像头4 = data.get后置摄像头4().toString();
                    String 前置摄像头 = data.get前置摄像头().toString();
                    if(m==1) {
                        mDatabase.child("价格").setValue(价格);
                        mDatabase.child("图片链接").setValue(图片链接);
                        mDatabase.child("型号").setValue(型号);
                        mDatabase.child("发布时间").setValue(发布时间);
                        mDatabase.child("手机类型").setValue(手机类型);
                        mDatabase.child("操作系统").setValue(操作系统);
                        mDatabase.child("CPU").setValue(CPU);
                        mDatabase.child("CPU频率").setValue(CPU频率);
                        mDatabase.child("GPU ").setValue(GPU);
                        mDatabase.child("运行内存 ").setValue(运行内存);
                        mDatabase.child("机身容量").setValue(机身容量);
                        mDatabase.child("电池容量").setValue(电池容量);
                        mDatabase.child("充电 ").setValue(充电);
                        mDatabase.child("屏幕类型").setValue(屏幕类型);
                        mDatabase.child("屏幕大小").setValue(屏幕大小);
                        mDatabase.child("屏幕分辨率").setValue(屏幕分辨率);
                        mDatabase.child("屏幕刷新率").setValue(屏幕刷新率);
                        mDatabase.child("摄像头类型").setValue(摄像头类型);
                        mDatabase.child("后置摄像头").setValue(后置摄像头);
                        mDatabase.child("后置摄像头2").setValue(后置摄像头2);
                        mDatabase.child("后置摄像头3").setValue(后置摄像头3);
                        mDatabase.child("后置摄像头4").setValue(后置摄像头4);
                        mDatabase.child("前置摄像头").setValue(前置摄像头);
                        m++;
                    }
                    else {
                        nDatabase.child("价格").setValue(价格);
                        nDatabase.child("图片链接").setValue(图片链接);
                        nDatabase.child("型号").setValue(型号);
                        nDatabase.child("发布时间").setValue(发布时间);
                        nDatabase.child("手机类型").setValue(手机类型);
                        nDatabase.child("操作系统").setValue(操作系统);
                        nDatabase.child("CPU").setValue(CPU);
                        nDatabase.child("CPU频率").setValue(CPU频率);
                        nDatabase.child("GPU ").setValue(GPU);
                        nDatabase.child("运行内存 ").setValue(运行内存);
                        nDatabase.child("机身容量").setValue(机身容量);
                        nDatabase.child("电池容量").setValue(电池容量);
                        nDatabase.child("充电 ").setValue(充电);
                        nDatabase.child("屏幕类型").setValue(屏幕类型);
                        nDatabase.child("屏幕大小").setValue(屏幕大小);
                        nDatabase.child("屏幕分辨率").setValue(屏幕分辨率);
                        nDatabase.child("屏幕刷新率").setValue(屏幕刷新率);
                        nDatabase.child("摄像头类型").setValue(摄像头类型);
                        nDatabase.child("后置摄像头").setValue(后置摄像头);
                        nDatabase.child("后置摄像头2").setValue(后置摄像头2);
                        nDatabase.child("后置摄像头3").setValue(后置摄像头3);
                        nDatabase.child("后置摄像头4").setValue(后置摄像头4);
                        nDatabase.child("前置摄像头").setValue(前置摄像头);
                        m--;
                    }


                Navigation.findNavController(view).navigate(R.id.navigation_compare);












                return false;
            }
        });


        return listitemView;
    }
}

