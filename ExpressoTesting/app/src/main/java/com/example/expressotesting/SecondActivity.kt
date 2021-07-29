package com.example.expressotesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expressotesting.databinding.ActivityMainBinding
import com.example.expressotesting.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecondActivity.setOnClickListener {
            onBackPressed()
        }
    }
}