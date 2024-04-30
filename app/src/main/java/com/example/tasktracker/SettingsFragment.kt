package com.example.tasktracker

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tasktracker.databinding.FragmentSettingsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {



    private var _binding: FragmentSettingsBinding?=null

    private val binding get()=_binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding= FragmentSettingsBinding.inflate(inflater, container, false)

        val view=binding?.root


        binding?.black?.setOnClickListener{
            applyBlackgroundColor(Color.BLACK)

        }

        binding?.green?.setOnClickListener{
            applyBlackgroundColor(Color.GREEN)
        }

        binding?.cyan?.setOnClickListener{
            applyBlackgroundColor(Color.CYAN)
        }

        binding?.white?.setOnClickListener{
            applyBlackgroundColor(Color.WHITE)
        }

        return view
    }


    fun applyBlackgroundColor(color :Int)
    {
        getActivity()?.getWindow()?.getDecorView()?.setBackgroundColor(color)
    }



}