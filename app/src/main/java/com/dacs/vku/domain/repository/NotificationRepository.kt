package com.dacs.vku.domain.repository

import androidx.paging.PagingData
import com.dacs.vku.domain.model.SchoolResponseItem
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    fun getNotification(): Flow<PagingData<SchoolResponseItem>>
}