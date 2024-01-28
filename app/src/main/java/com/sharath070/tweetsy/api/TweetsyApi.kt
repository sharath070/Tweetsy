package com.sharath070.tweetsy.api

import com.sharath070.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("/v3/b/65b5fca91f5677401f274164?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<Array<TweetListItem>>

    @GET("/v3/b/65b5fca91f5677401f274164?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>

}