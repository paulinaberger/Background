package org.android.mdsd2016.android.background;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAsyncTask myTask = new MyAsyncTask(this); //to start it, we need execute method
        myTask.execute(5);
    }
}
