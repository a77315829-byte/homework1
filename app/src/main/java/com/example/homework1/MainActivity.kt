package com.example.homework1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var switch1: Switch
    private lateinit var group: RadioGroup
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton
    private lateinit var button1: Button     // Btnreset
    private lateinit var button2: Button     // BtnExit
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "안드로이드 사진 보기"

        text1 = findViewById(R.id.Text1)
        text2 = findViewById(R.id.Text2)
        switch1 = findViewById(R.id.ChkAgree)

        group = findViewById(R.id.RGroup1)
        radio1 = findViewById(R.id.Rdo1)
        radio2 = findViewById(R.id.Rdo2)
        radio3 = findViewById(R.id.Rdo3)

        button1 = findViewById(R.id.BtnExit) // XML id와 대소문자 일치 확인
        button2 = findViewById(R.id.Btnreset)
        img = findViewById(R.id.ImgBot)

        switch1.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (switch1.isChecked() == true) {
                text2.visibility = android.view.View.VISIBLE
                group.visibility = android.view.View.VISIBLE
                button1.visibility = android.view.View.VISIBLE
                button2.visibility = android.view.View.VISIBLE
                img.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                group.visibility = android.view.View.INVISIBLE
                button1.visibility = android.view.View.INVISIBLE
                button2.visibility = android.view.View.INVISIBLE
                img.visibility = android.view.View.INVISIBLE
            }
        })
        group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (group.getCheckedRadioButtonId()) {
                R.id.Rdo1 -> img.setImageResource(R.drawable.oreo)
                R.id.Rdo2 -> img.setImageResource(R.drawable.pie)
                R.id.Rdo3 -> img.setImageResource(R.drawable.q10)
            }
        })

        button1.setOnClickListener(View.OnClickListener { finish() })

        button2.setOnClickListener(View.OnClickListener {
            switch1.setChecked(false)
            radio1.setChecked(false)
            radio2.setChecked(false)
            radio3.setChecked(false)
            img.setImageResource(0)
        })
    }
}