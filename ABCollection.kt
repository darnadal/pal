package com.example.pal

data class ABCollection(
    val abcCollection: Map<String, ABCItem>
)

data class ABCItem(
    val abcKey: String,
    val abcParentKey: String,
    val abcName: String,
    val abcData: ABCData,
    val abcHasChildren: Boolean
)

data class ABCData(
    val type: String,
    val title: String,
    val images: List<Image>?,
    val videos: String?,
)

data class Image(
    val url: String,
    val thumb: String
)
{
}