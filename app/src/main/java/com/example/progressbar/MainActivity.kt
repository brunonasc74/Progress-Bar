package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewProgressY = textViewProgress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, user: Boolean) {
                textViewProgress.text = progress.toString()

                val travelDistance = (initialTextViewProgressY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textViewProgress.animate().translationY(travelDistance)

                if(!user)
                textViewProgress.animate().setDuration(500).rotationBy(360f)
                    .translationY(initialTextViewProgressY)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        buttonReset.setOnClickListener { v ->
            seekBar.progress = 0
            Toast.makeText(applicationContext, "Thx for pressing me ;)", Toast.LENGTH_SHORT).show()
        }

    }
}