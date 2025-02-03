package com.example.login_app.fragments;

import android.accessibilityservice.GestureDescription;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_app.R;
import com.example.login_app.activitys.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_two#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_two extends Fragment {
    private FirebaseAuth mAuth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Fragment_two() {

    }

    public static Fragment_two newInstance(String param1, String param2) {
        Fragment_two fragment = new Fragment_two();
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
        FirebaseDatabase database;
        DatabaseReference reference;
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button buttonReg=(view).findViewById(R.id.button_register_frg2);
        TextView password=(view.findViewById(R.id.password_editView_frg2));
        TextView email=(view.findViewById(R.id.email_editView_reg_frg2));
        TextView password_again=(view.findViewById(R.id.again_password_editView_frg2));
        TextView phone =(view.findViewById(R.id.phone_editView_frg2));


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!password.getText().toString().equals(password_again.getText().toString())) {
                    Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else if (phone.length() < 10 || phone.length() > 10) {
                    Toast.makeText(getContext(), "Enter valid phone number", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.funcRegister(email.getText().toString(), password.getText().toString(), phone.getText().toString());
                    mainActivity.addData();
                    Navigation.findNavController(view).navigate(R.id.action_fragment_two_to_fragment_four);
                }

            }
        });

        return  view;
    }
}