package dev.nakayiza.nakayizasposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.nakayiza.nakayizasposts.databinding.CardPostsBinding

class PostsRvAdapter(var posts: List<Post>):RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var binding = CardPostsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
//        var  = posts.get(position) with (holder.binding){
        var currentPost = posts.get(position)
        with (holder.binding){
            tvtittle.text = currentPost.title
            tvbody.text = currentPost.body


        }
    }
    override fun getItemCount(): Int {
        return posts.size
    }

}

class  PostsViewHolder(val binding: CardPostsBinding): RecyclerView.ViewHolder(binding.root)
