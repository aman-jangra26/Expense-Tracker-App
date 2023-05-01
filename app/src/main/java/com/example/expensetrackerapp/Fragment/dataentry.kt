package com.example.expensetrackerapp.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R
import java.io.File
import java.util.*


class dataentry : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_dataentry, container, false)
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val value = this.arguments?.getString("text")
        Log.d(TAG, "onCreateView: $value")
        val textview = view.findViewById<TextView>(R.id.tv1)
        textview.setText(value.toString())
        val button = view.findViewById<Button>(R.id.save)
        val close = view.findViewById<ImageButton>(R.id.closeButton)
        val datePicker = view.findViewById<DatePicker>(R.id.date_picker)
        val et1 = view.findViewById<EditText>(R.id.editText1)
        val et2 = view.findViewById<EditText>(R.id.editText2)

        val calendar = Calendar.getInstance()
        var selectedDate = ""
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            // Do something with the selected date
//            val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            val monthNames = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
            val selectedMonthName = monthNames[monthOfYear]
            selectedDate = "$selectedMonthName $dayOfMonth, $year"
            Log.d(TAG, "Selected date: $selectedDate")
            //amit
        }
        button.setOnClickListener {

            val amount = et1.text.toString()
            val note = et2.text.toString()
            Log.d(TAG, "Selected date: $value+$amount+$note+$selectedDate")
            Toast.makeText(requireContext(), "Expense Added in $value ", Toast.LENGTH_LONG ).show()
            val filename = note
            val fileContents = value+","+note+","+amount.toString()+","+selectedDate.toString()
            val file = File(requireContext().filesDir, filename)
            file.writeText(fileContents)
            Log.d("MyApp", "File created successfully.")

            requireActivity().supportFragmentManager.popBackStack()
        }

        close.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()

// Start a new activity for the main file

        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Remove the flag when the fragment is closed
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }



}