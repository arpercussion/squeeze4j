package com.obscured.squeeze4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Config {

	private static final Logger logger = LogManager.getLogger(Config.class);

	private static boolean isLoaded = false;
	private static final String CONFIG_FILE = "squeeze4j.properties";
	private static final Properties properties = new Properties();

	/**
	 * Should not set values here, mainly used to get properties we care about.
	 * NOTE:  Do not use ., -, #XXX in property names
	 */
	private static void loadFromFile() {
		InputStream input = null;
		try {
			input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			if (input != null) {
				// load a properties file from class path, inside static method
				properties.load(input);
			}
			isLoaded = true;
		} catch (IOException e) {
			logger.error(e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 * System.getProperty comes from jvm passed in via -Dprop=value
	 * NOTE: Can be set using: -Dsys.prop=value OR -Dprop=value
	 */
	private static void loadFromProperties() {
		if (isLoaded) {
			Set<String> keys = properties.stringPropertyNames();
			keys.forEach(key -> {
				String value = System.getProperty(key, properties.getProperty(key));
				properties.setProperty(key, value);
			});
		}
	}

	/**
	 * System.getenv comes from environment (ie. export prop=value)
	 * NOTE: Property name should be valid according to OS specs, for example:
	 * Do not use ., -, #XXX in property names
	 */
	private static void loadFromEnvironment() {
		if (isLoaded) {
			Set<String> keys = properties.stringPropertyNames();
			Map<String, String> env = System.getenv();
			keys.forEach(key -> {
				String value = env.getOrDefault(key, properties.getProperty(key));
				properties.setProperty(key, value);
			});
		}
	}

	/**
	 * Load the properties first from file, then from environment
	 * NOTE: env trumps props
	 */
	private static void init() {
		loadFromFile();
		loadFromProperties();
		loadFromEnvironment();
	}

	/**
	 * Lookup config value by key
	 *
	 * @param key String the config key
	 * @return String the config value
	 */
	public static String get(String key) {
		if (properties.isEmpty() || !isLoaded) {
			init();
		}
		return properties.getProperty(key, StringUtils.EMPTY);
	}
}
