package com.silmiazdkiatulathqia.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.silmiazdkiatulathqia.footballclub.R.attr.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainUi = MainActivityUI()
        mainUi.setContentView(this)

        val items = initData()

        mainUi.recyclerView.adapter = RecyclerViewAdapter(items) {
            startActivity<DetailActivity>("item" to it)
        }
    }

    private fun initData(): List<Item> {
        val name = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.club_detail)
        val image = resources.obtainTypedArray(R.array.club_image)

        val result = name.mapIndexed { i, itemName ->
            Item(itemName, image.getResourceId(i, 0), detail[i])
        }

        image.recycle()
        return result
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        lateinit var recyclerView: RecyclerView
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                recyclerView = recyclerView {
                    layoutManager = LinearLayoutManager(ui.ctx)
                }.lparams {
                    width = matchParent
                    height = matchParent
                    layout_constraintBottom_toBottomOf
                    layout_constraintLeft_toLeftOf
                    layout_constraintRight_toRightOf
                    layout_constraintTop_toTopOf
                }

                recyclerView
            }
        }
    }
}
