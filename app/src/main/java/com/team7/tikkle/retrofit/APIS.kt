package com.team7.tikkle.retrofit

import com.team7.tikkle.data.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIS {

    //카카오 로그인
    @POST("/login/oauth/kakao")
    @FormUrlEncoded
    fun signUp(
        @Field("accessToken") accessToken: String
    ) : Call<LoginResponse>

    //추가정보 입력
    data class RequestBody(val nickname: String, val isChecked: Boolean)
    @POST("/login/extraInfo/{id}")
    fun updateData(@Path("id") id: Int, @Body requestBody: RequestBody): Call<ExtraInfoResponse>

    //사용자 mbti 유형 등록
    @POST("accounts/mbti/{type}")
    fun postMbtiResult(
        @Header("X-ACCESS-TOKEN") accessToken: String,
        @Path("type") type: String
    ): Call<ResponseMbti>

    //닉네임 중복 확인
    @GET("/login/{nickname}/exists")
    suspend fun nameCheck(@Path(value = "nickname") nickname: String) : Response<ResponseNamecheck>

    //유형별 챌린지 추천
    @GET("/challenge/recommendation/test")
    suspend fun getRecommendation(
    ) : Call<RecommendationResponse>




}