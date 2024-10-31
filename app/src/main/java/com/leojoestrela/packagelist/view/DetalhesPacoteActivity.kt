package com.leojoestrela.packagelist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.leojoestrela.packagelist.databinding.ActivityDetalhesPacoteBinding
import com.leojoestrela.packagelist.model.Pacote
import com.leojoestrela.packagelist.view.adapters.DetalhePacoteViewPagerAdapter
import com.leojoestrela.packagelist.view.fragments.DadosDetalhePacoteFragment
import com.leojoestrela.packagelist.view.fragments.StatusDetalhePacoteFragment

class DetalhesPacoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesPacoteBinding
    private lateinit var pacote: Pacote

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesPacoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras != null) {
            pacote = intent.getParcelableExtra("pacote")!!
        }

        binding.detalhesPacoteToolbar.title = "Pacote ${pacote.codigo}"
        binding.detalhesPacoteToolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val viewPagerAdapter = DetalhePacoteViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(StatusDetalhePacoteFragment(), "Status")
        viewPagerAdapter.addFragment(DadosDetalhePacoteFragment(), "Dados")

        binding.detalhesPacoteViewpager.adapter = viewPagerAdapter

        TabLayoutMediator(
            binding.detalhesPacoteTablayout,
            binding.detalhesPacoteViewpager
        ) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
            binding.detalhesPacoteViewpager.setCurrentItem(tab.position, true)
        }.attach()

    }
}