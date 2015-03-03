package com.twotoasters.servos.tests;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(buildLayout());
    }

    ViewGroup buildLayout() {
        TextView textView = new TextView(this);
        textView.setId(R.id.main_textview);
        textView.setText("Hello World!");

        LinearLayout layout = new LinearLayout(this);
        layout.setId(R.id.main_container);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        layout.addView(textView);
        return layout;
    }
}
