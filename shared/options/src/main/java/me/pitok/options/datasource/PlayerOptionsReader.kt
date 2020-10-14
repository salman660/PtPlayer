package me.pitok.options.datasource

import me.pitok.datasource.Readable
import me.pitok.options.Keys
import me.pitok.options.entity.PlayerOptionsEntity
import me.pitok.sharedpreferences.di.qulifiers.SettingsSP
import me.pitok.sharedpreferences.typealiases.SpReader
import javax.inject.Inject

class PlayerOptionsReader @Inject constructor(
    @SettingsSP private val settingsReader: SpReader
): PlayerOptionsReadType {
    override suspend fun read(): PlayerOptionsEntity {
        return PlayerOptionsEntity(
            settingsReader.read(Keys.PLAYER_DEFAULT_SPEED_KEY).toFloat(),
            settingsReader.read(Keys.PLAYER_DEFAULT_SPEAKER_VOLUME_KEY).toFloat(),
            (settingsReader.read(Keys.PLAYER_DEFAULT_LAYOUT_ORIENTATION_KEY) != "0")
            )
    }
}

typealias PlayerOptionsReadType = Readable.Suspendable<@JvmSuppressWildcards PlayerOptionsEntity>