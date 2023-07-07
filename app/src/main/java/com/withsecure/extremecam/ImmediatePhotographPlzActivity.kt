package com.withsecure.extremecam

import android.media.RingtoneManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class ImmediatePhotographPlzActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if(intent.getStringExtra("extreme_source").toString() == "com.withsecure.turbomatic")
        {
            Log.d("ExtremeCam", "extreme_source correct");
            if(intent.getIntExtra("authentication_code", 0) == 96024)
            {
                Log.d("ExtremeCam", "authentication_code correct");
                if(intent.getBooleanExtra("take_extreme_pic", false))
                {
                    Log.d("ExtremeCam","It's photo time");
                    Toast.makeText(applicationContext, "🔥🔥🔥 EXTREME PHOTO TIME 🔥🔥🔥", Toast.LENGTH_LONG).show();
                    try {
                        val notification =
                            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                        val r = RingtoneManager.getRingtone(applicationContext, notification)
                        r.play()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    Thread { takePhoto() }.start()
                    return;
                }
            }
        }
        Log.e("ExtremeCam", "Immediate Photograph Activity called with incorrect parameters!");
    }
}