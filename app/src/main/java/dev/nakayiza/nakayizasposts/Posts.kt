package dev.nakayiza.nakayizasposts

import retrofit2.http.Body
import retrofit2.http.POST

data class Post(
    var userId: Int,
    var id:Int,
    var title:String,
    var body: String)

class comments(
    var postid:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body: String)

fun <T> compareIds(item1:T,item2:T):T{
    var output=(item1.toString()+item2.toString())
    println(output)
    return  item1
}
