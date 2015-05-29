package com.eventer.objects;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Organisation {

	private String name, phone1, phone2, adress, email, info;
	private List<String> tags = new ArrayList<String>();
	private List<String> events = new ArrayList<String>();
	private Image logo;

	public Organisation(String name) {
		this.name = name;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public void addEvent(String event) {
		events.add(event);
	}

}
