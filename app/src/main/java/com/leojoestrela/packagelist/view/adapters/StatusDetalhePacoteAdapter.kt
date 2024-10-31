package com.leojoestrela.packagelist.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leojoestrela.packagelist.databinding.LayoutStatusDetalhePacoteBinding
import com.leojoestrela.packagelist.model.StatusPacote


class StatusDetalhePacoteAdapter(
    private val listaStatusDetalhe: ArrayList<StatusPacote>
) :
    RecyclerView.Adapter<StatusDetalhePacoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = LayoutStatusDetalhePacoteBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listaStatusDetalhe[position])
    }

    override fun getItemCount(): Int {
        return listaStatusDetalhe.size
    }

    class ViewHolder(private val binding: LayoutStatusDetalhePacoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(status: StatusPacote) {
            binding.statusDetalheTextviewData.text = status.dataDiaStatus
            binding.statusDetalheTextviewDescricao.text = status.descricaoStatus
        }
    }
}