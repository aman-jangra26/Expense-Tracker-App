package com.example.expensetrackerapp.Fragment

import android.content.ContentValues
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import java.io.File
import java.util.*


class ViewData : Fragment() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_view_data, container, false)



        val months = listOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )
        var myVariableName: Int = 0

        val fileNames = getFileNames()
        for (file in fileNames) {
            val fin = requireContext().openFileInput(file)
            var c: Int
            var temp = ""
            while (fin.read().also { c = it } != -1) {
                temp += c.toChar().toString()
            }
            val arr = temp.split(",")
            myVariableName += arr[2].toInt()

        }
        Log.d(TAG, "onCreateView: $myVariableName")
        val monthSpinner = v.findViewById<Spinner>(R.id.monthSpinner)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner.adapter = adapter
        monthSpinner.setSelection(currentMonth)

        monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedMonth = months[position]
                // Do something with the selected month
                //calculation
                var Grocries: Int = 0
                var Restaurant: Int = 0
                var Education: Int = 0
                var Sports: Int = 0
                var Bills: Int = 0
                var Transit: Int = 0
                var Health: Int = 0
                var Maintenance: Int = 0
                var Vacation: Int = 0

                val fileNames = getFileNames()
                val month=selectedMonth.toString()
                for (file in fileNames) {
                    val fileContents = File(requireContext().filesDir, file).readText()
                    if (fileContents.contains(month)) {
                        if (fileContents.contains("Grocries")) {
                            val fin = requireContext().openFileInput(file)
                            var c: Int
                            var temp = ""
                            while (fin.read().also { c = it } != -1) {
                                temp += c.toChar().toString()
                            }
                            val arr = temp.split(",")
                            Grocries += arr[2].toInt()
                        }
                            if (fileContents.contains("Restaurant")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Restaurant += arr[2].toInt()
                            }
                            if (fileContents.contains("Education")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Education += arr[2].toInt()
                            }
                            if (fileContents.contains("Sports")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Sports += arr[2].toInt()
                            }
                            if (fileContents.contains("Bills")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Bills += arr[2].toInt()
                            }
                            if (fileContents.contains("Transit")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Transit += arr[2].toInt()
                            }
                            if (fileContents.contains("Health")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Health += arr[2].toInt()
                            }
                            if (fileContents.contains("Maintenance")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Maintenance += arr[2].toInt()
                            }
                            if (fileContents.contains("Vacation")) {
                                val fin = requireContext().openFileInput(file)
                                var c: Int
                                var temp = ""
                                while (fin.read().also { c = it } != -1) {
                                    temp += c.toChar().toString()
                                }
                                val arr = temp.split(",")
                                Vacation += arr[2].toInt()
                            }

                        }


                    }
                    //
                    val pieChart = v.findViewById<PieChart>(R.id.pieChart)
                    Log.d(TAG, "onItemSelected: $Grocries")
                    Log.d(TAG, "onItemSelected: $Restaurant")
                    Log.d(TAG, "onItemSelected: $Education")
                    Log.d(TAG, "onItemSelected: $Sports")
                    Log.d(TAG, "onItemSelected: $Bills")
                    Log.d(TAG, "onItemSelected: $Transit")
                    Log.d(TAG, "onItemSelected: $Health")
                    Log.d(TAG, "onItemSelected: $Maintenance")
                    Log.d(TAG, "onItemSelected: $Vacation")

                    val pieEntries = listOf(
                        PieEntry(Grocries.toFloat(), " Groceries "),
                        PieEntry(Restaurant.toFloat(), "Restaurant"),
                        PieEntry(Education.toFloat(), "Education"),
                        PieEntry(Sports.toFloat(), "Sports"),
                        PieEntry(Bills.toFloat(), "Bills"),
                        PieEntry(Transit.toFloat(), "Transit"),
                        PieEntry(Health.toFloat(), "Health"),
                        PieEntry(Maintenance.toFloat(), "Maintenance"),
                        PieEntry(Vacation.toFloat(), "Vacation")
                    )

                    val dataSet = PieDataSet(pieEntries, "My chart Title ")
                dataSet.colors = listOf(Color.RED, Color.GREEN, Color.BLUE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.MAGENTA,Color.DKGRAY,Color.LTGRAY)

                    dataSet.valueTextSize = 10f


                    val data = PieData(dataSet)
                    data.setValueFormatter(PercentFormatter())
                    data.setValueTextSize(10f)


                    pieChart.data = data

                    pieChart.setEntryLabelColor(Color.BLACK)
                    pieChart.animateY(1000)
                    pieChart.invalidate()

                }




            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


            return v


    }

        private fun getFileNames(): ArrayList<String> {
            val fileNames = ArrayList<String>()
            val filesDir = requireContext().filesDir
            for (file in filesDir.listFiles()) {
                fileNames.add(file.name)
                Log.d(ContentValues.TAG, "getFileNames: $file[0] " + "$file[1] ")
            }
            return fileNames
        }
    }


