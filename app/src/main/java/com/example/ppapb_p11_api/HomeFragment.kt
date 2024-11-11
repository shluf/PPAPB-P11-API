package com.example.ppapb_p11_api

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ppapb_p11_api.adapter.EmployeeAdapter
import com.example.ppapb_p11_api.databinding.FragmentHomeBinding
import com.example.ppapb_p11_api.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
        val adapter = EmployeeAdapter(requireContext(), mutableListOf(), this)
        binding.rvMovies.adapter = adapter

        viewModel.loadPage1()

        viewModel.data.observe(viewLifecycleOwner) { employees ->
            adapter.updateData(employees)
        }

        binding.btnSeeMore.setOnClickListener {
            viewModel.loadPage1And2()
            Toast.makeText(requireContext(), "Menampilkan seluruh halaman", Toast.LENGTH_SHORT).show()
        }

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}