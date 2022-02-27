package com.example.myapplication.ui.xiaomi;

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
import com.example.myapplication.databinding.FragmentXiaomiBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class XiaomiFragment extends Fragment {

    private XiaomiViewModel xiaomiViewModel;
    private FragmentXiaomiBinding binding;
    GridView xiaomiGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        mDatabase = FirebaseDatabase.getInstance().getReference("小米");


        xiaomiViewModel =
                new ViewModelProvider(this).get(XiaomiViewModel.class);

        binding = FragmentXiaomiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        xiaomiGv = root.findViewById(R.id.xiaomiGv);
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
                for(DataSnapshot xiaomi: snapshot.getChildren()) {
                    keys.add(xiaomi.getKey());
                    Data samsungData = xiaomi.getValue(Data.class);


                    dataArrayList.add(samsungData);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    xiaomiGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }
}