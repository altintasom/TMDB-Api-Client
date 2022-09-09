package com.altintas.myapplication.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.altintas.myapplication.R
import com.altintas.myapplication.databinding.FragmentTvShowBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TvShowFragment : Fragment(R.layout.fragment_tv_show) {
    private lateinit var binding: FragmentTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowBinding.bind(view)
    }
}