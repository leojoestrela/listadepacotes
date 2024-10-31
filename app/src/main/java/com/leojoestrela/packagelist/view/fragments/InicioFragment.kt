package com.leojoestrela.packagelist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.leojoestrela.packagelist.databinding.FragmentInicioBinding
import com.leojoestrela.packagelist.model.Pacote
import com.leojoestrela.packagelist.model.StatusPacote
import com.leojoestrela.packagelist.view.adapters.ListaPacotesAdapter

class InicioFragment : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inicioToolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }

        val listaPacotesAdapter = ListaPacotesAdapter(createMock())

        binding.inicioRecyclerviewListaPacotes.layoutManager = LinearLayoutManager(context)
        binding.inicioRecyclerviewListaPacotes.adapter = listaPacotesAdapter
    }

    private fun createMock(): ArrayList<Pacote> {
        val list: ArrayList<Pacote> = ArrayList()
        val listStatus: ArrayList<StatusPacote> = ArrayList()

        listStatus += StatusPacote("1", "Pacote enviado", "31/10/2024")
        listStatus +=StatusPacote("2", "Pacote devolvido", "01/11/2024")

        list += Pacote("1", "111111111-11", "1", "Natal/RN", "IFRN", "2 ano EM", "Matemática", listStatus)
        list += Pacote("2", "222222222-22", "2", "Parnamirim/RN", "UFRN", "3 ano EM", "Calculo II", listStatus)
        list += Pacote("3", "333333333-33", "3", "Curitiba/PR", "E.E. Exemplo", "9 ano EF", "Biologia", listStatus)
        list += Pacote("4", "444444444-44", "4", "São Paulo/SP", "E.M. Exemplo", "8 ano EF", "História", listStatus)
        return list
    }
}