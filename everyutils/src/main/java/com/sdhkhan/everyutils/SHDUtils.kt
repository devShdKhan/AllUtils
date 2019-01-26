package com.sdhkhan.everyutils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.Window

class SHDUtils {
    companion object {
        fun shareText(context: Context, title: String, message: String) {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, message)
            sendIntent.type = "text/plain"
            context.startActivity(Intent.createChooser(sendIntent, title))
        }

        fun openPlayStore(context: Context, packageName: String) {
            try {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: Exception) {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }

        }

        fun getDialog(context: Context, layout: Int): Dialog {
            val d = Dialog(context)
            d.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            d.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            d.setContentView(layout)
            return d
        }
    }
}
