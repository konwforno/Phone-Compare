package com.example.myapplication.ui.oneplus;

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
import com.example.myapplication.databinding.FragmentOneplusBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class OneplusFragment extends Fragment {

    private com.example.myapplication.ui.oneplus.OneplusViewModel OneplusViewModel;
    private FragmentOneplusBinding binding;
    GridView  oneplusGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        mDatabase = FirebaseDatabase.getInstance().getReference("一加");

        OneplusViewModel =
                new ViewModelProvider(this).get(OneplusViewModel.class);

        binding = FragmentOneplusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // below line is use to initialize our variables.
        oneplusGv = root.findViewById(R.id.oneplusGv);
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
                for(DataSnapshot oneplus : snapshot.getChildren()) {
                    keys.add(oneplus.getKey());
                    Data oneplusdata = oneplus.getValue(Data.class);


                    dataArrayList.add(oneplusdata);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    oneplusGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }






}
