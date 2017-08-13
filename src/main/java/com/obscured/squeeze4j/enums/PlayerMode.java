package com.obscured.squeeze4j.enums;

import com.obscured.squeeze4j.converters.Utilities;

public enum PlayerMode {
    UNKNOWN(-1, ""),
    PAUSE(0, "Pause"),
    RESUME(1, "Resume"),
    STOP(2, "Stop"),
    PLAY(3, "Play"),
    MUTE(4, "Mute"),
    UNMUTE(5, "Unmute"),
    REPEAT(6, "Repeat"),
    REPEAT_ON(7, "Repeat ON"),
    REPEAT_OFF(8, "Repeat OFF"),
    CONTINUE(9, "Continue"),
    KEEP_GOING(10, "Keep going"),
    SHUFFLE(11, "Shuffle"),
    SHUFFLE_ON(12, "Shuffle ON"),
    SHUFFLE_OFF(13, "Shuffle OFF"),
    TURN_ON_SHUFFLE(14, "Turn ON shuffle"),
    TURN_OFF_SHUFFLE(15, "Turn OFF shuffle"),
    STOP_SHUFFLING(16, "Stop Shuffling"),
    SHUFFLE_THE_MUSIC(17, "Shuffle the music");

    private final int id;
    private final String label;

    PlayerMode(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int id() {
        return id;
    }

    public String label() {
        return label;
    }

    public static PlayerMode fromLabel(String label) {
        PlayerMode playerMode = PlayerMode.UNKNOWN;
        if (Utilities.isNotNullOrEmpty(label)) {
            for (PlayerMode mode : PlayerMode.values()) {
                if (mode.label.equalsIgnoreCase(label)) {
                    playerMode = mode;
                    break;
                }
            }
        }
        return playerMode;
    }

    public static PlayerMode fromId(Integer id) {
        PlayerMode playerDirection = null;
        if (id != null) {
            for (PlayerMode mode : PlayerMode.values()) {
                if (mode.id == id) {
                    playerDirection = mode;
                    break;
                }
            }
        }
        return playerDirection;
    }
}
