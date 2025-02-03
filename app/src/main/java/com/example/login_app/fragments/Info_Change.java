package com.example.login_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.login_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Info_Change#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Info_Change extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Info_Change() {

    }
    public static Info_Change newInstance(String param1, String param2) {
        Info_Change fragment = new Info_Change();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_info__change, container, false);
        EditText phone_change=view.findViewById(R.id.phone_editView_change_info);
        EditText email_change=view.findViewById(R.id.email_editView_change_info);
        EditText password_change=view.findViewById(R.id.password_editView_change_info);
        String s_phone_change,s_email_change,s_password_change;

        return view;
    }
}