package com.kenbu.marssale.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.kenbu.marssale.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        bindingInit()
    }

    /**
     * Setting bindings behavior
     *
     */
    private fun bindingInit() {
        binding.apply {
            if (estateList?.type == "buy") {
                itemStatusView.text = "For Sale"
            } else {
                itemStatusView.text = "For Rent"}

            buyButton.setOnClickListener() {
                Snackbar.make(
                    it,
                    "You are now martian my friend",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            backButton.setOnClickListener() {
                findNavController().popBackStack()
            }
        }
    }

    /**
     * Pass Nav Arguments view data from Catalog fragment to --> this Fragment
     *
     */
    private fun getData() {
        binding.estateList = args.estateList

    }
}
