package com.eventer.objects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

	private String name, organisation, description;
	private List<String> tags = new ArrayList<String>();
	private Date begining, end;
	private Image banner;

	public Event(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Date getBegining() {
		return begining;
	}

	public void setBegining(Date begining) {
		this.begining = begining;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Image getBanner() {
		return banner;
	}

	public void setBanner(Image banner) {
		this.banner = banner;
	}
	
	public void addTag(String tag)
	{
		tags.add(tag);
	}

}
