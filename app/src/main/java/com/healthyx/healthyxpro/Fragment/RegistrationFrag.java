package com.healthyx.healthyxpro.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.healthyx.healthyxpro.R;
import com.healthyx.healthyxpro.activity.PatientActivity;

public class RegistrationFrag extends Fragment {
    private static final String TAG = "Tablefragment";
    private Button button;
    EditText fname,lname,mobileno;
    private FloatingActionButton addnew;
    private OnFragmentInteractionListener mListener;

    public RegistrationFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main  , container, false);
        button=view.findViewById(R.id.registerbtn);
        fname=view.findViewById(R.id.firstName);
        lname=view.findViewById(R.id.lastName);
        mobileno=view.findViewById(R.id.mobileNo);
        addnew=view.findViewById(R.id.addnew);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PatientActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(fname.getText().toString())) {
                    fname.setError("description cannot be null");
                } else if (TextUtils.isEmpty(lname.getText().toString())) {
                    lname.setError("Title cannot be null");
                } else if (TextUtils.isEmpty(mobileno.getText().toString())) {
                    mobileno.setError("Title cannot be null");
                }

                Toast.makeText(getActivity(), "your  name"+fname.getText()
                        .toString()+lname.getText()
                        .toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

     public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
