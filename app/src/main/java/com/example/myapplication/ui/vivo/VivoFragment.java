package com.example.myapplication.ui.vivo;

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
import com.example.myapplication.databinding.FragmentVivoBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VivoFragment extends Fragment {

    private VivoViewModel vivoViewModel;
    private FragmentVivoBinding binding;
    GridView vivoGv;
    ArrayList<Data> dataArrayList;
    DatabaseReference mDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        mDatabase = FirebaseDatabase.getInstance().getReference("Vivo");


        vivoViewModel =
                new ViewModelProvider(this).get(VivoViewModel.class);

        binding = FragmentVivoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vivoGv = root.findViewById(R.id.vivoGv);
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
                for(DataSnapshot vivo: snapshot.getChildren()) {
                    keys.add(vivo.getKey());
                    Data vivoData = vivo.getValue(Data.class);


                    dataArrayList.add(vivoData);


                    Madapter madapter = new Madapter(requireContext(), dataArrayList);
                    vivoGv.setAdapter(madapter);
                }


            }


            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }
}