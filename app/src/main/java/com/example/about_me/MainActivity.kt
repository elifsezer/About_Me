package com.example.about_me

import android.content.Context
import android.databinding.DataBindingUtil
import android.hardware.input.InputManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.example.about_me.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName=MyName("Elif Sezer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //databinding kullanabilmemizi sağlar.
        binding= DataBindingUtil.setContentView(this ,R.layout.activity_main)
        binding.myName=myName
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

   // bind:visibility="@{user.isAdult ? View.VISIBLE . View.INVISIVLE}"

    fun addNickName(view: View) {

        binding.apply {
            myName?.nickname=nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}
