package com.example.diceroller

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        binding.diceImage.visibility = View.INVISIBLE
        val randomInt = Random.nextInt(1, 7)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Handler(Looper.getMainLooper()).postDelayed({
            runOnUiThread {
                binding.diceImage.setImageResource(drawableResource)
                binding.diceImage.visibility = View.VISIBLE
            }
        }, 100)
    }
}