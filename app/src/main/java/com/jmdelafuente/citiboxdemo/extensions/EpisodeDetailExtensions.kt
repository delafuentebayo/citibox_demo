package com.jmdelafuente.citiboxdemo.extensions

import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

fun NetworkClasses.Episode.toMainActivityModel(): ActivityModels.MainActivityModel {
    return ActivityModels.MainActivityModel(this.id.toString(), this.name, this.characters)
}

fun NetworkClasses.Episode.getSeason(): SeasonCodes {
    val getSeasonCode: String = this.episode.substring(0,3)
    return SeasonCodes.from(getSeasonCode)
}