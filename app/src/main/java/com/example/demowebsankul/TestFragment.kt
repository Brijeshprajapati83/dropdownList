package com.example.demowebsankul

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demowebsankul.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    lateinit var binding: FragmentTestBinding
    lateinit var testSharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)

        testSharedPref = activity?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!


            binding.btnSaveTest.setOnClickListener {
//                val online: String = binding.radioOnline.isChecked.toString()
//                val cash: String = binding.radioCash.isChecked.toString()
//
//                val editor: SharedPreferences.Editor = testSharedPref.edit()
//                editor.putString("online_t", online)
//                editor.putString("cash_t", cash)
//                editor.apply()
//
//                Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()
//
//                val intent = Intent(requireContext(), ThirdActivity::class.java)
//                startActivity(intent)

            }
        return binding.root
        }

    }
