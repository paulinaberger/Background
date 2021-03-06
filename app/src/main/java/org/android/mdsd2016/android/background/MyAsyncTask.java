package org.android.mdsd2016.android.background;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Pablo L on 14/03/2017.
 */

public class MyAsyncTask<S, V, S1> extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = MyAsyncTask.class.getSimpleName();


    private Context mContext;

    public MyAsyncTask(Context context){ //assign context to field
        this.mContext = context;

    }

    @Override
    protected String doInBackground(Integer[] inputArgs) {

        for (int idx = 1; idx <= 5; idx++) {

            sleepForAWhile(inputArgs[0]);
            publishProgress(idx * 20);

            Log.i(MyAsyncTask.TAG, "Iteration " + idx + " done!");
        }

        return "AsyncTask finished";
    }

    @Override
    protected void onProgressUpdate(Integer[] values){
        super.onProgressUpdate(values);

        //to use Context we have to use method from activity
        ((MainActivity) this.mContext).updateProgressBar(values[0]);


    }

    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        Toast.makeText(this.mContext, s, Toast.LENGTH_SHORT).show();
    }

    private void sleepForAWhile(Integer numSecs) {

        long currentTime = System.currentTimeMillis();
        long finishTime = currentTime + numSecs * 1000;
        Log.i(MyAsyncTask.TAG, "Current Time: " + currentTime);
        Log.i(MyAsyncTask.TAG, "Finish Time:" + finishTime);

        while (currentTime < finishTime) {
            currentTime = System.currentTimeMillis();
        }
    }
}
