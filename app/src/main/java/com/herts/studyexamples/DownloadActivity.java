package com.herts.studyexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadActivity extends AppCompatActivity {
    ProgressBar pg;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        pg = findViewById(R.id.progressBar);
        tv = findViewById(R.id.textView);


        WorkerThread wt = new WorkerThread();
        wt.start();


        while (!(wt.isReady)) {

        }

        Handler mainHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1:
                        int progress = msg.arg1;
                        pg.setProgress(progress);
                        break;
                    case 2:
                        String fin = "";
                        int prog = msg.arg1;
                        fin += "Progress: " + prog+ "\n";
                        int time = msg.arg2;
                        fin += "time taken: " + time + "\n";
                        String[] arr = (String[]) msg.obj;
                        for (int i = 0; i < arr.length; i++) {
                            fin += arr[i]+ "\n";
                        }
                        tv.setText(fin);
                }

            }
        };
        wt.startDownloading(mainHandler);
    }
}