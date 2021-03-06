package com.android.example.ticapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.example.ticapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private var frag: NavHostFragment? = null
    private var fragman: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        drawerLayout = binding.drawerLayout
        fragman = supportFragmentManager
        frag = fragman!!.findFragmentById(R.id.FirstFragment) as NavHostFragment
        val navController = frag!!.findNavController()

        NavigationUI.setupWithNavController(binding.navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
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
        //println(childfrag)
        //val childfrag: FirstFragment = frag?.childFragmentManager?.fragments?.get(0) as FirstFragment


        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.reset_settings -> {
                (frag?.childFragmentManager?.fragments?.get(0) as FirstFragment).reset()
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

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.FirstFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}