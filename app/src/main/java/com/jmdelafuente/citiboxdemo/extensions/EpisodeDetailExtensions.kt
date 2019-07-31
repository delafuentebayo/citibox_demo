package com.jmdelafuente.citiboxdemo.extensions

import android.net.Uri
import com.jmdelafuente.citiboxdemo.models.ActivityModels
import com.jmdelafuente.citiboxdemo.enums.SeasonCodes
import com.jmdelafuente.citiboxdemo.models.NetworkClasses

fun NetworkClasses.Character.toEpisodeDetailActivityModel(): ActivityModels.EpisodeDetailActivityModel {
    return ActivityModels.EpisodeDetailActivityModel(this.name, this.species, this.status, this.image)
}

fun String.getCharacterId(): Int {
    return Uri.parse(this).lastPathSegment.toInt()
}
