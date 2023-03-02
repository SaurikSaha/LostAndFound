package com.example.lostandfound

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.lostandfound.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var btmnavview : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btmnavview=findViewById(R.id.bottomNavigationView)
        call_fragment(Lost_items())
        btmnavview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.lostbutton -> {
                    call_fragment(Lost_items())
                    true
                }
                R.id.foundbutton -> {
                    call_fragment(Found_items())
                    true
                }
                R.id.notificationsbutton -> {
                    call_fragment(Notification())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun call_fragment(fragment: Fragment)
    {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.recyclerView,fragment)
        fragmentTransaction.commit()
    }
}