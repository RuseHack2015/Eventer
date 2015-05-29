package com.eventer.objects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private String name, password, email, gender;
	private Map<String, Integer> visitedTags = new HashMap<String, Integer>();
	private Map<String, Integer> visitedOrganisations = new HashMap<String, Integer>();
	private List<String> followedTags = new ArrayList<String>();
	private List<String> visitedEvents = new ArrayList<String>();
	private Image avatar;
	private Date birthday;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Map<String, Integer> getVisitedTags() {
		return visitedTags;
	}

	public void setVisitedTags(Map<String, Integer> visitedTags) {
		this.visitedTags = visitedTags;
	}

	public Map<String, Integer> getVisitedOrganisations() {
		return visitedOrganisations;
	}

	public void setVisitedOrganisations(
			Map<String, Integer> visitedOrganisations) {
		this.visitedOrganisations = visitedOrganisations;
	}

	public List<String> getFollowedTags() {
		return followedTags;
	}

	public void setFollowedTags(List<String> followedTags) {
		this.followedTags = followedTags;
	}

	public List<String> getVisitedEvents() {
		return visitedEvents;
	}

	public void setVisitedEvents(List<String> visitedEvents) {
		this.visitedEvents = visitedEvents;
	}

	public Image getAvatar() {
		return avatar;
	}

	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}

	public String getUser() {
		return name;
	}

	public void setUser(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void visitEvent(String event)
	{
		visitedEvents.add(event);
	}

	public void visitTag(String tag) {
		if (visitedTags.containsKey(tag)) {
			int n = visitedTags.get(tag);
			visitedTags.put(tag, n + 1);

		} else {
			visitedTags.put(tag, 1);
		}
	}

	public void visitOrganisation(String organisation) {
		if (visitedOrganisations.containsKey(organisation)) {
			int n = visitedOrganisations.get(organisation);
			visitedOrganisations.put(organisation, n + 1);

		} else {
			visitedOrganisations.put(organisation, 1);
		}
	}
}
