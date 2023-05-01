package com.example.expensetrackerapp.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R


class SearchData : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v =inflater.inflate(R.layout.fragment_search_data, container, false)

         val listView = v.findViewById(R.id.list) as ListView
        val fileNames = getFileNames()
        fileNames.reverse()
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            fileNames
        )
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val intValue = id.toInt()
            val item = listView.getItemAtPosition(intValue).toString()
            val bundle = Bundle()
            bundle.putString("heading", item)
            Log.d(TAG, "onCreateView: $item")

            // Create an instance of FragmentB
            val fragmentB = AmountSlip()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.amountfragment, fragmentB)
                .addToBackStack(null)
                .commit()

        }

        return v
    }
    private fun getFileNames(): ArrayList<String> {
        val fileNames = ArrayList<String>()
        val filesDir = requireContext().filesDir
        for (file in filesDir.listFiles()) {
            fileNames.add(file.name)
            Log.d(TAG, "getFileNames: $file[0] " +"$file[1] ")
        }
        return fileNames
    }

}