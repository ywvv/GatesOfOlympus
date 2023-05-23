package com.example.casinotestapp

import android.content.Context
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.example.casinotestapp.databinding.ActivityGameBinding

class Holders(
    private val context: Context,
    binding: ActivityGameBinding
) {
    private val holders = listOf(
        binding.holder1,
        binding.holder2,
        binding.holder3,
        binding.holder4
    )

    fun setupHolders(imageList: ImageList) {
        holders.forEach { holder ->
            holder.layoutManager = VariableScrollSpeedLinearLayoutManager(context, 2)
            holder.adapter = ViewAdapter(imageList.fillImageList())
            offTouchListeners(holder)
        }
    }

    fun scrollHolders(imageList: ImageList, lines: Lines, buttons: Buttons) {
        holders.forEachIndexed { index, holder ->
            holder.adapter = ViewAdapter(imageList.fillImageList())
            holder.smoothScrollToPosition(imageList.getLastIndex())

            holder.addOnScrollListener(object :
                RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(
                    recyclerView: RecyclerView,
                    newState: Int
                ) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (newState == RecyclerView.SCROLL_STATE_IDLE && index == holders.lastIndex) {
                        Animator().animateButtonsOnSpinEnd(buttons.getButtons())
                        lines.showLines()
                        buttons.enableButtons()
                    }
                }
            })
        }
    }

    private fun offTouchListeners(item: RecyclerView) {
        item.addOnItemTouchListener(object : RecyclerView.SimpleOnItemTouchListener() {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                return true
            }
        })
    }
}