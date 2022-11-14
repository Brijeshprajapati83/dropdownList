package com.example.demowebsankul

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demowebsankul.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    lateinit var binding : ActivityThirdBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)!!


        binding.btnShow.setOnClickListener {
            val cName = preferences.getString("cmp_Name", "")
            binding.txCmpName.text = cName
            Log.e(TAG, "cName: " + cName, )
            val mName = preferences.getString("modl_Name", "")
            binding.txModlName.text = mName
            Log.e(TAG, "mName: " + mName, )
            val pPrice = preferences.getString("price_p", "")
            binding.txPrice.text = pPrice
            Log.e(TAG, "pPrice: " + pPrice, )
            val nNumber = preferences.getString("number_Plate", "")
            binding.txNumberPlate.text = nNumber
            Log.e(TAG, "nNumber: " + nNumber,)

            val mMark = preferences.getString("remark_m", "")
            binding.txRemark.text = mMark
            val mText = preferences.getString("text_m", "")
            binding.txText.text = mText
            Log.e(TAG, "mText: " + mText, )
            val mChange = preferences.getString("change_m", "")
            binding.txChange.text = mChange
            val mDiscount = preferences.getString("discount_m", "")
            binding.txDiscount.text = mDiscount

//            val rOnline = preferences.getBoolean("online_t",true)
//            binding.radioOn.isChecked = rOnline
//
//            val rCash = preferences.getBoolean("cash_t",true)
//            binding.radioCs.isChecked = rCash

        }



    }
}