package com.healthyx.healthyxpro.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.healthyx.healthyxpro.Fragment.Appointment;
import com.healthyx.healthyxpro.Fragment.Mytasks;
import com.healthyx.healthyxpro.Fragment.RegistrationFrag;
import com.healthyx.healthyxpro.R;
import com.healthyx.healthyxpro.adapter.SectionPagerAdapter;

public class ClinicScreen extends AppCompatActivity implements RegistrationFrag.OnFragmentInteractionListener, Appointment.OnFragmentInteractionListener, Mytasks.OnFragmentInteractionListener {
    private static final String TAG = "Tablefragment";
    private ViewPager mViewPager;

    private SectionPagerAdapter mSectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.container);
        Log.d(TAG, "created");
        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        setupViewPager(mViewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               *//* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
                Intent intent = new Intent(ClinicScreen.this, PatientActivity.class);
                startActivity(intent);
            }
        });
*/
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new RegistrationFrag(), "Home");
        adapter.addFragments(new Appointment(), "Appointment");
        adapter.addFragments(new Mytasks(), "My Tasks");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
