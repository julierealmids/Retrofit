package dev.nakayiza.nakayizasposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter (var post:List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.card_posts,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(post[position])
    }

    override fun getItemCount(): Int {
        return post.size
    }
}

class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    private var tvtittle:TextView=itemView.findViewById(R.id.tvtittle)
    private var tvbody:TextView=itemView.findViewById(R.id.tvbody)

    fun bindView(post: Post){
        tvtittle.text=post.title
        tvbody.text=post.body



    }
}