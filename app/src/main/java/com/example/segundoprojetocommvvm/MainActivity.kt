package com.example.segundoprojetocommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.user.observe(this){
            Toast.makeText(applicationContext, "Nome: ${it.nome} Email: ${it.email}", Toast.LENGTH_LONG).show()
        }

        btnNext.setOnClickListener {
           validateForm()
        }

    }

    private fun validateForm(){
        if (check_term.isChecked){
            val createUser = User(
                    input_name.text.trim().toString(),
                    input_email.text.trim().toString(),
                    input_password.text.trim().toString()
            )
            viewModel.sendForm(createUser)

        }else{
            Toast.makeText(applicationContext, "Para prosseguir marque a caixa de Termos de Usos", Toast.LENGTH_LONG).show()
        }
    }

}