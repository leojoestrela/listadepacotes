package com.leojoestrela.packagelist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leojoestrela.packagelist.databinding.FragmentDadosDetalhePacoteBinding
import com.leojoestrela.packagelist.model.Pacote
import com.leojoestrela.packagelist.model.StatusPacote

class DadosDetalhePacoteFragment : Fragment() {

    private var pacote: Pacote? = null
    private lateinit var binding: FragmentDadosDetalhePacoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pacote = it.getParcelable("pacote")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDadosDetalhePacoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        pacote?.let { pct ->
            binding.textviewCodigoPacoteInfo.text = pct.codigo
            binding.textviewPontoEntregaPacoteInfo.text = pct.pontoEntrega
            binding.textviewMunicipioPacoteInfo.text = pct.municipio
            binding.textviewEscolaPacoteInfo.text = pct.escola
            binding.textviewAnoEscolarPacoteInfo.text = pct.anoEscolarEtapa
            binding.textviewComponenteCurricularPacoteInfo.text = pct.componenteCurricular
        }
    }

}