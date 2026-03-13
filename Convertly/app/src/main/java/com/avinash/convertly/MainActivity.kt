package com.avinash.convertly

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import com.avinash.convertly.ui.screens.HomeScreen
import com.avinash.convertly.utils.FileUtils
import com.avinash.convertly.converters.ImageConverter
import android.widget.Toast
import com.avinash.convertly.converters.PdfConverter
import com.avinash.convertly.converters.PdfToImageConverter
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader

class MainActivity : ComponentActivity() {

    private var selectedUri: Uri? = null
    private var onFileSelected: ((String, String?) -> Unit)? = null

    private val filePicker =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

            uri?.let {

                val mimeType = FileUtils.getMimeType(this, it)
                val category = FileUtils.getFileCategory(mimeType)

                val name = it.lastPathSegment ?: "Unknown File"

                selectedUri = it
                onFileSelected?.invoke(name, category)

            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PDFBoxResourceLoader.init(applicationContext)

        setContent {

            var selectedFile by remember { mutableStateOf<String?>(null) }
            var fileCategory by remember { mutableStateOf<String?>(null) }

            onFileSelected = { name, category ->
                selectedFile = name
                fileCategory = category
            }

            HomeScreen(
                selectedFile = selectedFile,
                fileCategory = fileCategory,
                onSelectFile = {
                    filePicker.launch("*/*")
                },
                onConvert = { format ->

                    selectedUri?.let { uri ->

                        when (format) {

                            "png" -> {

                                val file = ImageConverter.convertImage(
                                    this,
                                    uri,
                                    android.graphics.Bitmap.CompressFormat.PNG,
                                    "png"
                                )

                                if (file != null) {
                                    Toast.makeText(this, "Saved to Downloads/Convertly", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(this, "Conversion failed", Toast.LENGTH_SHORT).show()
                                }

                            }

                            "jpg" -> {

                                val file = ImageConverter.convertImage(
                                    this,
                                    uri,
                                    android.graphics.Bitmap.CompressFormat.JPEG,
                                    "jpg"
                                )

                                if (file != null) {
                                    Toast.makeText(this, "Saved to Downloads/Convertly", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(this, "Conversion failed", Toast.LENGTH_SHORT).show()
                                }

                            }

                            "webp" -> {

                                val file = ImageConverter.convertImage(
                                    this,
                                    uri,
                                    android.graphics.Bitmap.CompressFormat.WEBP,
                                    "webp"
                                )

                                if (file != null) {
                                    Toast.makeText(this, "Saved to Downloads/Convertly", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(this, "Conversion failed", Toast.LENGTH_SHORT).show()
                                }

                            }

                            "pdf" -> {

                                val file = PdfConverter.imageToPdf(
                                    this,
                                    uri
                                )

                                if (file != null) {
                                    Toast.makeText(this, "Saved to Downloads/Convertly", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(this, "Conversion failed", Toast.LENGTH_SHORT).show()
                                }

                            }

                            "image_from_pdf" -> {

                                val file = PdfToImageConverter.pdfToImage(
                                    this,
                                    uri
                                )

                                if (file != null) {
                                    Toast.makeText(this, "Saved to Downloads/Convertly", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(this, "Conversion failed", Toast.LENGTH_SHORT).show()
                                }

                            }
                        }

                    }

                }
            )
        }
    }
}