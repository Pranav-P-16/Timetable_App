package com.pranav.timetableactivity

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar: Calendar = Calendar.getInstance()
        val date: Date = calendar.getTime()
        var mMediaPlayer: MediaPlayer? = null

// 3 letter name form of the day
// 3 letter name form of the day
        val day=(SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()))
        Toast.makeText(applicationContext, "Go Study Bruh!!!", Toast.LENGTH_SHORT).show()


        val images_: IntArray = intArrayOf(R.drawable.hmeme2, R.drawable.meme1,R.drawable.img,R.drawable.img_1,R.drawable.img_2)
        val imageButton = findViewById<ImageView>(R.id.imageView)
        val musicButton= findViewById<ImageView>(R.id.musicButton)
        imageButton.setImageResource(getRandom(images_));
        musicButton.setOnClickListener {
            fun playSound() {
                mMediaPlayer?.reset()
                val sessionidf= mMediaPlayer?.audioSessionId
                musicButton.setBackgroundResource(R.drawable.dhudhe2)
                mMediaPlayer = MediaPlayer.create(this, R.raw.namme_kissan)
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
            }
            playSound()
        }

        imageButton.setOnClickListener {
            imageButton.setImageResource(getRandom(images_));
            musicButton.setBackgroundResource(R.drawable.dhudhe1)
            fun playSound() {
                    mMediaPlayer = MediaPlayer.create(this, R.raw.mp1)
                    mMediaPlayer!!.isLooping = false
                    mMediaPlayer!!.start()
            }
            playSound()

        }
    }
    fun getRandom(array: IntArray): Int {
        val ran = Random()

        // generating integer

        // generating integer
        val nxt = ran.nextInt(4)
        return array[nxt]
    }

}