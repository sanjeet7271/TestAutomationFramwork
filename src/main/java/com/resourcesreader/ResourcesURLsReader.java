package com.resourcesreader;

import com.configuration.ConfigurationReader;

public class ResourcesURLsReader extends ConfigurationReader {

	private String getStoreBaseURI;
	private String getJokesBaseURI;
	private String getJokesResourceURI;

	public ResourcesURLsReader() {
		setConfig();
	}

	public void setConfig() {
		this.getStoreBaseURI = prop.getProperty("STORE_URL");
		this.getJokesBaseURI = prop.getProperty("JOKES_URL");
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

}
