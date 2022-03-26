package com.example.mobiloitte_project.child_Fragment

import android.content.Context
import android.graphics.ColorSpace
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiloitte_project.R
import com.example.mobiloitte_project.adapter.LocalRecyclerAdapter
import com.example.mobiloitte_project.databinding.FragmentHomeBinding
import com.example.mobiloitte_project.model.ModelClass

class LocalFragment : Fragment() {

    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: LocalRecyclerAdapter

    val itemList =  arrayListOf<ModelClass>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        // adding recyclerView by id
        recyclerView = view.findViewById(R.id.recyclerView)


//        added static data
        val data1 = ModelClass("Vishal")
        val data2 = ModelClass("Rajdeep")
        val data3 = ModelClass("Anuraag")
        val data4 = ModelClass("Dubey")
        val data5 = ModelClass("Arun")
        val data6 = ModelClass("Masoom")
        val data7 = ModelClass("Mohit")

        itemList.add(data1)
        itemList.add(data2)
        itemList.add(data3)
        itemList.add(data4)
        itemList.add(data5)
        itemList.add(data6)
        itemList.add(data7)


        // recycler view added
        layoutManager = GridLayoutManager(activity,2)
        recyclerAdapter = LocalRecyclerAdapter(activity as Context, itemList)
        recyclerView.layoutManager = layoutManager

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = recyclerAdapter

    }
}