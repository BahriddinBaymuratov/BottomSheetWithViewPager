package com.example.bottomsheetdialog.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.bottomsheetdialog.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUi()
        showCardPayment()
    }

    private fun setUpUi() {
        val bottomSheet: View = findViewById(R.id.bottom_sheet)
        val payBtn: Button = findViewById(R.id.btnShow)
        val sheetBehavior = BottomSheetBehavior.from(bottomSheet)

        sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        payBtn.setOnClickListener {
            if (sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                sheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
        }
    }

    private fun showCardPayment() {
        val cashback_layout = findViewById<LinearLayout>(R.id.cashback_layout)
        val card_layout = findViewById<LinearLayout>(R.id.card_layout)
        val card_checkbox = findViewById<CheckBox>(R.id.card_checkbox)
        val cashback_checkbox = findViewById<CheckBox>(R.id.cashBack_checkbox)

        cashback_layout.setOnClickListener {
            if (cashback_checkbox.isChecked) {
                cashback_checkbox.isChecked = false
                Log.d("@@@", "showCardPayment: IF")
            } else {
                Log.d("@@@", "showCardPayment: ELSE")
                cashback_checkbox.isChecked = true
                card_checkbox.isChecked = false
            }
        }
        card_layout.setOnClickListener {
            if (card_checkbox.isChecked) {
                card_checkbox.isChecked = false
            } else {
                card_checkbox.isChecked = true
                cashback_checkbox.isChecked = false
            }
        }
    }
}
