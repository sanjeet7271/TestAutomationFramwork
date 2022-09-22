package com.storeresponsedtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "alternativeLocales", "code", "defaultCurrency", "defaultLocale" })
public class Store {

	@JsonProperty("alternativeLocales")
	private List<String> alternativeLocales = null;
	@JsonProperty("code")
	private String code;
	@JsonProperty("defaultCurrency")
	private String defaultCurrency;
	@JsonProperty("defaultLocale")
	private String defaultLocale;

	@JsonProperty("alternativeLocales")
	public List<String> getAlternativeLocales() {
		return alternativeLocales;
	}

	@JsonProperty("alternativeLocales")
	public void setAlternativeLocales(List<String> alternativeLocales) {
		this.alternativeLocales = alternativeLocales;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("defaultCurrency")
	public String getDefaultCurrency() {
		return defaultCurrency;
	}

	@JsonProperty("defaultCurrency")
	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	@JsonProperty("defaultLocale")
	public String getDefaultLocale() {
		return defaultLocale;
	}

	@JsonProperty("defaultLocale")
	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Override
	public String toString() {
		return "Store [alternativeLocales=" + alternativeLocales + ", code=" + code + ", defaultCurrency="
				+ defaultCurrency + ", defaultLocale=" + defaultLocale + "]";
	}
}
