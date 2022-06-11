package com.tsci.flightapp.presentation.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tsci.flightapp.databinding.ActivityLoginBinding
import com.tsci.weatherapp.presentation.navigation.ScreensNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (viewModel.checkMailAndPassword(
                    mail = binding.mailEdittext.text.toString(),
                    password = binding.passwordEdittext.text.toString()
                )
            ) {
                val sharedPref = baseContext.getSharedPreferences(          // TODO: Bu preferences işlemleri ayrı bir sınıfta toplanır ve o sınıfın metodları üzerinden işlemler yapılır
                    LOGGED, Context.MODE_PRIVATE
                )
                if (binding.rememberMeCheckbox.isChecked){
                    sharedPref.edit().putBoolean(LOGGED, true).apply()
                }
                else{
                    sharedPref.edit().putBoolean(LOGGED, false).apply()
                }
                screensNavigator.toHomeActivity()
            }
            else{
                Toast.makeText(this, "Wrong password or mail!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {
        fun open(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
        const val LOGGED = "LOGGED"
    }
}