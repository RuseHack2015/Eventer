package com.eventer.objectControllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eventer.objects.Event;
import com.eventer.objects.User;

public class UserController {
	public void attendEvent(String user, String event) {
		User curUser = getUserFromDB(user);
		Event curEvent = getEventFromDB(event);
		curUser.visitEvent(event);
		curUser.visitOrganisation(curEvent.getOrganisation());
		List<String> tags = curEvent.getTags();
		for (int i = 0; i < tags.size(); i++) {
			curUser.visitTag(tags.get(i));
		}
		setUserToDB(curUser);
	}

	private int giveScore(Event event, User user) {
		int score = 0;
		List<String> tags = event.getTags();
		String curTag;
		String curOrg=event.getOrganisation();
		Map<String, Integer> vT = user.getVisitedTags();
		Map<String, Integer> vO = user.getVisitedOrganisations();
		List<String> fT = user.getFollowedTags();
		for (int i = 0; i < tags.size(); i++) {
			curTag = tags.get(i);
			if (vT.containsKey(curTag))
			{
				score+=vT.get(curTag);
			}
			if (fT.contains(curTag))
			{
				score+=10;
			}
		}
		score/=tags.size();
		if (vO.containsKey(curOrg))
		{
			score+=vO.get(curOrg);
		}
		return score;
	}

	public List<String> suggestEvents(String user) {
		User curUser = getUserFromDB(user);
		List<Event> curEvents; = getAllAppropriateEvents(curUser);
		List<String> tags;
		List<IntStringPair> scores = new ArrayList<IntStringPair>();
		IntStringPair curPair;
		String organisation;
		for (int i = 0; i < curEvents.size(); i++) {
			curPair.score=giveScore(curEvents.get(i), curUser);
			curPair.name=curEvents.get(i).getName();
		}
		Collections.sort(scores);
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < scores.size(); i++) {
			result.add(scores.get(i).name);
		}
		return result;
	}
}
