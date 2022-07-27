package be.bf.android.Kotlin_MVVM_Demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import be.bf.android.Kotlin_MVVM_Demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.count.observe(this) {
            binding.helloWorld.text = it.toString()
        }

        binding.inc.setOnClickListener { viewModel.inc() }
        binding.redirect.setOnClickListener(this::toCounterActivity)
    }

    private fun toCounterActivity(v: View) {
        val intent = Intent(this, CountActivity::class.java)
        startActivity(intent)
    }
}