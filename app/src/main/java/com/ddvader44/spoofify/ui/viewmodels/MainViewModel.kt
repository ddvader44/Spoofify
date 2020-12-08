package com.ddvader44.spoofify.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ddvader44.spoofify.data.entities.Song
import com.ddvader44.spoofify.exoplayer.MusicServiceConnection
import com.ddvader44.spoofify.others.Resource

class MainViewModel @ViewModelInject constructor(
    private val musicServiceConnection: MusicServiceConnection
) {
    private val _mediaItems = MutableLiveData<Resource<List<Song>>>()
    val mediaItems : LiveData<Resource<List<Song>>> = _mediaItems

    val isConnected = musicServiceConnection.isConnected
    val networkError = musicServiceConnection.networkError
    val curPlayingSong = musicServiceConnection.curPlayingSong
    val playbackState = musicServiceConnection.playbackState

}