package vinson.yuque.bean

data class BaseResponse<out T>(
    val data: T
)