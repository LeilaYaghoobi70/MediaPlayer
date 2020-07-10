package com.example.mediaplayer.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Track
import com.example.domain.repository.TrackRepository
import com.example.domain.trackListSort.TracksSort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TracksViewModel @Inject constructor(
    private val trackRepository: TrackRepository
) : ViewModel() {

    val tracksList = ArrayList<Track>()

    private val _tracksListLiveData = MutableLiveData<List<Track>>()
    val tracksListLiveData: LiveData<List<Track>> = _tracksListLiveData

    fun getTrackList() {
        viewModelScope.launch {
            val trackList = trackRepository.getTrackList(TracksSort.ASCENDING)
            _tracksListLiveData.value = trackList
        }
    }

}