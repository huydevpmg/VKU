package com.dacs.vku.data.remote

import com.dacs.vku.data.remote.dto.SchoolResponse
import com.dacs.vku.domain.model.SchoolResponseItem
import com.dacs.vku.presentation.onboarding.Page
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolAPI {
    @GET("notifications")
   suspend fun getNotifications(): Call<List<SchoolResponseItem>>
}