package com.mobile_app.vkeducation.intents

import android.content.Context
import android.content.Intent
import android.net.Uri

object Utils {

    // Неявный Intent — позвонить по номеру из поля
    fun openImplicit(context: Context, text: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$text")
        }
        context.startActivity(intent)
    }

    // Явный Intent — открыть SecondActivity и передать текст
    fun openExplicit(context: Context, text: String) {
        val intent = Intent(context, SecondActivity::class.java).apply {
            putExtra("EXTRA_TEXT_KEY", text)
        }
        context.startActivity(intent)
    }

    // Системный Intent — поделиться текстом
    fun shareText(context: Context, text: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivity(Intent.createChooser(intent, "Поделиться через..."))
    }
}