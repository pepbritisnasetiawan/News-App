package com.dicoding.submission

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Detail : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Content"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnFavorite: Button = findViewById(R.id.btn_favorite)
        val btnShare: Button = findViewById(R.id.btn_share)
        val tvTitleName: TextView = findViewById(R.id.tv_title)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvContent: TextView = findViewById(R.id.tv_content)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tContent = intent.getStringExtra(EXTRA_CONTENT)

        btnShare.setOnClickListener(this)
        btnFavorite.setOnClickListener {
            Toast.makeText(this, "Favorite", Toast.LENGTH_LONG).show()
        }

        tvTitleName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvContent.text = tContent
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_CONTENT = "extra_content"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        val btnShare = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "share with?")
            type = "text/plain"
        }
        if (btnShare.resolveActivity(packageManager) != null){
            startActivity(btnShare)
        }
    }

}