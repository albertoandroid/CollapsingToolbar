package com.androiddesdecero.collapsingtoolbarandroid;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class EffectCollapsingActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    LinearLayout linearLayout;
    NestedScrollView nestedScrollView;
    private static float MAX_SCALE_IMG = 1.0f;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effect_collapsing);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        linearLayout =  findViewById(R.id.linearLayout);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        appBarLayout = findViewById(R.id.appBarLayout);
        initializeAppBarLayout();
    }

    private void initializeAppBarLayout(){
        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {

        int maxScroll = appBarLayout.getChildAt(0).getHeight();
        float percentage = (float) Math.abs(offset) / (float) Math.abs(maxScroll);

        linearLayout.setScaleX(MAX_SCALE_IMG - percentage);
        linearLayout.setScaleY(MAX_SCALE_IMG - percentage);

        float finalX = appBarLayout.getChildAt(0).getWidth();
        float initX = appBarLayout.getChildAt(0).getWidth() / 2;
        float translateX = ((finalX - initX) * (percentage));

        linearLayout.setTranslationX(translateX);

        float nestedMarginTop = getResources().getDimension(android.R.dimen.app_icon_size);
        float toConvert = nestedMarginTop * (1f - percentage);
        int dps = Math.round(toConvert);
        setTopMargins(nestedScrollView, dps);
    }

    private void setTopMargins (View view, int top) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(p.leftMargin, top, p.rightMargin, p.bottomMargin);
            view.requestLayout();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //menuIconColor(menu, R.color.colorWhiteApp);
        return super.onCreateOptionsMenu(menu);
    }
}
