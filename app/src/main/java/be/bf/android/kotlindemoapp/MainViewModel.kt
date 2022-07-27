package be.bf.android.kotlindemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    private var _count: Int = 0
    val count: MutableLiveData<Int> = MutableLiveData(_count)

    fun inc() {
        _count++;
        count.value = _count
    }
}