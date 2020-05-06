package com.example.smkcodingproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //menambahkan jeda untuk pindah ke halaman selanjutnya
        Handler().postDelayed({
            finish()
            //anko
            startActivity<MainActivity>()
        }, 2000)
    }
}
