package com.example.checkanswers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checkanswers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    var r = 0
    var ct = 0
    var cr = 0
    var cw = 0
    var ca = 0

    fun start(view: View){
        var a = (10..99).random()
        var b = (10..99).random()
        var c = (0..3).random()
        when (c){
            0 -> {
                binding.operator.text = "+"
                r = a + b
            }
            1 -> {
                binding.operator.text = "-"
                while(a - b < 0)
                {
                    a = (10..99).random()
                    b = (10..99).random()
                }
                r = a - b
            }
            2 -> {
                binding.operator.text = "*"
                r = a * b
            }
            3 -> {
                binding.operator.text = "/"
                while(a % b != 0)
                {
                    a = (10..99).random()
                    b = (10..99).random()
                }
                r = a / b
            }
        }
        ca = r
        var random = (0..1).random()
        if (random == 1){
            ca += 1
        }
        binding.number1.text = a.toString()
        binding.number2.text = b.toString()
        binding.rightButton.isEnabled = true
        binding.wrongButton.isEnabled = true
        binding.startButton.isEnabled = false
        binding.result.isEnabled = true
        binding.result.text = r.toString()
        binding.linearLayout.setBackgroundColor(Color.TRANSPARENT)
    }
    fun checkRight(view: View){
        ct++
        if (ca == r){
            cr++
            binding.linearLayout.setBackgroundColor(Color.GREEN)
        }
        else{
            cw++
            binding.linearLayout.setBackgroundColor(Color.RED)
        }
        binding.tasksNumber.text = ct.toString()
        binding.rightAnswersNum.text = cr.toString()
        binding.wrongAnswersNum.text = cw.toString()
        var p: Double = Math.round(cr.toDouble() / ct * 10000) / 100.0
        binding.percentNum.text = p.toString() + "%"
        binding.rightButton.isEnabled = false
        binding.wrongButton.isEnabled = false
        binding.startButton.isEnabled = true
        binding.result.isEnabled = false
    }
    fun checkWrong(view: View){
        ct++
        if (ca != r){
            cr++
            binding.linearLayout.setBackgroundColor(Color.GREEN)
        }
        else{
            cw++
            binding.linearLayout.setBackgroundColor(Color.RED)
        }
        binding.tasksNumber.text = ct.toString()
        binding.rightAnswersNum.text = cr.toString()
        binding.wrongAnswersNum.text = cw.toString()
        var p: Double = Math.round(cr.toDouble() / ct * 10000) / 100.0
        binding.percentNum.text = p.toString() + "%"
        binding.rightButton.isEnabled = false
        binding.wrongButton.isEnabled = false
        binding.startButton.isEnabled = true
        binding.result.isEnabled = false
    }
}