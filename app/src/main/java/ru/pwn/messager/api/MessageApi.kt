package ru.pwn.messager.api

import android.os.Message
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import ru.pwn.messager.models.Chat

interface MessageApi {
    @POST("message/new")
    suspend fun addMessage(@Body message: Message): Message

    @DELETE("message/delete/{messageId}")
    suspend fun deleteMessage(@Path("messageId") messageId: Int): Int

    @PATCH("message/update/{messageId}")
    suspend fun updateMessage(@Path("messageId") messageId: Int, @Body message: Message): Message

    @GET("message/check/{userId}")
    suspend fun checkMessagesByUserId(@Path("userId") userId: Int): Boolean

}