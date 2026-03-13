package com.avinash.convertly.converters

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Environment
import java.io.File
import java.io.FileOutputStream

object PdfConverter {

    fun imageToPdf(
        context: Context,
        inputUri: Uri
    ): File? {

        return try {

            val inputStream = context.contentResolver.openInputStream(inputUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            inputStream?.close()

            val pdfDocument = PdfDocument()

            val pageInfo = PdfDocument.PageInfo.Builder(
                bitmap.width,
                bitmap.height,
                1
            ).create()

            val page = pdfDocument.startPage(pageInfo)

            val canvas = page.canvas
            canvas.drawBitmap(bitmap, 0f, 0f, null)

            pdfDocument.finishPage(page)

            val downloadsDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "Convertly"
            )

            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }

            val file = File(
                downloadsDir,
                "converted_${System.currentTimeMillis()}.pdf"
            )

            pdfDocument.writeTo(FileOutputStream(file))
            pdfDocument.close()

            file

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}