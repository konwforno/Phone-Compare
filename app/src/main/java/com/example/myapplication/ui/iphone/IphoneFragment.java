package com.example.myapplication.ui.iphone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.adapter.Madapter;
import com.example.myapplication.data.Data;
import com.example.myapplication.databinding.FragmentIphoneBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class IphoneFragment extends Fragment {

    private IphoneFragment iphoneFragment;
    private FragmentIphoneBinding binding;
    GridView  iphoneGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        mDatabase = FirebaseDatabase.getInstance().getReference("苹果");

        IphoneViewModel iphoneViewModel = new ViewModelProvider(this).get(IphoneViewModel.class);

        binding = FragmentIphoneBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // below line is use to initialize our variables.
        iphoneGv = root.findViewById(R.id.iphoneGv);
        dataArrayList = new ArrayList<>();

        // initializing our variable for firebase
        // firestore and getting its instance.

        // here we are calling a method
        // to load data in our list view.
        loadDatainGridView();


        return root;
    }




    @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }



    private void loadDatainGridView() {
        mDatabase.addValueEventListener(new ValueEventListener() {


            List<String> keys = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot iphone : snapshot.getChildren()) {
                    keys.add(iphone.getKey());
                    Data iphonedata = iphone.getValue(Data.class);


                    dataArrayList.add(iphonedata);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    iphoneGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }






}
