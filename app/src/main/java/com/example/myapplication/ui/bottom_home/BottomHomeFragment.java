package com.example.myapplication.ui.bottom_home;

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
import com.example.myapplication.databinding.FragmentBottomHomeBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BottomHomeFragment extends Fragment {

    private com.example.myapplication.ui.bottom_home.BottomHomeViewModel BottomHomeViewModel;
    private FragmentBottomHomeBinding binding;
    GridView allGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BottomHomeViewModel =
                new ViewModelProvider(this).get(com.example.myapplication.ui.bottom_home.BottomHomeViewModel.class);
        mDatabase = FirebaseDatabase.getInstance().getReference("所有");
        binding = FragmentBottomHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dataArrayList = new ArrayList<>();
        allGv= root.findViewById(R.id.allGv);
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
                for(DataSnapshot all : snapshot.getChildren()) {
                    keys.add(all.getKey());
                    Data data =all.getValue(Data.class);


                    dataArrayList.add(data);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    allGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }
}