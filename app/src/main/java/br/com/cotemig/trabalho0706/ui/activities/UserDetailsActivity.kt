package br.com.cotemig.trabalho0706.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.cotemig.trabalho0706.R

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        var name = findViewById<TextView>(R.id.name)
        var email = findViewById<TextView>(R.id.email)

        name.text = intent.getStringExtra("name")
        email.text = intent.getStringExtra("email")

        var btnaddcard = findViewById<Button>(R.id.registerBtn)
        btnaddcard.setOnClickListener { addcard() }
    }


    fun addcard(){

        var number = findViewById<RelativeLayout>(R.id.relative01)
        number.setVisibility(View.VISIBLE)
        var name = findViewById<RelativeLayout>(R.id.relative02)
        name.setVisibility(View.VISIBLE)
        var date = findViewById<RelativeLayout>(R.id.relative03)
        date.setVisibility(View.VISIBLE)
        var btn02 = findViewById<Button>(R.id.finalBtn)
        btn02.setVisibility(View.VISIBLE)
        var btn01 = findViewById<Button>(R.id.registerBtn)
        btn01.text = "cancelar"
        btn02.setOnClickListener { validadd(number, name, date, btn01, btn02) }

        btn01.setOnClickListener {

            number.setVisibility(View.INVISIBLE)
            name.setVisibility(View.INVISIBLE)
            date.setVisibility(View.INVISIBLE)
            btn02.setVisibility(View.INVISIBLE)
            btn01.text = "adicionar cartão"
            btn01.setOnClickListener { addcard() }

        }
    }

    fun validadd(number: RelativeLayout, name: RelativeLayout, date: RelativeLayout, btn01: Button, btn02: Button){

        var numbertext = findViewById<EditText>(R.id.textnumber).text.toString()
        var nametext = findViewById<EditText>(R.id.textname).text.toString()
        var mes = findViewById<EditText>(R.id.textmes).text.toString()
        var ano = findViewById<EditText>(R.id.textano).text.toString()
        var cod = findViewById<EditText>(R.id.textcod).text.toString()

        if ((numbertext != "") && (nametext != "")&& (mes != "")&& (ano != "")&& (cod != "")){
            Toast.makeText(
                this@UserDetailsActivity,
                "Cartão adicionado com sucesso!",
                Toast.LENGTH_LONG
            ).show()

        }else{
            Toast.makeText(
                this@UserDetailsActivity,
                "Valores invalidos!",
                Toast.LENGTH_LONG
            ).show()


        }

        number.setVisibility(View.INVISIBLE)
        name.setVisibility(View.INVISIBLE)
        date.setVisibility(View.INVISIBLE)
        btn02.setVisibility(View.INVISIBLE)
        btn01.text = "adicionar cartão"
        btn01.setOnClickListener { addcard() }
    }
}