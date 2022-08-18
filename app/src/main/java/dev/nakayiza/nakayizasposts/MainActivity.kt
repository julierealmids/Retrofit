package dev.nakayiza.nakayizasposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import dev.nakayiza.nakayizasposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }
    fun getPosts(){
        var retrofit=APIClient.buildApiClient(APIInterface::class.java)
        val request=retrofit.getPosts()

        request.enqueue(object : Callback <List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts=response.body()
                    var adapter = posts?.let { PostsRvAdapter(it) }
                    adapter
                    Toast.makeText(applicationContext,"fetched ${posts!!.size} post",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })

    }
}