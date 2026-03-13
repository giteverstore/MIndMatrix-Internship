package com.avinash.convertly.utils

import android.content.Context
import android.net.Uri

object FileUtils {

    fun getMimeType(context: Context, uri: Uri): String? {
        return context.contentResolver.getType(uri)
    }

    fun getFileCategory(mimeType: String?): String {

        return when {
            mimeType?.startsWith("image") == true -> "image"

            mimeType == "application/pdf" -> "pdf"

            mimeType?.contains("spreadsheet") == true ||
                    mimeType?.contains("excel") == true -> "excel"

            mimeType?.contains("wordprocessingml") == true -> "word"

            mimeType == "text/csv" -> "csv"

            else -> "unknown"
        }
    }

}