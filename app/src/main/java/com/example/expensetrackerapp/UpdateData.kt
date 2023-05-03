package com.example.expensetrackerapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*

class UpdateData : AppCompatActivity() {
    lateinit var amount: EditText
    lateinit var date: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        supportActionBar?.hide()

        val value = intent.getStringExtra("value")
        val abc = value.toString()
        Log.d(TAG, "UpdateActivity: $abc")
        var data = ""
        val context = applicationContext
        val file = File(context.filesDir, abc)
        amount = findViewById(R.id.amount2)
        date = findViewById(R.id.date2)
        val fin = openFileInput(abc)
        var c: Int
        var temp = ""
        while (fin.read().also { c = it } != -1) {
            temp += c.toChar().toString()
        }
        val arr = temp.split(",")
        data += arr[0] + ","
        data += arr[1] + ","
        amount.setText(arr[2])
        date.setText(arr[3])
        val b1 = findViewById<Button>(R.id.save)
        val inputStream = FileInputStream(file)
        val reader = BufferedReader(InputStreamReader(inputStream))
        var line: String? = reader.readLine()
        b1.setOnClickListener {
            if (line != null) {
                val values = line.split(",")

                data += amount.text.toString()
                data += ",".toString()
                data += date.text.toString()


                // Open an output stream and write the modified string

                val outputStream = FileOutputStream(file)
                outputStream.write(data.toByteArray())
                outputStream.close()

                inputStream.close()
                val intent = Intent(this, MainActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

                Toast.makeText(context, "Updated successfully", Toast.LENGTH_LONG).show()

            }


        }
    }
}