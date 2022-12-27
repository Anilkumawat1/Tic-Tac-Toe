package com.example.tictactoe

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tictactoe.R
import android.widget.Button as Button

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit  var button1 : Button
    private lateinit  var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var button : Button
    private lateinit var text1 : TextView
    private lateinit var text4 : TextView
    private lateinit var text5 : TextView
    private lateinit var pos : IntArray
    private var player1 = 0
    private var player2 = 1
    private var chance = player1
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        pos = intArrayOf(-1,-2,-3,-4,-5,-6,-7,-8,-9)
        text1 = findViewById(R.id.textView9)
        text4 = findViewById(R.id.textView4)
        text5 = findViewById(R.id.textView5)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button = findViewById(R.id.button)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        button.setOnClickListener {
            button1.backgroundTintList = getColorStateList(R.color.purple_500)
            button2.backgroundTintList = getColorStateList(R.color.purple_500)
            button3.backgroundTintList = getColorStateList(R.color.purple_500)
            button4.backgroundTintList = getColorStateList(R.color.purple_500)
            button5.backgroundTintList = getColorStateList(R.color.purple_500)
            button6.backgroundTintList = getColorStateList(R.color.purple_500)
            button7.backgroundTintList = getColorStateList(R.color.purple_500)
            button8.backgroundTintList = getColorStateList(R.color.purple_500)
            button9.backgroundTintList = getColorStateList(R.color.purple_500)
            "".also {button1.text = it }
            "".also {button2.text = it }
            "".also {button3.text = it }
            "".also {button4.text = it }
            "".also {button5.text = it }
            "".also {button6.text = it }
            "".also {button7.text = it }
            "".also {button8.text = it }
            "".also {button9.text = it }
            for(i in 0..8){
                pos[i] = -1*(i+1)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        val tag = Integer.parseInt(btn.tag.toString())
        if(pos[tag-1]>=0||checkWin())
            return
        pos[tag-1] = chance
        if(chance==player1){
            "Turn : player 2".also { text1.text = it }
            "0".also { btn.text = it }
            btn.setTextColor(Color.BLACK)
            btn.backgroundTintList = getColorStateList(R.color.yellow)
            chance = player2
            if(checkWin()){
                Toast.makeText(this, "Player 1 won", Toast.LENGTH_LONG).show()
                var win = Integer.parseInt(text4.text.toString())
                win++
                text4.text = win.toString()
                return
            }
        }
        else{
            btn.setTextColor(Color.BLACK)
            btn.backgroundTintList = getColorStateList(R.color.green)
            "Turn : player 1".also { text1.text = it }
            "X".also { btn.text = it }
            chance = player1
            if(checkWin()){
                Toast.makeText(this, "Player 2 won", Toast.LENGTH_LONG).show()
                var win = Integer.parseInt(text5.text.toString())
                win++
               text5.text = win.toString()
                return
            }
        }

    }
    private fun checkWin():Boolean{
        if(pos[0]==pos[1]&&pos[1]==pos[2])
            return true
        if(pos[3]==pos[4]&&pos[4]==pos[5])
            return true
        if(pos[6]==pos[7]&&pos[7]==pos[8])
            return true
        if(pos[0]==pos[3]&&pos[3]==pos[6])
            return true
        if(pos[1]==pos[4]&&pos[4]==pos[7])
            return true
        if(pos[2]==pos[5]&&pos[5]==pos[8])
            return true
        if(pos[0]==pos[4]&&pos[4]==pos[8])
            return true
        if(pos[2]==pos[4]&&pos[4]==pos[6])
            return true
        return false
    }

}