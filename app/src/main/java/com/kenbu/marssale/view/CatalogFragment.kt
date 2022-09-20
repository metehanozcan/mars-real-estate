package com.kenbu.marssale.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import com.kenbu.marssale.adapter.RealEstateAdapter
import com.kenbu.marssale.databinding.FragmentCatalogBinding
import com.kenbu.marssale.model.RealEstateModel
import com.kenbu.marssale.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

class CatalogFragment : Fragment() {
    private lateinit var binding: FragmentCatalogBinding
    private var bundle = Bundle()
    private lateinit var realEstateList: ArrayList<RealEstateModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(layoutInflater)
        setAdapter()
        return binding.root
    }
    /**
     * Checks If the Api Called Before
     * If There Is No Previous Data in bundle, makes an api call via apiCall for retrieving data then Sets adapter in layout
     * If there is data in bundle gets data from bundle, then sets adapter in layout
     *
     */
    private fun setAdapter() {
        if (bundle.get("response") == null) {
            apiCall()
        } else {
            realEstateList =
                bundle.getParcelableArrayList<RealEstateModel>("response") as ArrayList<RealEstateModel>
            val estateAdapter = RealEstateAdapter(realEstateList)
            binding.setVariable(BR.adapter, estateAdapter)
        }
    }
    /**
     * Api call for RealEstateModel
     * Sets Adapter in Catalog Layout
     * Puts Response in Bundle for Using Api only Once
     * If there is no Internet connection -> Sets Error Message
     */
    private fun apiCall() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val realEstateList: List<RealEstateModel> =
                    MarsApi.retrofitService.getProperties().await()
                val estateAdapter = RealEstateAdapter(realEstateList as ArrayList<RealEstateModel>)
                bundle.putParcelableArrayList("response", ArrayList(realEstateList))
                binding.apply {
                    setVariable(BR.adapter, estateAdapter)
                }
            } catch (e: Exception) {
                binding.catalogScreenTitle.text = "No-Internet"
            }
        }
    }
}







