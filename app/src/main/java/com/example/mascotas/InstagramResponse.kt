package com.example.mascotas

data class InstagramResponse(
    val data: List<MediaItem>
)

data class MediaItem(
    val id: String,
    val images: MediaImages
)

data class MediaImages(
    val thumbnail: MediaImage
)

data class MediaImage(
    val url: String
)
