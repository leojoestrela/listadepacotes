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

        val (statusDetalhePacoteFragment, dadosDetalhePacoteFragment) = setupFragments()

        val viewPagerAdapter =
            setupViewPagerAdapter(statusDetalhePacoteFragment, dadosDetalhePacoteFragment)

        setupTabLayout(viewPagerAdapter)
    }

    private fun setupTabLayout(viewPagerAdapter: DetalhePacoteViewPagerAdapter) {
        TabLayoutMediator(
            binding.detalhesPacoteTablayout,
            binding.detalhesPacoteViewpager
        ) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
            binding.detalhesPacoteViewpager.setCurrentItem(tab.position, true)
        }.attach()
    }

    private fun setupViewPagerAdapter(
        statusDetalhePacoteFragment: StatusDetalhePacoteFragment,
        dadosDetalhePacoteFragment: DadosDetalhePacoteFragment
    ): DetalhePacoteViewPagerAdapter {
        val viewPagerAdapter = DetalhePacoteViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(statusDetalhePacoteFragment, "Status")
        viewPagerAdapter.addFragment(dadosDetalhePacoteFragment, "Dados")

        binding.detalhesPacoteViewpager.adapter = viewPagerAdapter
        return viewPagerAdapter
    }

    private fun setupFragments(): Pair<StatusDetalhePacoteFragment, DadosDetalhePacoteFragment> {
        val statusDetalhePacoteFragment = StatusDetalhePacoteFragment()
        val dadosDetalhePacoteFragment = DadosDetalhePacoteFragment()

        val pacoteBundle = Bundle()
        pacoteBundle.putParcelable("pacote", pacote)

        val statusPacoteBundle = Bundle()
        statusPacoteBundle.putParcelableArrayList("status_pacote", pacote.statusPacote)

        statusDetalhePacoteFragment.arguments = statusPacoteBundle
        dadosDetalhePacoteFragment.arguments = pacoteBundle
        return Pair(statusDetalhePacoteFragment, dadosDetalhePacoteFragment)
    }

}

