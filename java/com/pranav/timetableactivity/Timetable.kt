package com.pranav.timetableactivity

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class Timetable : AppCompatActivity() {

    fun changelayout_mon(view: View?) {
        setContentView(R.layout.monday_new)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    fun changelayout_wed(view: View?) {
        setContentView(R.layout.wednesday_new)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    fun changelayout_fri(view: View?) {
        setContentView(R.layout.friday_new)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    fun changelayout_tue(view: View?) {
        setContentView(R.layout.tuesday_new)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    fun changelayout_thu(view: View?) {
        setContentView(R.layout.thursday_new)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    fun changelayout_main(view: View?) {
        setContentView(R.layout.activity_main)
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        this.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_timetable)
        recreate()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        val calendar: Calendar = Calendar.getInstance()
        val date: Date = calendar.getTime()

// 3 letter name form of the day
// 3 letter name form of the day
        val day=(SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()))
        //var views = RemoteViews(context.packageName, R.layout.activity_friday)
        if (day=="Mon") {
            val imageButton = findViewById<MaterialButton>(R.id.button1)
            imageButton.setCornerRadius(100)
        } else if (day=="Tue") {
            val imageButton = findViewById<MaterialButton>(R.id.button2)
            imageButton.setCornerRadius(100)
        } else if (day=="Wed") {
            val imageButton = findViewById<MaterialButton>(R.id.button3)
            imageButton.setCornerRadius(100)
        } else if (day=="Thu") {
            val imageButton = findViewById<MaterialButton>(R.id.button4)
            imageButton.setCornerRadius(100)
        } else if (day=="Fri") {
            val imageButton = findViewById<MaterialButton>(R.id.button5)
            imageButton.setCornerRadius(100)
        } else {
            val imageButton1 = findViewById<MaterialButton>(R.id.button1)
            imageButton1.setCornerRadius(100)
            val imageButton2 = findViewById<MaterialButton>(R.id.button2)
            imageButton2.setCornerRadius(100)
            val imageButton3 = findViewById<MaterialButton>(R.id.button3)
            imageButton3.setCornerRadius(100)
            val imageButton = findViewById<MaterialButton>(R.id.button4)
            imageButton.setCornerRadius(100)
            val imageButton5 = findViewById<MaterialButton>(R.id.button5)
            imageButton5.setCornerRadius(100)
        }
        /**var height = findViewById<AppCompatButton>(R.id.musicButton);
        height.setOnClickListener() {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }**/
        //Notifications yet to be implemented
        //createNotification(View)
    }
    fun createNotification(view: View?) {
        val myIntent = Intent(applicationContext, NotifyService::class.java)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val pendingIntent = PendingIntent.getService(this, 0, myIntent, PendingIntent.FLAG_IMMUTABLE)
        val calendar = Calendar.getInstance()
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.HOUR] = 0
        calendar[Calendar.AM_PM] = Calendar.AM
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            (1000 * 60 * 60 * 24).toLong(),
            pendingIntent
        )
    }
}