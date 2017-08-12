package com.obscured.squeeze4j.enums;

import com.obscured.squeeze4j.converters.Utilities;

public enum PlayerDirection {
    UNKNOWN(-1, ""),
    NEXT(0, "Next"),
    PREVIOUS(1, "Previous"),
    SKIP(2, "Skip"),
    RESTART(3, "Re-Start"),
    START_OVER(4, "Start over"),
    START_AGAIN(5, "Start again");

    private final int id;
    private final String label;

    PlayerDirection(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int id() {
        return id;
    }

    public String label() {
        return label;
    }

    public static PlayerDirection fromId(Integer id) {
        PlayerDirection playerDirection = null;
        if (Utilities.isNotNull(id)) {
            for (PlayerDirection direction : PlayerDirection.values()) {
                if (direction.id == id) {
                    playerDirection = direction;
                    break;
                }
            }
        }
        return playerDirection;
    }

    public static PlayerDirection fromLabel(String label) {
        PlayerDirection playerDirection = PlayerDirection.UNKNOWN;
        if (Utilities.isNotNullOrEmpty(label)) {
            for (PlayerDirection direction : PlayerDirection.values()) {
                if (direction.label.equalsIgnoreCase(label)) {
                    playerDirection = direction;
                    break;
                }
            }
        }
        return playerDirection;
    }
}
