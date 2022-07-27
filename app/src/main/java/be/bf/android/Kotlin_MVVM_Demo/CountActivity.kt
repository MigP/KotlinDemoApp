package be.bf.android.Kotlin_MVVM_Demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import be.bf.android.Kotlin_MVVM_Demo.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {
    private val countViewModel: MainViewModel by viewModels()
    private lateinit var view: ActivityCountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityCountBinding.inflate(layoutInflater)
        setContentView(view.root)

        countViewModel.count.observe(this) { view.counter.text = it.toString() }
        view.inc.setOnClickListener { countViewModel.inc() }
    }
}