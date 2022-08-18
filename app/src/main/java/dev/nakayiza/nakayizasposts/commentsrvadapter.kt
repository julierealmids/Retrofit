package dev.nakayiza.nakayizasposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.nakayiza.nakayizasposts.databinding.ActivityCommentBinding

class commentsrvadapter(var comments:List<comments>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding=ActivityCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComments=comments.get(position)
        with(holder.binding){
            tvname.text=currentComments.name
            tvboddy.text=currentComments.body
        }
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}



class CommentsViewHolder(var binding: ActivityCommentBinding):RecyclerView.ViewHolder(binding.root)