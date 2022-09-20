package com.tuc.retailpos.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.tuc.retailpos.databinding.CustomAlertDialogBinding
import com.tuc.retailpos.databinding.CustomAnnouncementDialogBinding


object DialogUtils {

    fun Context.showCustomAlertDialog(
        layoutInflater: LayoutInflater, alertTitle: String, alertMessage: String,
        positiveButtonText: String, negativeButtonText: String, isCanceledOnTouchOutside: Boolean,
        onPositiveButtonClick: () -> Unit, onNegativeButtonClick: () -> Unit
    ): Dialog {
        val alertDialog = Dialog(this)
        val view = CustomAlertDialogBinding.inflate(layoutInflater)
        alertDialog.setContentView(view.root)
        alertDialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        view.apply {
            alertTitleTextView.text = alertTitle
            alertMessageTextView.text = alertMessage
            positiveButtonTextView.text = positiveButtonText
            negativeButtonTextView.text = negativeButtonText
            ivLogo.visibility = View.GONE

            positiveButtonTextView.setOnClickListener {
                alertDialog.dismiss()
                onPositiveButtonClick()
            }

            negativeButtonTextView.setOnClickListener {
                alertDialog.dismiss()
                onNegativeButtonClick()
            }
        }
        return alertDialog
    }

    fun Context.showCustomAlertDialogWithLogo(
        layoutInflater: LayoutInflater, alertTitle: String, alertMessage: String, alertLogo: Int,
        positiveButtonText: String, negativeButtonText: String, isCanceledOnTouchOutside: Boolean,
        onPositiveButtonClick: () -> Unit, onNegativeButtonClick: () -> Unit
    ): Dialog {
        val alertDialog = Dialog(this)
        val view = CustomAlertDialogBinding.inflate(layoutInflater)
        alertDialog.setContentView(view.root)
        alertDialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        view.apply {
            alertMessageTextView.text = alertMessage
            positiveButtonTextView.text = positiveButtonText
            negativeButtonTextView.text = negativeButtonText
            alertTitleTextView.visibility = View.GONE
            ivLogo.setImageResource(alertLogo)

            positiveButtonTextView.setOnClickListener {
                alertDialog.dismiss()
                onPositiveButtonClick()
            }

            negativeButtonTextView.setOnClickListener {
                alertDialog.dismiss()
                onNegativeButtonClick()
            }
        }
        return alertDialog
    }

    fun Context.showCustomAnnounceDialog(
        layoutInflater: LayoutInflater, alertTitle: String, alertMessage: String, alertLogo: Int,
        isCanceledOnTouchOutside: Boolean
    ): Dialog {
        var alertDialog = Dialog(this)

        // custom dialog
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = CustomAnnouncementDialogBinding.inflate(layoutInflater)
        alertDialog.setContentView(view.root)
        alertDialog.setCancelable(isCanceledOnTouchOutside)

        view.apply {
            alertMainText.text = alertTitle
            alertSubText.text = alertMessage
            ivLogo.setImageResource(alertLogo)
        }

        return alertDialog
    }

}