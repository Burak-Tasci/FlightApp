package com.tsci.flightapp.data.network.dto

data class Pagination(
    val count: Int?,
    val limit: Int?,
    val offset: Int?,
    val total: Int?
)