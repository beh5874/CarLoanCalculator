package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateBtn = findViewById(R.id.calculate) as Button
        calculateBtn.setOnClickListener {
            val carPriceText = car_price_text.text.toString()
            val downPaymentText = down_payment_text.text.toString()
            val loanPeriodText = loan_period_text.text.toString()
            val interestRateText = interest_rate_text.text.toString()

            val carLoanResult = carPriceText.toDouble() - downPaymentText.toDouble()
            val interestResult =
                carLoanResult * interestRateText.toDouble() * loanPeriodText.toDouble()
            val monthlyRepaymentResult =
                (carLoanResult + interestResult) / loanPeriodText.toDouble() / 12

            result1.visibility = View.VISIBLE
            result2.visibility = View.VISIBLE
            result3.visibility = View.VISIBLE
            car_loan_result.text = "RM%.2f".format(carLoanResult)
            interest_rate_result.text = "RM%.2f".format(interestResult)
            monthly_repayment_result.text = "RM%.2f".format(monthlyRepaymentResult)
        }
    }

}
