package com.kenbu.marssale.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kenbu.marssale.R
import com.kenbu.marssale.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var fragmentWelcomeBinding:FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeBinding = FragmentWelcomeBinding.inflate(layoutInflater)
        return fragmentWelcomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Call For Navigation WelcomeFragment -> CatalogFragment
        goToCatalog()
    }
    /**
     * Start Button that Navigate from Welcome Fragment to Catalog Fragment
     *
     */
    private fun goToCatalog() {
        fragmentWelcomeBinding.apply {
            getStartedButton.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_catalogFragment)
            }
        }
    }
}

