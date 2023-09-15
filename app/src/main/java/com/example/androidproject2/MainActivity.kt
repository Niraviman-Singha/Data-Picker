package com.example.androidproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var image: Button
    private lateinit var name:EditText
    private lateinit var phone:EditText
    private lateinit var email:EditText
    private lateinit var address:EditText
    private lateinit var dob:EditText
    private val pickImage = 100
    private lateinit var next:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageBTN)
        name = findViewById(R.id.nameET)
        phone = findViewById(R.id.phoneET)
        email = findViewById(R.id.emailET)
        address = findViewById(R.id.addressET)
        dob = findViewById(R.id.dobET)
        next = findViewById(R.id.nextBtn)

        image.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        next.setOnClickListener {
            var userName:String = name.getText().toString()
            var userPhone:String = phone.getText().toString()
            var userEmail:String = email.getText().toString()
            var userAddress:String = address.getText().toString()
            var userDob:String = dob.getText().toString()

            var intent = Intent(this@MainActivity,BiodataActivity::class.java)
            intent.putExtra("username",userName)
            intent.putExtra("userphone",userPhone)
            intent.putExtra("useremail",userEmail)
            intent.putExtra("useraddress",userAddress)
            intent.putExtra("userdob",userDob)
            startActivity(intent)
        }
    }

}