package com.example.domain.entity

data class Track(
    var id: String,
    var displayName: String,
    var artistId: String,
    var albumId: String,
    var trackLength: Long = 0
)