package com.example.expensetrackerapp.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.R

class Adddata : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_adddata, container, false)
        val button1 = v.findViewById<ImageButton>(R.id.button1)
        button1.setOnClickListener {
            val abc = "Grocries".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)

            // Create an instance of FragmentB
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button2 = v.findViewById<ImageButton>(R.id.button2)

        button2.setOnClickListener {
            val abc = "Restaurant".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button3 = v.findViewById<ImageButton>(R.id.button3)
        button3.setOnClickListener {
            val abc = "Education".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button4 = v.findViewById<ImageButton>(R.id.button4)
        button4.setOnClickListener {
            val abc = "Sports".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button5 = v.findViewById<ImageButton>(R.id.button5)
        button5.setOnClickListener {
            val abc = "Bills".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button6 = v.findViewById<ImageButton>(R.id.button6)
        button6.setOnClickListener {
            val abc = "Transit".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button7 = v.findViewById<ImageButton>(R.id.button7)
        button7.setOnClickListener {
            val abc = "Health".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button8 = v.findViewById<ImageButton>(R.id.button8)
        button8.setOnClickListener {
            val abc = "Maintenance".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }
        val button9 = v.findViewById<ImageButton>(R.id.button9)
        button9.setOnClickListener {
            val abc = "Vacation".toString()
            val bundle = Bundle()
            bundle.putString("text", abc)
            val fragmentB = dataentry()
            fragmentB.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.addfragment, fragmentB)
                .addToBackStack(null)
                .commit()
        }


        return v
    }
}
