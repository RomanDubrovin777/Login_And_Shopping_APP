package com.example.login_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_app.R;
import com.example.login_app.activitys.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_three#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_three extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_three() {

    }

    public static Fragment_three newInstance(String param1, String param2) {
        Fragment_three fragment = new Fragment_three();
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

        View view= inflater.inflate(R.layout.fragment_three, container, false);
        TextView user_email=view.findViewById(R.id.email_editView_reg_frg3);
        TextView user_phone=view.findViewById(R.id.phone_editView_frg3);
        MainActivity mainActivity = (MainActivity) getActivity();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
                String userId = user.getUid();
                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("user").child(userId);
                userRef.addListenerForSingleValueEvent(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String email = dataSnapshot.child("m_email").getValue(String.class);
                        String phone = dataSnapshot.child("m_phone").getValue(String.class);
                        user_email.setText(email);
                        user_phone.setText(phone);

                        if (dataSnapshot.exists()) {
                            String email1 = dataSnapshot.child("m_email").getValue(String.class);
                            String phone1 = dataSnapshot.child("m_phone").getValue(String.class);

                            user_email.setText(email1 != null ? email : "No email available");
                            user_phone.setText(phone1 != null ? phone : "No phone available");
                        } else {
                            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getContext(), "Failed to read user data", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        Button button_return_toregister_freg3_to2=view.findViewById(R.id.button_change_info_frg3);

        button_return_toregister_freg3_to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_three_to_info_Change);
            }
        });

        Button button_fromInfo_ToRes=view.findViewById(R.id.button_shoppingCart_frg3);

        button_fromInfo_ToRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_three_to_fragment_res);
            }
        });


        return view;
    }

}