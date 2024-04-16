package com.dacs.vku.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dacs.vku.data.remote.SchoolAPI
import com.dacs.vku.domain.model.SchoolResponseItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val schoolAPI: SchoolAPI,
) : ViewModel() {

    private val _notifications = MutableLiveData<List<SchoolResponseItem>>()
    val notifications: LiveData<List<SchoolResponseItem>> = _notifications

    init {
        fetchNotifications()
    }

    private fun fetchNotifications() {
        viewModelScope.launch {
            try {
                val response = schoolAPI.getNotifications()
                if (response.isSuccessful && response.body() != null) {
                    _notifications.postValue(response.body())
                } else {
                    // Handle error case or empty response
                    _notifications.postValue(emptyList())
                }
            } catch (e: Exception) {
                // Handle error case such as network failure
                _notifications.postValue(emptyList())
            }
        }
    }
}