package com.altintas.myapplication.ui.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.altintas.myapplication.R
import com.altintas.myapplication.databinding.FragmentArtistBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArtistFragment : Fragment(R.layout.fragment_artist) {

    private lateinit var binding: FragmentArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArtistBinding.bind(view)
    }

}