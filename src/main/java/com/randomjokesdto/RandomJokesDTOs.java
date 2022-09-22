package com.randomjokesdto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "categories", "created_at", "icon_url", "id", "updated_at", "url", "value" })
public class RandomJokesDTOs {
	@JsonProperty("categories")
	private List<Object> categories = null;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("icon_url")
	private String iconUrl;
	@JsonProperty("id")
	private String id;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("url")
	private String url;
	@JsonProperty("value")
	private String value;

	@JsonProperty("categories")
	public List<Object> getCategories() {
		return categories;
	}

	@JsonProperty("categories")
	public void setCategories(List<Object> categories) {
		this.categories = categories;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("icon_url")
	public String getIconUrl() {
		return iconUrl;
	}

	@JsonProperty("icon_url")
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RandomJokesDTOs [categories=" + categories + ", createdAt=" + createdAt + ", iconUrl=" + iconUrl
				+ ", id=" + id + ", updatedAt=" + updatedAt + ", url=" + url + ", value=" + value + "]";
	}
}
