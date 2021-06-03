package vinson.yuque.data

import retrofit2.http.GET
import vinson.yuque.bean.BaseResponse
import vinson.yuque.bean.UserInfo

interface YuQueService {

    @GET("/api/v2/user")
    suspend fun fetchUserInfo(): BaseResponse<UserInfo>
}