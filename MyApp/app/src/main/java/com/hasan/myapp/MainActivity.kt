package com.hasan.myapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hasan.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private val myName:MyName = MyName(fistName = "",lastName = "", fullName = "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            setFullName()
        }
    }
    private fun setFullName(){
        binding.apply {
            invalidateAll()
            myName.fistName = binding.firstName.text.toString()
            myName.lastName = binding.lastName.text.toString()
            myName.fullName = myName.fistName + myName.lastName
            myName.fistName = ""
            myName.lastName = ""
            binding.name = myName
        }
    }
}
