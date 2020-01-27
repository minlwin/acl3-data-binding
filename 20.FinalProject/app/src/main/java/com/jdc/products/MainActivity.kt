package com.jdc.products

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        MainActivity.resources = resources

        navController = findNavController(R.id.fragment)
        toolbar.setupWithNavController(navController, AppBarConfiguration(navController.graph))

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(R.id.categories == destination.id) {
                fab.show()
            } else {
                fab.hide()
            }
        }

        fab.setOnClickListener {
            navController.navigate(R.id.action_categories_to_categoryEdit)
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    companion object {
        lateinit var resources: Resources
    }
}
