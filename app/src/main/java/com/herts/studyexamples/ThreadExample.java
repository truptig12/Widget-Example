package com.herts.studyexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class ThreadExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);


        WorkerThread th = new WorkerThread();
        th.start();
        Handler h = new Handler(getMainLooper());
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(ThreadExample.this, "Thread awake", Toast.LENGTH_SHORT).show();
            }
        }, 15000);








        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("Diff thread", Thread.currentThread().getName());

                //calling ui thread using handler
                Handler handler = new Handler(getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadExample.this, "In UI thread"+ Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();

                    }
                }, 5000);

                //calling ui thread using runnable
               /* runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadExample.this, "In UI thread"+ Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
                    }
                });*/

//new thread sleep
/*                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(ThreadExample.this, "thread unblocked", Toast.LENGTH_SHORT).show();
   */

            }
        };

        Thread thread = new Thread(runnable);
//        thread.start();


        // call runnable using handler
/*        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(runnable);*/
    }
}