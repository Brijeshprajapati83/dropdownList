package com.example.demowebsankul

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demowebsankul.data.User
import com.example.demowebsankul.data.UserViewModel
import com.example.demowebsankul.databinding.FragmentVideoBinding
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment : Fragment() {

    lateinit var binding: FragmentVideoBinding
    lateinit var sharedPreferences: SharedPreferences

    private var dataList = arrayListOf<VehicalModel>()


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentVideoBinding.inflate(inflater, container, false)

        sharedPreferences = activity?.getSharedPreferences("SHARED_PREF", MODE_PRIVATE)!!

        dataList.add(VehicalModel("Honda","bike",2000,"GJ01"))
        dataList.add(VehicalModel("Bajaj","activa",1000,"GJ02"))
        dataList.add(VehicalModel("Tvs","activa",100,"GJ05"))

        binding.btnSave.setOnClickListener {
            val cmpName: String = binding.et1.text.toString()
            val modlName: String = binding.et2.text.toString()
            val price: String = binding.et3.text.toString()
            val numberPlate: String = binding.et4.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("cmp_Name", cmpName)
            editor.putString("modl_Name", modlName)
            editor.putString("price_p", price)
            editor.putString("number_Plate", numberPlate)
            editor.apply()

            Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)

        }

        val arrayAdapter = ArrayAdapter(requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dataList)
        binding.spinner.adapter = arrayAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               binding.et1.text = dataList[p2].toString()
                binding.et2.text = "activa"
                binding.et3.text = "2000"
               binding.et4.text = "Gj04"




            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        return binding.root


    }

}