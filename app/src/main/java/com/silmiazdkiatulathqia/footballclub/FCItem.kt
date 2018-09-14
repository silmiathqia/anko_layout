package com.silmiazdkiatulathqia.footballclub

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.imageView
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.margin
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class FCItem : AnkoComponent<ViewGroup> {
    lateinit var imageView: ImageView
    lateinit var textView: TextView

    @SuppressLint("SetTextI18n")
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL

            imageView = imageView {
                imageResource = R.drawable.img_barca
            }.lparams {
                width = dip(50)
                height = dip(50)
            }

            imageView

            textView = textView {
                text = "Barcelona FC"
            }.lparams {
                width = wrapContent
                height = wrapContent
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }

            textView
        }
    }
}