package br.com.cotemig.trabalho0706.ui.activities

import android.accounts.Account
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import br.com.cotemig.trabalho0706.R
import br.com.cotemig.trabalho0706.models.User
import br.com.cotemig.trabalho0706.services.RetrofitInicializer
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var btnLogin = findViewById<Button>(R.id.loginBtn)
        btnLogin.setOnClickListener {
            login()
        }

        var btnRegister = findViewById<Button>(R.id.register)
        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnForgot = findViewById<Button>(R.id.forgetPass)
        btnForgot.setOnClickListener {
            var intent = Intent(this, ForgetPassActivity::class.java)
            startActivity(intent)
            finish()
        }
        
    }

    fun login() {
        var s = RetrofitInicializer().getServiceUser()

        var user = User()
        var login = findViewById<EditText>(R.id.emailfield)
        var password = findViewById<EditText>(R.id.passfield)
        user.email =login.text.toString()
        user.password = password.text.toString()

        var call = s.auth(user)

        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                if (response.code() == 200) {

                    response.body()?.let {
                        validLogin(it)
                    }


                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário ou Senha Inválidos",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    this@LoginActivity,
                    "Ops",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

    }

    fun validLogin(user: User) {
        var intent = Intent(this, PrinActivity::class.java)
        intent.putExtra("token", user.token)
        intent.putExtra("id", user.id)
        intent.putExtra("email", user.email)
        intent.putExtra("name", user.name)
        startActivity(intent)
    }
}