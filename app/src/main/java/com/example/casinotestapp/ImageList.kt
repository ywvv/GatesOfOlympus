package com.example.casinotestapp

class ImageList {
    private val imagesList = mutableListOf<Int>()

    fun fillImageList(multiplier: Int = 6): List<Int> {
        (1..multiplier).forEach { _ ->
            imagesList.addAll(
                listOf(
                    R.drawable.icon_1,
                    R.drawable.icon_2,
                    R.drawable.icon_3,
                    R.drawable.icon_4,
                    R.drawable.icon_5,
                    R.drawable.icon_6,
                    R.drawable.icon_7,
                    R.drawable.icon_8,
                    R.drawable.icon_9,
                    R.drawable.icon_10,
                )
            )
        }

        return imagesList.shuffled()
    }

    fun getLastIndex() = imagesList.lastIndex

    fun clearImageList() = imagesList.clear()
}