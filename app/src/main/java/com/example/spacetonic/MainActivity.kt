package com.example.spacetonic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton.setOnClickListener {

            if (!editWeight.text.toString().equals("") && !editHeightFeet.text.toString().equals("") && !editHeightInch.text.toString().equals(""))
            {

                val wt = (editWeight.text.toString()).toDouble()
                val htfeet = (editHeightFeet.text.toString()).toDouble()
                val htinch = (editHeightInch.text.toString()).toDouble()
                val age = (editAge.text.toString()).toDouble()

                val totalInch = (htfeet*12) + htinch
                val totalCM = totalInch * 2.54

                val totalM = totalCM/100

                val bmi = (wt)/(totalM*totalM)
                resultView.setText("Your BMI for $age is : $bmi\nYour AgBMI Categories:\nUnderweight = 15.5\nNormal Weight = 18.5 - 24.9\nOverweight = 25-29.9\nObesity = 30 and more ")

                if(bmi>30){
                    Toast.makeText(this@MainActivity,"You are having Obesity",Toast.LENGTH_LONG).show()
                
                    resultView.setBackgroundColor(resources.getColor(R.color.Red))
                }
            else if(bmi>25){
                    Toast.makeText(this@MainActivity,"You are Overweight",Toast.LENGTH_LONG).show()

                    resultView.setBackgroundColor(resources.getColor(R.color.ReddishBrown))
                }
            else if(bmi>18.5){
                    Toast.makeText(this@MainActivity,"You are Normal",Toast.LENGTH_LONG).show()

                    resultView.setBackgroundColor(resources.getColor(R.color.green))
                }
            else{
                    Toast.makeText(this@MainActivity,"You are Underweight",Toast.LENGTH_LONG).show()

                    resultView.setBackgroundColor(resources.getColor(R.color.LightGreen))
                }
            }
                else {
                    Toast.makeText(
                        this@MainActivity,
                        "Please fill all the fields",
                        Toast.LENGTH_LONG
                    ).show()
                }


        }
    }


}