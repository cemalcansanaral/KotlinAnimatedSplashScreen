package com.cemalcansanaral.kotlinsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.cemalcansanaral.kotlinsplashscreen.databinding.ActivitySplashScreenBinding
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)

        val splashImageAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_image_animation)
        val splashTextAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_text_animation)

        binding.imageViewLogo.startAnimation(splashImageAnimation)
        binding.textViewName.startAnimation(splashTextAnimation)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)

                    val intent = Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}