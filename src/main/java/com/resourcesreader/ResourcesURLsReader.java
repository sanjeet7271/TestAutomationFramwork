package com.resourcesreader;

import com.configuration.ConfigurationReader;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
public class ResourcesURLsReader extends ConfigurationReader {

	private String getStoreBaseURI;
	private String getJokesBaseURI;
	private String getJokesResourceURI;
	private String getRandomJokesResourceURI;
	private static ResourcesURLsReader instance = null;

	public ResourcesURLsReader() {
		setConfig();
	}

	public static ResourcesURLsReader getInstance() {
		if (null == instance) {
			instance = new ResourcesURLsReader();
		}
		return instance;
	}

	public void setConfig() {
		this.getStoreBaseURI = prop.getProperty("STORE_URL");
		this.getJokesBaseURI = prop.getProperty("JOKES_URL");
		this.getRandomJokesResourceURI = prop.getProperty("RANDOMJOKESRESOURCEURI");
		this.getJokesResourceURI = prop.getProperty("JOKESRESOURCEURI");

	}

	public String getStoreBaseURI() {
		logger.info("Store base url is loading...");
		String getStoreBaseURI = this.getStoreBaseURI;
		return getStoreBaseURI;
	}

	public String getJokesBaseURI() {
		logger.info("Random Jokes base url is loading...");
		String getJokesBaseURI = this.getJokesBaseURI;
		return getJokesBaseURI;
	}

	public String getJokesResourceURI() {
		logger.info("Jokes endpoint url is loading...");
		String getJokesResourceURI = this.getJokesResourceURI;
		return getJokesResourceURI;
	}

	public String getRandomJokesResourceURI() {
		logger.info("Jokes endpoint url is loading...");
		String getRandomJokesResourceURI = this.getRandomJokesResourceURI;
		return getRandomJokesResourceURI;
	}
}
