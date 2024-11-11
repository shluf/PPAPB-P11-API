package com.example.ppapb_p11_api.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppapb_p11_api.ActivityDetail
import com.example.ppapb_p11_api.R
import com.example.ppapb_p11_api.model.Data

class EmployeeAdapter(private val context: Context, private val employees: List<Data>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

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
            val intent = Intent(context, ActivityDetail::class.java)
            intent.putExtra("employee_data", employee)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = employees.size

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        val tvFullname: TextView = itemView.findViewById(R.id.tvFullname)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvId: TextView = itemView.findViewById(R.id.tvId)
    }
}
