package com.jdc.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jdc.recycler.databinding.UserItemBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserVH>() {

    class UserVH(val binding: UserItemBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserVH(
        UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return UserModel.users.size
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = UserModel.users[position]
        holder.binding.setVariable(BR.user, user)
    }
}