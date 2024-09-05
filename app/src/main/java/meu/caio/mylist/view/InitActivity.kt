package meu.caio.mylist.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import meu.caio.mylist.R
import meu.caio.mylist.databinding.ActivityInitBinding
import java.util.Timer
import java.util.TimerTask

class InitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = Timer("Schedule", true)

        timer.schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }, 2000)
    }
}