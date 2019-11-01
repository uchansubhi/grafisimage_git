package com.example.soal7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class SOAL7_2 extends Activity {
    private Button tekan;
    private GLSurfaceView grafik1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal7_2);
        tekan=(Button)findViewById(R.id.button1);
        grafik1 = new HelloESSurfaceView(this);
        setContentView(grafik1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        grafik1.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        grafik1.onResume();
    }

    class HelloESSurfaceView extends GLSurfaceView{
        public HelloESSurfaceView(Context context){
            super(context);

            setRenderer(new polygon6());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_latih7_grafik_klasik, menu);
        return true;

    }
}
