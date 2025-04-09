package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConctactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conctact_detail)



        val tvName= findViewById<TextView>(R.id.tv_name)
        val tvPhone= findViewById<TextView>(R.id.tv_phone)
        val image= findViewById<ImageView>(R.id.image)
        val tvShare= findViewById<TextView>(R.id.tv_share_contact)


        val name = intent.getStringExtra("nome")
        val phone = intent.getStringExtra("phone")
        val icon = intent.getIntExtra("icon", R.drawable.sample1)

        tvName.text = name
        tvPhone.text = phone
        image.setImageResource(icon)


        tvShare.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,"$name, $phone")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)


        }



    }
}