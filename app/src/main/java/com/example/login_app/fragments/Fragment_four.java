package com.example.login_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_app.R;
import com.example.login_app.activitys.MainActivity;
import com.example.login_app.modles.User;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_four#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_four extends Fragment {

    private FirebaseAuth mAuth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_four() {

    }

    public static Fragment_four newInstance(String param1, String param2) {
        Fragment_four fragment = new Fragment_four();
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
        mAuth=FirebaseAuth.getInstance();
        View view= inflater.inflate(R.layout.fragment_four, container, false);
        EditText email=view.findViewById(R.id.email_editView);
        EditText password=view.findViewById(R.id.password_editView);
        Button button4_2=view.findViewById(R.id.button_register_frg4);
        Button button4_3=view.findViewById(R.id.button_login_frg4);

        button4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty()||password.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "enter email and password please", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.funcLogin(email.getText().toString(), password.getText().toString(), view);
                }
            }
        });
        button4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_four_to_fragment_two);
            }
        });
        return  view;
    }
}