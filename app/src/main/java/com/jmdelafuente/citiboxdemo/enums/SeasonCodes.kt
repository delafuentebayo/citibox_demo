package com.jmdelafuente.citiboxdemo.enums

import android.content.Context
import com.jmdelafuente.citiboxdemo.R

enum class SeasonCodes (val code: String){
    SEASON_1("S01"),
    SEASON_2("S02"),
    SEASON_3("S03"),
    SEASON_4("S04");
    companion object {
        fun from(findValue: String): SeasonCodes = values().first { it.code  == findValue }
    }

    fun getVisualizationLabel(context: Context): String{
        return when(this){
            SEASON_1 -> context.getString(R.string.season_1)
            SEASON_2 -> context.getString(R.string.season_2)
            SEASON_3 -> context.getString(R.string.season_3)
            SEASON_4 -> context.getString(R.string.season_4)
        }
    }

}