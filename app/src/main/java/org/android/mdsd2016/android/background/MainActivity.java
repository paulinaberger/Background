package org.android.mdsd2016.android.background;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mProgressbar = (ProgressBar) findViewById(R.id.prog_bar_processing_main_activity);

        MyAsyncTask myTask = new MyAsyncTask(this); //to start it, we need execute method
   //   myTask.execute(2);


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService((Context.CONNECTIVITY_SERVICE));
        NetworkInfo netwInfo = connMgr.getActiveNetworkInfo(); //we want to perform connection
        //we have to check if it's not null

        if (netwInfo != null && netwInfo.isConnected()) {
            // if my app gets to this point, I can access the internet and perform network ops
           MyDownloadThread downloadThread = new MyDownloadThread(this);
            downloadThread.execute();

        }else{
                Log.w(MainActivity.TAG, "Connection Failed");
                Toast.makeText(this, "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        }

    public void updateProgressBar(Integer value) {

        this.mProgressbar.setProgress(value);
    }
}
