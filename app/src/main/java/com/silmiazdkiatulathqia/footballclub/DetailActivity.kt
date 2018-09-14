package com.silmiazdkiatulathqia.footballclub

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.imageView
import org.jetbrains.anko.margin
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.extras.getParcelable<Item>("item")
        val detailUi = DetailActivityUI()
        detailUi.setContentView(this)
        detailUi.textView.text = item.detail
        Glide.with(this).load(item.image).into(detailUi.imageView)
    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {

        lateinit var imageView: ImageView
        lateinit var textView: TextView

        @SuppressLint("SetTextI18n")
        override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
            verticalLayout {
                imageView = imageView {
                    imageResource = R.drawable.img_barca
                }.lparams {
                    width = wrapContent
                    height = dip(80)
                    gravity = Gravity.CENTER
                }

                imageView

                textView = textView {
                    text = "Barcelona FC"
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

                textView
            }
        }
    }
}