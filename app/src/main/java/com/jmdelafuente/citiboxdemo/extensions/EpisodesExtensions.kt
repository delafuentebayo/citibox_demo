package com.jmdelafuente.citiboxdemo.extensions

import com.jmdelafuente.citiboxdemo.activities.MainActivity.MainActivityModel
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

fun NetworkClasses.Episode.toMainActivityModel(): MainActivityModel {
    return MainActivityModel(this.id.toString(), this.name)
}

fun NetworkClasses.Episode.getSeason(): SeasonCodes {
    val getSeasonCode: String = this.episode.substring(0,3)
    return SeasonCodes.from(getSeasonCode)
}