package com.avinash.convertly.converters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import android.os.Environment

object ImageConverter {

    fun convertImage(
        context: Context,
        inputUri: Uri,
        format: Bitmap.CompressFormat,
        extension: String
    ): File? {

        return try {

            val inputStream = context.contentResolver.openInputStream(inputUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            inputStream?.close()

            val downloadsDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "Convertly"
            )

            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }

            val outputFile = File(
                downloadsDir,
                "converted_${System.currentTimeMillis()}.$extension"
            )

            val outputStream = FileOutputStream(outputFile)

            bitmap.compress(format, 100, outputStream)

            outputStream.flush()
            outputStream.close()

            Log.d("Convertly", "Converted file saved: ${outputFile.absolutePath}")

            outputFile

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}