package com.jdc.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jdc.recycler.databinding.UserItemBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserVH>() {

    class UserVH(itemView:View): ViewHolder(itemView) {
        val binding:UserItemBinding = UserItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false).let {
            UserVH(it)
        }
    }

    override fun getItemCount(): Int {
        return UserModel.users.size
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = UserModel.users[position]
        holder.binding.setVariable(BR.user, user)
        holder.binding.executePendingBindings()
    }
}