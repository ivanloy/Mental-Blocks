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
            R.id.btn_donations -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=nachovanle@gmail.com&lc=US&item_name=YOUR+PURPOSE+HERE&no_note=0&cn=&curency_code=USD&bn=PP-DonationsBF:btn_donateCC_LG.gif:NonHosted"))
                startActivity(browserIntent)
            }
            else -> {
                Toast.makeText(this, "WIP :(", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
