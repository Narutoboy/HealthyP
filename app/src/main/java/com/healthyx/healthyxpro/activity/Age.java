package com.healthyx.healthyxpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.healthyx.healthyxpro.R;

public class Age extends AppCompatActivity  {

    private TextView mTextMessage;
    private Button submitbtn;
    private EditText mHeight,mWeight,mAge;
    long value;
    private String checkupArray[];
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_back:
                    onBackPressed();
                    return true;
                case R.id.navigation_skip:
                    Intent submit=new Intent(Age.this,SubmitAct.class);
                    startActivity(submit);
                    return true;
                case R.id.navigation_next:
                    startActivity(new Intent(Age.this,BP.class));
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkups);
        checkupArray= new String[]{"AGE", "BP", "BMI", "TEMPRETURE", "BLOODGLUCOSE", "PULSEOXYMETER"};
        value =getIntent().getIntExtra("value",3);
        Log.d("checkup",""+value);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
