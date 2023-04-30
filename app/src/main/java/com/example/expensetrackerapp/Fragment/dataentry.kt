package com.example.expensetrackerapp.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R
import java.util.*


class dataentry : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_dataentry, container, false)
        val value = this.arguments?.getString("text")
        Log.d(TAG, "onCreateView: $value")
        val textview = view.findViewById<TextView>(R.id.tv1)
        textview.setText(value.toString())
        val button = view.findViewById<Button>(R.id.save)
        val datePicker = view.findViewById<DatePicker>(R.id.date_picker)
        val et1 = view.findViewById<EditText>(R.id.editText1)
        val et2 = view.findViewById<EditText>(R.id.editText2)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            // Do something with the selected date
            val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
//            Log.d(TAG, "Selected date: $selectedDate")
        }
        button.setOnClickListener {

            val amount = et1.text.toString()
            val note = et2.text.toString()
            Log.d(TAG, "Selected date: $value+$amount")
            Log.d(TAG, "Selected date: $note")
            Toast.makeText(requireContext(), "Expense Added in $value ", Toast.LENGTH_LONG ).show()

            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }



}