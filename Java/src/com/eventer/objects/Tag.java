package com.eventer.objects;

import java.util.ArrayList;
import java.util.List;

public class Tag {

	private String name;
	private static List<String> allTags;
	private List<String> taggedEvents = new ArrayList<String>();
	private List<String> taggedOrganisations = new ArrayList<String>();

	public static List<String> getAllTags() {
		return allTags;
	}

	public static void setAllTags(List<String> allTags) {
		Tag.allTags = allTags;
	}

	public static void addTag(String tag) {
		allTags.add(tag);
	}

	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTaggedEvents() {
		return taggedEvents;
	}

	public void setTaggedEvents(List<String> taggedEvents) {
		this.taggedEvents = taggedEvents;
	}

	public List<String> getTaggedOrganisations() {
		return taggedOrganisations;
	}

	public void setTaggedOrganisations(List<String> taggedOrganisations) {
		this.taggedOrganisations = taggedOrganisations;
	}

	public void addTaggedEvent(String event) {
		taggedEvents.add(event);
	}

	public void addTaggedOrganisation(String organisation) {
		taggedOrganisations.add(organisation);
	}

}
