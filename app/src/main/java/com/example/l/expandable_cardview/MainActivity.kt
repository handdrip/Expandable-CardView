package com.example.l.expandable_cardview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.l.expandable_cardview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView = recycler_cardview
        val itemList = mutableListOf<ExpandableCardViewAdapter.Item>()
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "P-Lang"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Kotlin"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Go"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "C++"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Java"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Clojure"))

        val item = ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "Android")
        item.children = listOf(
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Jelly Bean"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "KitKat"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Lollipop"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Marshmallow"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Nougat"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Oreo"))
        itemList.add(item)

        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "NoteBook"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "MS Surface Pro 4"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Google Pixel Book"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Apple MacBook"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Samsung Series 9"))

        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "Smart Phone"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Apple iPhone X"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Google Pixel XL 2"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Samsung Galaxy Note 8"))
        itemList.add(ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "LG V30"))

        val nation = ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.PARENT, "Nation")
        nation.children = listOf(
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Republic Of Korea"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Canada"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "America"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Japan"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Denmark"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Britain"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "China"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Russia"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "France"),
                ExpandableCardViewAdapter.Item(ExpandableCardViewAdapter.CHILD, "Turkey"))
        itemList.add(nation)

        cardView.layoutManager = LinearLayoutManager(this)
        cardView.adapter = ExpandableCardViewAdapter(itemList)
    }
}
