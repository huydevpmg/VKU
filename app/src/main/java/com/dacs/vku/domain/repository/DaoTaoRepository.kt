package com.dacs.vku.domain.repository

import androidx.paging.PagingData
import com.dacs.vku.domain.model.NotiItem
import kotlinx.coroutines.flow.Flow


interface DaoTaoRepository {
    fun getNoti(): Flow<PagingData<NotiItem>>
}
