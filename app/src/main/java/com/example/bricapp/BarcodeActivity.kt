package com.example.bricapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer
import java.lang.NullPointerException

class BarcodeActivity : DialogFragment() {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.barcode_page)

        var barcodeImg: ImageView = findViewById(R.id.barcodeImg)
        var barcodeText: TextView = findViewById(R.id.barcodeText)
        var refreshBtn: Button = findViewById(R.id.refreshBarcodeBtn)

        displayBitmap("10145432932", barcodeImg, barcodeText)

    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View = inflater.inflate(R.layout.barcode_page, container, false)
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var barcodeImg: ImageView = view.findViewById(R.id.barcodeImg)
        var barcodeText: TextView = view.findViewById(R.id.barcodeText)
        var refreshBtn: Button = view.findViewById(R.id.refreshBarcodeBtn)
        var closeBtn: Button = view.findViewById(R.id.closeBarcodeBtn)

        displayBitmap("10145432932", barcodeImg, barcodeText)


        closeBtn.setOnClickListener{
            dismiss()
        }

    }


    //this code to generate barcodes come from:
    //https://medium.com/@nick.holcombe/howto-creating-a-barcode-in-kotlin-android-8476e6b54d18
    private fun createBarcodeBitmap(
        barcodeValue: String,
        @ColorInt barcodeColor: Int,
        @ColorInt backgroundColor: Int,
        widthPixels: Int,
        heightPixels: Int
    ): Bitmap {
        val bitMatrix = Code128Writer().encode(
            barcodeValue,
            BarcodeFormat.CODE_128,
            widthPixels,
            heightPixels
        )

        val pixels = IntArray(bitMatrix.width * bitMatrix.height)
        for (y in 0 until bitMatrix.height) {
            val offset = y * bitMatrix.width
            for (x in 0 until bitMatrix.width) {
                pixels[offset + x] =
                    if (bitMatrix.get(x, y)) barcodeColor else backgroundColor
            }
        }

        val bitmap = Bitmap.createBitmap(
            bitMatrix.width,
            bitMatrix.height,
            Bitmap.Config.ARGB_8888
        )
        bitmap.setPixels(
            pixels,
            0,
            bitMatrix.width,
            0,
            0,
            bitMatrix.width,
            bitMatrix.height
        )
        return bitmap
    }



    private fun displayBitmap(value: String, image: ImageView, text: TextView) {
        val widthPixels = 500
        val heightPixels = 300

        image.setImageBitmap(
            createBarcodeBitmap(
                barcodeValue = value,
                barcodeColor = Color.BLACK,
                backgroundColor = Color.WHITE,
                widthPixels = widthPixels,
                heightPixels = heightPixels
            )
        )
        text.text = value
    }



}