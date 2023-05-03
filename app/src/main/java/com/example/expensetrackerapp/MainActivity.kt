package com.example.expensetrackerapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.expensetrackerapp.Fragment.Adddata
import com.example.expensetrackerapp.Fragment.SearchData
import com.example.expensetrackerapp.Fragment.ViewData
import com.example.expensetrackerapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationView: NavigationView
    private lateinit var binding: ActivityMainBinding


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Adddata())

        binding.bottomnav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.add_nav -> replaceFragment(Adddata())
                R.id.find_nav -> replaceFragment(SearchData())
                R.id.show_nav -> replaceFragment(com.example.expensetrackerapp.Fragment.ViewData())
                else -> {

                }
            }
            true
        }

        //====================================================================================================

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Replace the initial fragment with your desired fragment
        val initialFragment = Adddata()
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, initialFragment).commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.add -> supportFragmentManager.beginTransaction().replace(R.id.framelayout,Adddata())
                .commit()
            R.id.list -> supportFragmentManager.beginTransaction().replace(R.id.framelayout,SearchData())
                .commit()
            R.id.chart -> supportFragmentManager.beginTransaction().replace(R.id.framelayout,ViewData())
                .commit()


            R.id.share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
            R.id.nav_about -> {
                // Navigate to SecondActivity
                val intent = Intent(this, aboutPage::class.java)
                startActivity(intent)
            }


        }
        if (item.itemId == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        if(item.itemId == R.id.nav_logout){

            val intent = Intent(this@MainActivity, LoginPage2::class.java)
            finish()
            startActivity(intent)
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            return true
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    fun  replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition= fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.framelayout,fragment)
        fragmentTransition.commit()
    }




}
