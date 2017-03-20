package org.android.mdsd2016.android.background;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by paulinaberger on 2017-03-20.
 */

public class MyDownloadThread extends AsyncTask<String, Void, String> {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Context mContext;

    public MyDownloadThread(Context context) {
         this.mContext = context;
    }

    @Override
    protected String doInBackground(String[] params) {

        try {
            URL feedUrl = new URL("https://www.theguardian.com/international/rss");
            HttpURLConnection myConnection = (HttpURLConnection) feedUrl.openConnection();
            myConnection.setRequestMethod("GET");
            myConnection.setDoInput(true);
            myConnection.connect();
            ;

            Log.i(MyDownloadThread.TAG, "Response code: " + myConnection.getResponseCode());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }

        return "";
    }
}
