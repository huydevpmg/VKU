package com.dacs.vku.presentation.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dacs.vku.domain.usecases.notification.NotiUseCases
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notiUseCases: NotiUseCases
):ViewModel(){
    val noti = notiUseCases.getNoti().cachedIn(viewModelScope)
}