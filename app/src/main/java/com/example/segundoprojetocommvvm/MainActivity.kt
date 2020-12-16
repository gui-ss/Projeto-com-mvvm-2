package com.example.segundoprojetocommvvm

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirme seus dados")
        builder.setPositiveButton(
                "Confirmar") { dialog, id ->
            Toast.makeText(this, "Dados confirmados",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(
                "Cancelar") { dialog, id ->
        }


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.user.observe(this){
            builder.setMessage("Nome: ${it.nome} Email: ${it.email}")
            builder.show()
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