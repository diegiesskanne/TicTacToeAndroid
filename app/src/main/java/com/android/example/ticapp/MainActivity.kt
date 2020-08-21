package com.android.example.ticapp

import android.os.Bundle
import android.util.DisplayMetrics
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import java.nio.channels.Selector

class MainActivity : AppCompatActivity() {

    //private lateinit var itemSelector: Selector
    //private val model: SharedViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val fragman: FragmentManager = supportFragmentManager
        val frag: NavHostFragment = fragman.findFragmentById(R.id.FirstFragment) as NavHostFragment
        val childfrag: FirstFragment = frag.childFragmentManager.fragments[0] as FirstFragment


        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.reset_settings -> {
                childfrag.reset()
                true
            }
            R.id.toggle_dm -> {
                if(AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                }else{
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}