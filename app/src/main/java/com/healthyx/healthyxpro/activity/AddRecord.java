package com.healthyx.healthyxpro.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import com.healthyx.healthyxpro.R;

public class AddRecord extends AppCompatActivity {
    EditText drName;
    RadioButton genral,diabetic,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drName=findViewById(R.id.etdrName);
        genral=findViewById(R.id.rbGenral);
        diabetic=findViewById(R.id.rbDiabetic);
        other=findViewById(R.id.rbOther);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "please select the Reason for visit!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(AddRecord.this,Age.class);
                if (genral.isChecked()) {
                    intent.putExtra("value", 3);
                    startActivity(intent);
                } else if (diabetic.isChecked()) {
                    intent.putExtra("value", 5);
                    startActivity(intent);

                } else if (other.isChecked()) {
                    intent.putExtra("value",6);
                    startActivity(intent);

                }

            }
        });
    }
}
