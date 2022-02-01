package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inicialTextViewProgressY = textViewProgress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, user: Boolean) {
                textViewProgress.text = progress.toString()

                val travelDistance = (inicialTextViewProgressY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textViewProgress.animate().translationY(travelDistance)

                if(!user)
                textViewProgress.animate().setDuration(500).rotationBy(360f)
                    .translationY(inicialTextViewProgressY)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        buttonReset.setOnClickListener { v ->
            seekBar.progress = 0
        }

    }
}