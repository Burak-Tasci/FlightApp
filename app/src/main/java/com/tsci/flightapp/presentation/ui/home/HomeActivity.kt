package com.tsci.flightapp.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tsci.flightapp.databinding.ActivityHomeBinding
import com.tsci.flightapp.presentation.adapters.FlightsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

    }


    private fun setupRecyclerView() {
        lifecycleScope.launch {
            viewModel.state.observe(this@HomeActivity, {
                binding.rwFlights.adapter = FlightsAdapter(viewModel.state.value!!.flights)
            })
        }
    }

    companion object {
        fun open(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}