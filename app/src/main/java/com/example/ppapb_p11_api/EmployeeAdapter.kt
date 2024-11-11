package com.example.ppapb_p11_api.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppapb_p11_api.DetailFragment
import com.example.ppapb_p11_api.R
import com.example.ppapb_p11_api.model.Data
import com.example.ppapb_p11_api.HomeFragment

class EmployeeAdapter(
    private val context: Context,
    private val employees: MutableList<Data>,
    private val fragment: HomeFragment
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee_card, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.tvFullname.text = "${employee.employeeName} ${employee.employeeAge}"
        holder.tvEmail.text = employee.employeeSalary
        holder.tvId.text = employee.id.toString()
        Glide.with(context).load(employee.profileImage).into(holder.ivAvatar)

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelable("employee_data", employee)
            }
            fragment.view?.findNavController()?.navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount(): Int = employees.size

    fun updateData(newData: List<Data>) {
        employees.clear()
        employees.addAll(newData)
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        val tvFullname: TextView = itemView.findViewById(R.id.tvFullname)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvId: TextView = itemView.findViewById(R.id.tvId)
    }
}
