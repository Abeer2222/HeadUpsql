package com.example.headupsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var etname2: EditText
    private lateinit var ettaboo12: EditText
    private lateinit var ettaboo22: EditText
    private lateinit var ettaboo32: EditText
    var newCele = ""
    var t1 = ""
    var t2 = ""
    var t3 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        addButton = findViewById(R.id.addButton)
        etname2 = findViewById(R.id.etname2)
        ettaboo12 = findViewById(R.id.ettaboo12)
        ettaboo22 = findViewById(R.id.ettaboo22)
        ettaboo32 = findViewById(R.id.ettaboo32)

        addButton.setOnClickListener {
            newCele = etname2.text.toString()
            t1 = ettaboo12.text.toString()
            t2 = ettaboo22.text.toString()
            t3 = ettaboo32.text.toString()
            val dbHelper = DbHelper(applicationContext)
            var status = dbHelper.addCelebrity(newCele, t1, t2, t3)
            Toast.makeText(applicationContext, "Celebrity Added " + status, Toast.LENGTH_LONG)
                .show()
        }
    }
}