package dev.nakayiza.nakayizasposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.nakayiza.nakayizasposts.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class comment : AppCompatActivity() {
    var postId= 0
    lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchposts()
        fetchcomments()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }

    fun fetchposts(){
        var APIClient=APIClient.buildApiClient(APIInterface::class.java)
        var request = APIClient.getPostById(postId)

        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    val post=response.body()
//                    Toast.makeText(applicationContext,"fetched ${post} post",
//                        Toast.LENGTH_LONG).show()
                    if (post != null) {
                        binding.tvname.text =post.title
                        binding.tvboddy.text=post.body
                    }

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })

        }


    fun fetchcomments(){
        var APIClient=APIClient.buildApiClient(APIInterface::class.java)
        var request = APIClient.getPostById(postId)

        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    val post=response.body()
//                    Toast.makeText(applicationContext,"fetched ${post} post",
//                        Toast.LENGTH_LONG).show()
                    if (post != null) {
                        binding.tvname.text =post.title
                        binding.tvboddy.text=post.body
                    }

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })

    }
    }
