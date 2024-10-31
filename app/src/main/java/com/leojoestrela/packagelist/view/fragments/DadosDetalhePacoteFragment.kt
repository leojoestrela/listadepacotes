package com.leojoestrela.packagelist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leojoestrela.packagelist.databinding.FragmentDadosDetalhePacoteBinding

class DadosDetalhePacoteFragment : Fragment() {

    private lateinit var binding: FragmentDadosDetalhePacoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDadosDetalhePacoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}