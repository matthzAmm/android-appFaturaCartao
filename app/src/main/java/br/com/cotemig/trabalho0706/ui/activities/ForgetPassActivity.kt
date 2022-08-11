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

class ForgetPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)

        var btnForget = findViewById<Button>(R.id.loginBtnn)
        btnForget.setOnClickListener { forgetPass() }

    }

    fun forgetPass(){

        var s = RetrofitInicializer().getServiceUser()

        var user = User()
        var email = findViewById<EditText>(R.id.emailfieldd)

        user.email = email.text.toString()

        var call = s.forgot(user)


        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                Toast.makeText(
                    this@ForgetPassActivity,
                    "Email enviado com sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                showLogin()

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    this@ForgetPassActivity,
                    "Ops",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }

    override fun onBackPressed() {
        showLogin()
    }

    fun showLogin(){
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}