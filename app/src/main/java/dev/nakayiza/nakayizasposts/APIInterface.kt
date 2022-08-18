package dev.nakayiza.nakayizasposts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIInterface {
    @GET("/posts")
    fun getPosts():Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id")postId:Int):Call<Post>

    @GET("/posts/{id}/comments")
    fun getPostById(@Path("id")commentId:String):Call<List<comments>>
}
