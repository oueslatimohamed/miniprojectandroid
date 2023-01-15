package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miniprojetmaster.LoginActivity;
import com.example.miniprojetmaster.R;
import com.example.miniprojetmaster.SignActivity;

import model.User;
import sercices.DatabasHelper;

public class ProfileFragment extends Fragment {
    TextView mName;
    TextView mLastName;
    TextView mEmail;
    TextView mDec;
    DatabasHelper databasHelper;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mName = (TextView) view.findViewById(R.id.profile_tv_name);
        mLastName = (TextView) view.findViewById(R.id.profile_tv_prenom);
        mEmail = (TextView) view.findViewById(R.id.profile_tv_email);
        mDec = (TextView) view.findViewById(R.id.profile_tv_deconnexion);
        databasHelper = new DatabasHelper(getContext());

        //String login = getActivity().getIntent().getStringExtra("Login");

        user = databasHelper.getUser(getActivity().getIntent().getStringExtra("Login"));

        mName.setText(user.getmName());
        mLastName.setText(user.getmLastname());
        mEmail.setText(user.getmEmail());

        mDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , LoginActivity.class);
                startActivity(intent);
            }
        });



        // Inflate the layout for this fragment
        return view;
    }
}