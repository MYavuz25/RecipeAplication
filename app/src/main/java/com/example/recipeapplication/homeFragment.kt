package com.example.recipeapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class homeFragment : Fragment() ,recyclerAdapter.Listener {
    private val Base_Url="https://raw.githubusercontent.com/"
    private var recipeModels:ArrayList<Recipe_model>?=null
    private var job: Job?=null
    private var recyclerAdapter:recyclerAdapter?=null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager:RecyclerView.LayoutManager=GridLayoutManager(context,2)
        binding.recyclerView.layoutManager=layoutManager
        loadData()



    }
    fun loadData(){
        val retrofit= Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)

        job= CoroutineScope(Dispatchers.IO).launch {
            val response=retrofit.getData()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        recipeModels= ArrayList(it)
                        recipeModels?.let {
                            recyclerAdapter= recyclerAdapter(it,this@homeFragment)
                            binding.recyclerView.adapter=recyclerAdapter
                        }

                    }
                }
            }
        }

    }

    override fun onRecipeclick(recipeModel: Recipe_model) {
        Toast.makeText(context,recipeModel.Name,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}