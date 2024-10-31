package com.leojoestrela.packagelist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leojoestrela.packagelist.databinding.FragmentTutoriaisBinding

class TutoriaisFragment : Fragment() {

    private lateinit var binding: FragmentTutoriaisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTutoriaisBinding.inflate(inflater, container, false)
        return binding.root
    }

}