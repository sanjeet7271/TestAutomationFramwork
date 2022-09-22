package com.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */

public class ConfigurationReader {
	public Properties prop;
	FileInputStream input = null;
	public static Logger logger = Logger.getLogger(ConfigurationReader.class);
	private static ConfigurationReader instance = null;

	public ConfigurationReader() {
		configurationReader();
	}

	public static ConfigurationReader getInstance() {
		if (null == instance) {
			instance = new ConfigurationReader();
		}
		return instance;
	}

	public void configurationReader() {
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
			prop = new Properties();
			prop.load(input);
			logger.info("Configuration file is successfully loaded.");
			input.close();
		} catch (IOException e) {
			logger.error("Properties file not found.", e);
			logger.error("Properties file not found.");
		}
	}
}
