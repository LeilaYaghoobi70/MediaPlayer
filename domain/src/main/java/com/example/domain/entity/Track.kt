package com.example.domain.entity

class Track(
    private  var id: String,
    private  var displayName: String,
    private  var artistId: String,
    private  var albumId: String,
    private var trackLength: Long = 0
)