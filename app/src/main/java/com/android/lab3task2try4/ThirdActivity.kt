package com.android.lab3task2try4

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout

class ThirdActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toFirst: Button
    lateinit var toSecond: Button
    lateinit var toAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toFirst = findViewById(R.id.bnToFirst)
        toFirst.setOnClickListener(this)
        toSecond = findViewById(R.id.bnToSecond)
        toSecond.setOnClickListener(this)
        toAbout = findViewById(R.id.about)
        toAbout.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                toSecond.id -> {
                    finish()
                }
                toFirst.id -> {
                    setResult(RESULT_OK)
                    finish()
                }
                toAbout.id -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivityForResult(intent, 1)
                }
            }
    }

}