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

import com.healthyx.healthyxpro.Fragment.AppointmentFragment;
import com.healthyx.healthyxpro.Fragment.Billing;
import com.healthyx.healthyxpro.Fragment.HealthRecord;
import com.healthyx.healthyxpro.R;
import com.healthyx.healthyxpro.adapter.SectionPagerAdapter;

public class PatientActivity extends AppCompatActivity implements HealthRecord.OnFragmentInteractionListener, AppointmentFragment.OnFragmentInteractionListener, Billing.OnFragmentInteractionListener {

    private static final String TAG = "PatientActivity";
    private SectionPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        Log.d(TAG, "created");
        setupViewPager(mViewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add patient record", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(PatientActivity.this, AddRecord.class);
                startActivity(intent);
            }
        });
*/

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new HealthRecord(), "Health Record");
        adapter.addFragments(new AppointmentFragment(), "Appointment");
        adapter.addFragments(new Billing(), "Billing");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_patient, menu);
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
