package com.example.login_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.login_app.R;
import com.example.login_app.activitys.CustomeAdapter;
import com.example.login_app.activitys.MyData;
import com.example.login_app.modles.DataModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_res#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_res extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;

    private DatabaseReference productsRef;

    private String mParam1;
    private String mParam2;

    public Fragment_res() {

    }

    public static Fragment_res newInstance(String param1, String param2) {
        Fragment_res fragment = new Fragment_res();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_res, container, false);

        dataSet = new ArrayList<>();
        recyclerView = view.findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator() {
        });

        for ( int i = 0 ; i < MyData.ProductsName.length ; i++)
        {
            dataSet.add(new DataModel(
                    MyData.ProductsName[i],
                    MyData.drawableArray[i],
                    MyData.ProductAmounts[i],
                    MyData.id_[i]
            ));
        }

        adapter = new CustomeAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        return view ;
    }

}