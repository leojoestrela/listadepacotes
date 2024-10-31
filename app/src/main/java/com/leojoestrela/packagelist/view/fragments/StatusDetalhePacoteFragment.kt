package com.leojoestrela.packagelist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.leojoestrela.packagelist.databinding.FragmentStatusDetalhePacoteBinding
import com.leojoestrela.packagelist.model.StatusPacote
import com.leojoestrela.packagelist.view.adapters.StatusDetalhePacoteAdapter


class StatusDetalhePacoteFragment : Fragment() {
    private var statusPacote: ArrayList<StatusPacote>? = null

    private lateinit var binding: FragmentStatusDetalhePacoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            statusPacote = it.getParcelableArrayList("status_pacote")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatusDetalhePacoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statusDetalheAdapter = StatusDetalhePacoteAdapter(statusPacote!!)

        binding.recyclerDetalheStatus.layoutManager = LinearLayoutManager(context)
        binding.recyclerDetalheStatus.adapter = statusDetalheAdapter
    }

}