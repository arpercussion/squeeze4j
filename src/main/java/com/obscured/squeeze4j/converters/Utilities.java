package com.obscured.squeeze4j.converters;

import org.apache.commons.lang3.StringUtils;

public class Utilities {

	public static Integer tryGetInteger(String input) {
		Integer result = null;
		if (StringUtils.isNotEmpty(input)) {
			try {
				result = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				// noop
			}
		}
		return result;
	}
}
