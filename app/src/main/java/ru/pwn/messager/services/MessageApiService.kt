package ru.pwn.messager.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.pwn.messager.models.Message


interface MessageApiService {
    @GET("chats/{chat_id}")
    fun getAllMessagesByChatId(@Path("chat_id") chatId: Int): List<Message>

    @POST("chats/{chat_id}")
    fun sendMessage(@Path("chat_id") chatId: Int, @Body message: Message): Call<Message>
}