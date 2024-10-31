package com.leojoestrela.packagelist.view.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leojoestrela.packagelist.databinding.LayoutPacoteBinding
import com.leojoestrela.packagelist.model.Pacote
import com.leojoestrela.packagelist.view.DetalhesPacoteActivity

class ListaPacotesAdapter(
    private val listaPacotes: ArrayList<Pacote>
) :
    RecyclerView.Adapter<ListaPacotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            LayoutPacoteBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listaPacotes[position])
    }

    override fun getItemCount(): Int {
        return listaPacotes.size
    }

    class ViewHolder(private val binding: LayoutPacoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pacote: Pacote) {
            binding.pacoteItemCodigoPacote.text = pacote.codigo

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetalhesPacoteActivity::class.java)
                intent.putExtra("pacote", pacote)
                binding.root.context.startActivity(intent)
            }
        }
    }

}