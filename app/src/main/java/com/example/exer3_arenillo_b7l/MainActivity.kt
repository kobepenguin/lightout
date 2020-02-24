package com.example.exer3_arenillo_b7l

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }


    private fun turnOn(
        col: Int,
        row: Int,
        clickableViews: Array<Array<View>>,
        boardchecker: Array<Array<String>>, count
    ) {

        if (boardchecker[row][col] == "0") {
            clickableViews[row][col].setBackgroundColor(Color.DKGRAY)
            boardchecker[row][col] = "1"
            count++
        } else {
            clickableViews[row][col].setBackgroundColor(Color.WHITE)
            boardchecker[row][col] = "0"
            count--
        }
        if (row != 4) {
            if (boardchecker[row + 1][col] == "0") {
                clickableViews[row + 1][col].setBackgroundColor(Color.DKGRAY)
                boardchecker[row + 1][col] = "1"
                count++
            } else {
                clickableViews[row + 1][col].setBackgroundColor(Color.WHITE)
                boardchecker[row + 1][col] = "0"
                count--
            }
        }
        if (row != 0) {
            if (boardchecker[row - 1][col] == "0") {
                clickableViews[row - 1][col].setBackgroundColor(Color.DKGRAY)
                boardchecker[row - 1][col] = "1"
                count++
            } else {
                clickableViews[row - 1][col].setBackgroundColor(Color.WHITE)
                boardchecker[row - 1][col] = "0"
                count--
            }
        }
        if (col != 4) {
            if (boardchecker[row][col + 1] == "0") {
                clickableViews[row][col + 1].setBackgroundColor(Color.DKGRAY)
                boardchecker[row][col + 1] = "1"
                count++
            } else {
                clickableViews[row][col + 1].setBackgroundColor(Color.WHITE)
                boardchecker[row][col + 1] = "0"
                count--
            }
        }
        if (row != 0){
            if (boardchecker[row - 1][col] == "0") {
                clickableViews[row - 1][col].setBackgroundColor(Color.DKGRAY)
                boardchecker[row - 1][col] = "1"
                count++
            } else {
                clickableViews[row - 1][col].setBackgroundColor(Color.WHITE)
                boardchecker[row - 1][col] = "0"
                count--
            }
        }




    }

    private fun setListeners() {
        val boardchecker = Array(5) { _ ->
            Array(5) { _ ->
                "0"
            }
        }
        var count = 0
//
        val ids = arrayOf(
            R.id.blck1,
            R.id.blck2,
            R.id.blck3,
            R.id.blck4,
            R.id.blck5,
            R.id.blck6,
            R.id.blck7,
            R.id.blck8,
            R.id.blck9,
            R.id.blck10,
            R.id.blck11,
            R.id.blck12,
            R.id.blck13,
            R.id.blck14,
            R.id.blck15,
            R.id.blck16,
            R.id.blck17,
            R.id.blck18,
            R.id.blck19,
            R.id.blck20,
            R.id.blck21,
            R.id.blck22,
            R.id.blck23,
            R.id.blck24,
            R.id.blck25
        )
        val textViews1 = arrayOf<View>()
        val textViews2 = arrayOf<View>()
        val textViews3 = arrayOf<View>()
        val textViews4 = arrayOf<View>()
        val textViews5 = arrayOf<View>()
        for (i in 0..24) {
            val block = findViewById<TextView>(ids[i])
            if (i in 0..4) textViews1[i] = block
            if (i in 5..9) textViews2[i - 5] = block
            if (i in 10..14) textViews3[i - 10] = block
            if (i in 15..19) textViews4[i - 15]
            val clickableViews: Array<Array<View>> =
                arrayOf(textViews1, textViews2, textViews3, textViews4, textViews5)
            for (item in clickableViews) {
                for (j in item) {
                    j.setOnClickListener {
                        val col = clickableViews.indexOf(item)
                        val row = item.indexOf(j)
                        turnOn(col, row, clickableViews, boardchecker,count)
                    }
                }
            }


        }

    }
}
