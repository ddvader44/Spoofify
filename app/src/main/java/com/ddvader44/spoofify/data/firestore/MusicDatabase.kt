package com.ddvader44.spoofify.data.firestore

import com.ddvader44.spoofify.data.entities.Song
import com.ddvader44.spoofify.others.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs() : List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e : Exception){
            emptyList()
        }
    }
}