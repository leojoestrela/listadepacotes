package com.leojoestrela.packagelist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.leojoestrela.packagelist.R
import com.leojoestrela.packagelist.databinding.ActivityMainBinding
import com.leojoestrela.packagelist.view.fragments.InicioFragment
import com.leojoestrela.packagelist.view.fragments.OpcoesFragment
import com.leojoestrela.packagelist.view.fragments.TutoriaisFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val inicioFragment = InicioFragment()
        val opcoesFragment = OpcoesFragment()
        val tutoriaisFragment = TutoriaisFragment()

        setCurrentFragment(inicioFragment)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_inicio -> {
                    setCurrentFragment(inicioFragment)
                    true
                }

                R.id.item_opcoes -> {
                    setCurrentFragment(opcoesFragment)
                    true
                }

                R.id.item_tutorial -> {
                    setCurrentFragment(tutoriaisFragment)
                    true
                }

                else -> false
            }

        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}