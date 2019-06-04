package com.example.apple.coursepal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class HeroAdapter(val mCtx:Context,val layouResId: Int,val heroList: List<Hero>)
    :ArrayAdapter<Hero>(mCtx,layouResId,heroList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater= LayoutInflater.from(mCtx)
        val view:View= layoutInflater.inflate(layouResId,null)
        val textviewName = view.findViewById<TextView>(R.id.textViewName)
        val hero = heroList[position]
        textviewName.text=hero.name
        return view;
    }
}