package com.example.demowebsankul

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.demowebsankul.databinding.FragmentMaterialBinding
import com.example.demowebsankul.databinding.FragmentVideoBinding

class MaterialFragment : Fragment() {

    lateinit var binding: FragmentMaterialBinding
    lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMaterialBinding.inflate(inflater, container, false)

        sharedPref = activity?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!

        binding.btnSaveMaterial.setOnClickListener {
            val remark: String = binding.etRemark.text.toString()
            val text: String = binding.etText.text.toString()
            val change: String = binding.etChange.text.toString()
            val discount: String = binding.etDiscount.text.toString()

            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putString("remark_m", remark)
            editor.putString("text_m", text)
            editor.putString("change_m", change)
            editor.putString("discount_m", discount)
            editor.apply()

            Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)

        }

        return binding.root
    }


}