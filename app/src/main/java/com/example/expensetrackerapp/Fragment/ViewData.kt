package com.example.expensetrackerapp.Fragment

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
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.helper.widget.MotionEffect.TAG
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
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
        val amount = v.findViewById<TextView>(R.id.textView2)



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

        amount.setText("₹ " +myVariableName.toString())
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
                pieChart.description.text = "Expense Detail of $month"
                pieChart.description.textSize = 14f
                pieChart.description.textColor = Color.BLACK
                    Log.d(TAG, "onItemSelected: $Grocries")
                    Log.d(TAG, "onItemSelected: $Restaurant")
                    Log.d(TAG, "onItemSelected: $Education")
                    Log.d(TAG, "onItemSelected: $Sports")
                    Log.d(TAG, "onItemSelected: $Bills")
                    Log.d(TAG, "onItemSelected: $Transit")
                    Log.d(TAG, "onItemSelected: $Health")
                    Log.d(TAG, "onItemSelected: $Maintenance")
                    Log.d(TAG, "onItemSelected: $Vacation")
                val abc :Int = Grocries+Restaurant+Education+Sports+Bills+Transit+Health+Maintenance+Vacation
                    amount.setText("₹ " +abc.toString())
                    val pieEntries = listOf(
                        PieEntry(Grocries.toFloat(),  if (Grocries > 0) "Grocries" else " "),
                        PieEntry(Restaurant.toFloat(), if (Restaurant > 0) "Restaurant" else " "),
                        PieEntry(Education.toFloat(), if (Education > 0) "Education" else " "),
                        PieEntry(Sports.toFloat(), if (Sports > 0) "Sports" else " "),
                        PieEntry(Bills.toFloat(), if (Bills > 0) "Bills" else " "),
                        PieEntry(Transit.toFloat(), if (Transit > 0) "Transit" else " "),
                        PieEntry(Health.toFloat(), if (Health > 0) "Health" else " "),
                        PieEntry(Maintenance.toFloat(), if (Maintenance > 0) "Maintenance" else " "),
                        PieEntry(Vacation.toFloat(), if (Vacation > 0) "Vacation" else " ")
                    )

                    val dataSet = PieDataSet(pieEntries, "My chart Title ")
                dataSet.colors = listOf(Color.RED, Color.GREEN, Color.BLUE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.MAGENTA,Color.DKGRAY,Color.LTGRAY)

                    dataSet.valueTextSize = 10f


                    val data = PieData(dataSet)
                    data.setValueFormatter(PercentFormatter())
                    data.setValueTextSize(10f)
                data.setValueFormatter(object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return if (value == 0f) "" else value.toInt().toString()
                    }
                })

                    pieChart.data = data
                pieChart.setCenterText("Total\n$abc")
                pieChart.setCenterTextSize(20f)

                pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                    private fun getIndexOfMaxValue(): Int {
                        var maxIndex = 0
                        var maxValue = 0f
                        for (i in 0 until pieChart.data.entryCount) {
                            val entry = pieChart.data.dataSets[0].getEntryForIndex(i)
                            if (entry.y > maxValue) {
                                maxValue = entry.y
                                maxIndex = i
                            }
                        }
                        return maxIndex
                    }
                    override fun onValueSelected(e: Entry?, h: Highlight?) {
                        if (e == null) {
                            // No value selected, show maximum value
                            val maxEntry = pieChart.data.dataSets[0].getEntryForIndex(getIndexOfMaxValue())
                            val maxValue = maxEntry.y.toInt().toString()

                            pieChart.setCenterText("$maxValue")
                        } else {
                            // A value was selected, show its label and value
                            var label =""
                            if (e is PieEntry) {
                                 label = e.label.toString()
                            }
                            val value = e.y.toInt().toString()
                            pieChart.setCenterText("$label\n$value")
                        }
                    }
                    override fun onNothingSelected() {
                        // No value selected, show maximum value
                        val maxEntry = pieChart.data.dataSets[0].getEntryForIndex(getIndexOfMaxValue())
                        val maxValue = maxEntry.y.toInt().toString()
                        pieChart.setCenterText("Total\n$abc")
                    }
                })
                    pieChart.setEntryLabelColor(Color.BLACK)

                    pieChart.animateY(1000)

                pieChart.legend.isEnabled = false
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
                val abc =file.toString()
                if(abc.contains("login")|| abc.contains("users")){
                    continue
                }
                fileNames.add(file.name)
//               Log.d(ContentValues.TAG, "hello: $file[0] " + "$file[1] ")
            }
            return fileNames
        }


}




