package com.ivanloy.mentalblocks

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btn_levels.setOnClickListener(this)
        btn_credits.setOnClickListener(this)
        btn_donations.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_levels -> {
                val intent = Intent(this, LevelListActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Toast.makeText(this, "WIP :(", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
