package com.androiddesdecero.collapsingtoolbarandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btSimpleCollapsing;
    private Button btCollapsing;
    private Button btEffetCollapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSimpleCollapsing =findViewById(R.id.btSimpleCollapsing);
        btSimpleCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SimpleCollapsingActivity.class));
            }
        });

        btCollapsing = findViewById(R.id.btCollapsing);
        btCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CollapsingActivity.class));
            }
        });

        btEffetCollapsing = findViewById(R.id.btEffetCollapsing);
        btEffetCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EffectCollapsingActivity.class));

            }
        });
    }
}
