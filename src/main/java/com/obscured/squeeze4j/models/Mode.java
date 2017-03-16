package com.obscured.squeeze4j.models;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum Mode {
	STOP("Stop", "Stopped", "Stopping"),
	PLAY("Play", "Played", "Playing"),
	PAUSE("Pause", "Paused", "Pausing"),
	RESUME("Resume", "Resumed", "Resuming"),
	MUTE("Mute", "Muted", "Muting"),
	UNMUTE("Un-mute", "Un-muted", "Un-muting");

	private final String label;
	private final String pastTense;
	private final String futureTense;

	Mode(String label, String pastTense, String futureTense) {
		this.label = label;
		this.pastTense = pastTense;
		this.futureTense = futureTense;
	}

	public String label() { return label; }

	public String pastTense() { return pastTense; }

	public String futureTense() { return futureTense; }

	public static List<String> availableModes() {
		List<String> modes = new ArrayList<>();
		for (Mode m : Mode.values()) {
			modes.add(m.label);
		}
		return modes;
	}

	public static Mode fromLabel(String label) {
		Mode mode = null;
		if (StringUtils.isNotEmpty(label)) {
			for (Mode m : Mode.values()) {
				if (m.label.equalsIgnoreCase(label)) {
					mode = m;
					break;
				}
			}
		}
		return mode;
	}
}
