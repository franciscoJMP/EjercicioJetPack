package com.example.ejercicioclasejetpack

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.fragment_camara.*



class camaraFragment : Fragment() {
    val REQUEST_IMAGE_CAPTURE = 1
    val callCamaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camara, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_hacerFoto.setOnClickListener {
            this.startActivityForResult(callCamaraIntent,REQUEST_IMAGE_CAPTURE)
            ActivityCompat.requestPermissions(
                (context as Activity)!!,
                arrayOf(android.Manifest.permission.CAMERA),
                REQUEST_IMAGE_CAPTURE
            )

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==Activity.RESULT_OK&&data !=null) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            iv_imagenCamara.setImageBitmap(imageBitmap)
        }
    }



}