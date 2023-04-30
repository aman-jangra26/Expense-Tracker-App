package com.example.expensetrackerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.Fragment.Adddata
import com.example.expensetrackerapp.Fragment.SearchData
import com.example.expensetrackerapp.databinding.ActivityMainBinding
import com.example.expensetrackerapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Adddata())

        binding.bottomnav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.add_nav ->replaceFragment(Adddata())
                R.id.find_nav ->replaceFragment(SearchData())
                R.id.show_nav ->replaceFragment(com.example.expensetrackerapp.Fragment.ViewData())
                else ->{

                }
            }
            true
        }

    }
    fun  replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition= fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.framelayout,fragment)
        fragmentTransition.commit()
    }




}
