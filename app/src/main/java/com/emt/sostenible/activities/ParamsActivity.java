package com.emt.sostenible.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.emt.sostenible.R;

public class ParamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
    }

    protected void onCalculateButtonClicked(View view)
    {
        Intent intent = new Intent(this, BasicMapActivity.class);
        startActivity(intent);
    }

}
