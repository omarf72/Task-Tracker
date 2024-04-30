package com.example.tasktracker

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

class BindingAdatpers {




    object BindingAdapters {
        @JvmStatic // Ensure this method is static
        @BindingAdapter("android:text")
        fun setBooleanText(textView: TextView, isUrgentLiveData: MutableLiveData<Boolean>?) {
            isUrgentLiveData?.value?.let { isUrgent ->
                val text = if (isUrgent) "Yes" else "No"
                textView.text = text
            }
        }
    }
}