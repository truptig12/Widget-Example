package com.herts.studyexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.herts.studyexamples.databinding.ActivityObserverBinding
import com.herts.studyexamples.databinding.ActivityObserverNewBinding

class ObserverActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityObserverNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observer_new)
         val quoteObj = Quote("Hello World!", "https://picsum.photos/200/300")
         binding.quote = quoteObj
//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        lifecycle.addObserver(Observer())
//        Log.d("MAIN", "Activity on create")
        //setText()

//        mainViewModel.quoteLiveData.observe(this, Observer {
//            binding.textView.text = it
//        })

//        binding.mainviewmodel = mainViewModel
//        binding.lifecycleOwner = this

//        binding.button.setOnClickListener {
//            mainViewModel.updateQuote()
//        }


    }

    /* private fun setText() {
         binding.textView.text = mainViewModel.count.toString()
     }

     fun increment(v: View) {
         mainViewModel.increment()
         setText()
     }*/
}