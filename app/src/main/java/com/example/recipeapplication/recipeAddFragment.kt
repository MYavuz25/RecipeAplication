package com.example.recipeapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeapplication.databinding.FragmentRecipeAddBinding
import com.example.recipeapplication.databinding.FragmentSearchBinding


class recipeAddFragment : Fragment() {
    private lateinit var binding:FragmentRecipeAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentRecipeAddBinding.inflate(inflater,container,false)
        return binding.root
    }


}