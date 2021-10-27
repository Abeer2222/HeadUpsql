package com.example.headsup2

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.headupsql.*
import kotlinx.android.synthetic.main.activity_main2.*



class MainActivity2 : AppCompatActivity() {
    var time:Long=60000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
            getCelebrityFromDB()

        }
    }

    private  fun timer(t:Long){
        object : CountDownTimer(t, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTime.text = "Time: ${millisUntilFinished / 1000}"
                time=millisUntilFinished
            }

            override fun onFinish() {
                tvTime.text = "Time: --"
                time=60000
            }
        }.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("time", time)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        time= savedInstanceState.getLong("time", 0)
        timer(time)
    }

    fun  getCelebrityFromDB(){
        val dbHelper=DbHelper(applicationContext)
        val retrieveResult=dbHelper.getCelebrity()
        retrieveResult.shuffle()
        val oneCele=retrieveResult[0]
        tvname.text=oneCele[0]
        tvta1.text=oneCele[1]
        tvta2.text=oneCele[2]
        tvta3.text=oneCele[3]
    }
}
