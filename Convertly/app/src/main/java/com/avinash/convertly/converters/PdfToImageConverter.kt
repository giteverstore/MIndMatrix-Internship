package com.avinash.convertly.converters

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import com.tom_roush.pdfbox.pdmodel.PDDocument
import com.tom_roush.pdfbox.rendering.PDFRenderer
import java.io.File
import java.io.FileOutputStream

object PdfToImageConverter {

    fun pdfToImage(context: Context, uri: Uri): File? {

        return try {

            val inputStream = context.contentResolver.openInputStream(uri)
                ?: return null

            val document = PDDocument.load(inputStream)
            inputStream.close()

            val renderer = PDFRenderer(document)

            // Convert first page
            val bitmap: Bitmap = renderer.renderImageWithDPI(0, 300f)

            val downloadsDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "Convertly"
            )

            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }

            val outputFile = File(
                downloadsDir,
                "pdf_page_${System.currentTimeMillis()}.png"
            )

            val outputStream = FileOutputStream(outputFile)

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)

            outputStream.flush()
            outputStream.close()

            document.close()

            outputFile

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}