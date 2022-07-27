package be.bf.android.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import be.bf.android.kotlindemoapp.databinding.ActivityMainBinding
import kotlin.reflect.KClass


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.count.observe(this) {
            Log.d(TAG, "onCreate: $it")
            binding.helloWorld.text = "${binding.helloWorld.text} + $it"
        }

        binding.inc.setOnClickListener { viewModel.inc() }

        binding.redirect.setOnClickListener(this::toCounterActivity)
    }

    private fun toCounterActivity(v: View) {
        val intent = Intent(this, CountActivity::class.java)
        startActivity(intent)
    }
}