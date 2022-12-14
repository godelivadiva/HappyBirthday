package com.example.pemrogramanwebsite

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemrogramanwebsite.databinding.ActivityWordsBinding

class WordsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    // set the linear layout first with true (so the icon will be linear at first)
    private var isLinearLayoutManager = true
   // change the layout when clicked the item menu
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4) // set in 4 rows
        }
        recyclerView.adapter = LetterAdapter()
    }

    // set the icon for the menu
    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return // nothing happened if there's no changing the menu
        menuItem.icon =
            // set the icon of the menu
            if (isLinearLayoutManager)
                // change to ic_linear_layout
                ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
            // change to ic_grid_layout
            else ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // get the menu layout
        menuInflater.inflate(R.menu.layout_menu, menu)

        // call the id of the menu button
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)

                return true
            }
            // override this function if there's no itemId (no clicking the button)
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        // Sets the LinearLayoutManager of the recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LetterAdapter()

        // change layout
        chooseLayout()

        title = "Words Application"
    }
}