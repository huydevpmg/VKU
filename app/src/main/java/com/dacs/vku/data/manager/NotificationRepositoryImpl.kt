package com.dacs.vku.data.manager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dacs.vku.data.remote.NotiApi
import com.dacs.vku.data.remote.a_daotao.NotificationDaoTaoPagingSource
import com.dacs.vku.domain.model.NotiItem
import com.dacs.vku.domain.repository.DaoTaoRepository
import kotlinx.coroutines.flow.Flow

class NotificationRepositoryImpl(private val notiApi: NotiApi): DaoTaoRepository {
    override fun getNoti(): Flow<PagingData<NotiItem>> {

        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { NotificationDaoTaoPagingSource(notiApi) }
        ).flow
    }

}