package com.example.ppapb_p11_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ppapb_p11_api.databinding.FragmentDetailBinding
import com.example.ppapb_p11_api.model.Data

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val employee = arguments?.getParcelable<Data>("employee_data")

        employee?.let {
            with(binding) {
                tvFullname.text = "${it.employeeName} ${it.employeeAge}"
                tvEmail.text = it.employeeSalary
                tvId.text = it.id.toString()
                Glide.with(this@DetailFragment).load(it.profileImage).into(ivAvatar)
            }
        }

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
