package com.example.androidproject2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView

class BiodataActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var name2:TextView
    private lateinit var phone2:TextView
    private lateinit var email2:TextView
    private lateinit var address2:TextView
    private lateinit var dob2:TextView
    private var imageUri: Uri? = null
    private val pickImage = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biodata)

        imageView = findViewById(R.id.imageView)
        name2 = findViewById(R.id.nameTV)
        phone2 = findViewById(R.id.phoneTV)
        email2 = findViewById(R.id.emailTV)
        address2 = findViewById(R.id.addressTV)
        dob2 = findViewById(R.id.dobTV)

        var gname = intent.getStringExtra("username")
        var gphone = intent.getStringExtra("userphone")
        var gemail = intent.getStringExtra("useremail")
        var gaddress = intent.getStringExtra("useraddress")
        var gdob = intent.getStringExtra("userdob")

        name2.setText("Welcome\n"+gname)
        phone2.setText("Phone: "+gphone)
        email2.setText("Gmail: "+gemail)
        address2.setText("Address: "+gaddress)
        dob2.setText("Date Of Birth: "+gdob)

         fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == RESULT_OK && requestCode == pickImage) {
                imageUri = data?.data
                imageView.setImageURI(imageUri)
            }
        }

    }



}