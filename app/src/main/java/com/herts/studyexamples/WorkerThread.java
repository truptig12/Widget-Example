package com.herts.studyexamples;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class WorkerThread extends Thread {

    public static final int PROGRESS = 1;
    public static final int DOWNLOAD_DONE = 2;
    Handler handler = null;
    boolean isReady = false;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler(Looper.myLooper());
        isReady = true;
        Looper.loop();

       /* Log.i("New Thread", Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    public void startDownloading(Handler mainHandler) {
        if (Thread.currentThread() != this) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    startDownloading(mainHandler);
                }
            });
            return;
        }
// downloading
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = Message.obtain(handler);
            if (i != 100) {
                msg.arg1 = i;
                msg.what = PROGRESS;
                mainHandler.sendMessage(msg);
            } else {
                msg.arg1 = 100;
                msg.what = DOWNLOAD_DONE;
                msg.arg2 = 53;
                String[] arr = {"Download done", "From movies.com", "Time taken : 53 mins"};
                msg.obj = arr;
                mainHandler.sendMessage(msg);
            }

        }


    }
}
