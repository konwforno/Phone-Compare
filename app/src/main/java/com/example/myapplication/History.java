package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.adapter.Madapter;
import com.example.myapplication.data.Data;
import com.example.myapplication.databinding.FragmentHistoryBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class History extends Fragment{


    private FragmentHistoryBinding binding;
    GridView HistoryGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        mDatabase = FirebaseDatabase.getInstance().getReference("历史");


        binding =FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        HistoryGv = root.findViewById(R.id.historyGv);
        dataArrayList = new ArrayList<>();

        loadDatainGridView();


        return root;
    }

    private void loadDatainGridView() {
        mDatabase.addValueEventListener(new ValueEventListener() {


            List<String> keys = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot history : snapshot.getChildren()) {
                    keys.add(history.getKey());
                    Data historyData = history.getValue(Data.class);
                    dataArrayList.add(historyData);


                    Madapter madapter = new Madapter(requireActivity(), dataArrayList);
                    HistoryGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }






}
