package com.basittramboo.squareoncanvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyCanvas myCanvas = new MyCanvas(this);
        setContentView(myCanvas);
    }
}
