package com.dacs.vku.domain.usecases.app_entry

import com.dacs.vku.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
       return localUserManager.readAppEntry()
    }
}