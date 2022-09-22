package com.storeresponsedtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "store" })
public class Data {

	@JsonProperty("store")
	private Store store;

	@JsonProperty("store")
	public Store getStore() {
		return store;
	}

	@JsonProperty("store")
	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "Data [store=" + store + "]";
	}
}