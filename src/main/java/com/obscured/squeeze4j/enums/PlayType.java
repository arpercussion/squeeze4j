package com.obscured.squeeze4j.enums;

import com.obscured.squeeze4j.converters.Utilities;
import org.apache.commons.lang3.StringUtils;

public enum PlayType {
    UNKNOWN,
    PLAYLIST,
    GENRE,
    ARTIST,
    ALBUM,
    TRACK,
    ALBUM_BY_ARTIST,
    TRACK_BY_ARTIST,
    TRACK_BY_ALBUM,
    TRACK_BY_ARTIST_BY_ALBUM;

    public static PlayType fromLabel(String label) {
        PlayType playType = PlayType.UNKNOWN;
        if (Utilities.isNotNullOrEmpty(label)) {
            for (PlayType type : PlayType.values()) {
                if (StringUtils.equalsIgnoreCase(type.name(), label)) {
                    playType = type;
                    break;
                }
            }
        }
        return playType;
    }
}
