package com.example.expensetrackerapp.Fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.MainActivity
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.UpdateData
import java.io.File

class AmountSlip : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val value = this.arguments?.getString("heading")

        val v = inflater.inflate(R.layout.fragment_amount_slip, container, false)
        val heading = v.findViewById<TextView>(R.id.my_text_view)
        val amount2 = v.findViewById<TextView>(R.id.textView2)
        val date2 = v.findViewById<TextView>(R.id.textView6)
        val note2 = v.findViewById<TextView>(R.id.textView4)
        Log.d(TAG, "onCreateView: $value")
        val file = value
        val fin = activity?.openFileInput(file)

        var c: Int
        var temp = ""
        if (fin != null) {
            while (fin.read().also { c = it } != -1) {
                temp += c.toChar().toString()
            }
        }
        val arr = temp.split(",")
        heading.setText(arr[0])
        note2.setText(arr[1])
        amount2.setText("₹ " + arr[2])
        date2.setText(arr[3])

        val close = v.findViewById<ImageButton>(R.id.closeButton)
        val update = v.findViewById<Button>(R.id.update_button)
        val delete = v.findViewById<Button>(R.id.delete_button)
        close.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }
        delete.setOnClickListener {
            val file = File(requireContext()?.filesDir, value)
            val deleted = file.delete()
            if (deleted) {
                Toast.makeText(requireContext(), "File Deleted Successfully ", Toast.LENGTH_LONG)
                    .show()
            }
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

            requireActivity().supportFragmentManager.popBackStack()


        }
        update.setOnClickListener{

            val intent = Intent(activity, UpdateData::class.java)
            intent.putExtra("value",value)
            startActivity(intent)

        }


        return v
    }


}