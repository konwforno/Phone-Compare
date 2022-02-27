package com.example.myapplication.ui.samsung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.adapter.Madapter;

import com.example.myapplication.R;
import com.example.myapplication.data.Data;
import com.example.myapplication.databinding.FragmentSamsungBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SamsungFragment extends Fragment {

    private SamsungViewModel samsungViewModel;
    private FragmentSamsungBinding binding;
    GridView samsungGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        mDatabase = FirebaseDatabase.getInstance().getReference("三星");


        samsungViewModel =
                new ViewModelProvider(this).get(SamsungViewModel.class);

        binding = FragmentSamsungBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        samsungGv = root.findViewById(R.id.samsungGv);
        dataArrayList = new ArrayList<>();

        // initializing our variable for firebase
        // firestore and getting its instance.

        // here we are calling a method
        // to load data in our list view.
        loadDatainGridView();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void loadDatainGridView() {
        mDatabase.addValueEventListener(new ValueEventListener() {


            List<String> keys = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot samsung: snapshot.getChildren()) {
                    keys.add(samsung.getKey());
                    Data samsungData = samsung.getValue(Data.class);


                    dataArrayList.add(samsungData);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    samsungGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }
}