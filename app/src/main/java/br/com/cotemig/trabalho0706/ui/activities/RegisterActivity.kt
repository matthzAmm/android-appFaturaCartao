package br.com.cotemig.trabalho0706.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.cotemig.trabalho0706.R
import br.com.cotemig.trabalho0706.models.User
import br.com.cotemig.trabalho0706.services.RetrofitInicializer
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        var btnRegister = findViewById<Button>(R.id.registerBtnn)
        btnRegister.setOnClickListener(){
            registerClick()
        }
    }

    override fun onBackPressed() {
        showLogin()

    }


    fun registerClick(){

        var name = findViewById<EditText>(R.id.userfieldl)
        var email = findViewById<EditText>(R.id.emailfieldl)
        var pass = findViewById<EditText>(R.id.passfieldl)

        var user = User()
        user.name = name.text.toString()
        user.email = email.text.toString()
        user.password = pass.text.toString()

        var s = RetrofitInicializer().getServiceUser()
        var call = s.create(user)

        call.enqueue(object : retrofit2.Callback<User>{

            override fun onResponse(call: Call<User>, response: Response<User>) {
            if (response.code() == 200){
                Toast.makeText(this@RegisterActivity, "Conta criada com Sucesso!", Toast.LENGTH_LONG).show()
                showLogin()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Ops", Toast.LENGTH_LONG).show()

            }
        })
    }

    fun showLogin(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}