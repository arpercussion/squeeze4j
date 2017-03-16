package com.obscured.squeeze4j;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Config {

	private static final String CONFIG_FILE = "config.properties";
	private static final Properties properties = new Properties();
	private static List<String> keys = Arrays.asList("lms.address", "lms.username", "lms.password");

	/**
	 * Load the properties first from file, then from environment
	 * NOTE: env trumps props
	 */
	private static void load() {
		InputStream input = null;
		try {
			input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			if (input != null) {
				// load a properties file from class path, inside static method
				properties.load(input);
			}

			// env wins over props
			Map<String, String> env = System.getenv();
			keys.forEach(key -> {
				if (env.containsKey(key)) {
					String value = properties.getProperty(key);
					properties.setProperty(key, env.getOrDefault(key, value));
				}
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Lookup config value by key
	 * @param key String the config key
	 * @return String the config value
	 */
	public static String get(String key) {
		if (properties.isEmpty()) {
			load();
		}
		return properties.getProperty(key, StringUtils.EMPTY);
	}
}
