package com.example.mobiloitte_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobiloitte_project.adapter.ViewPagerAdapter
import com.example.mobiloitte_project.child_Fragment.FollowingFragment
import com.example.mobiloitte_project.child_Fragment.LocalFragment
import com.example.mobiloitte_project.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setupTabs()

        return view
    }

    private fun setupTabs(){
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.getFragment(LocalFragment(), "Local Acitivity")
        adapter.getFragment(FollowingFragment(), "Following Acitivity")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}