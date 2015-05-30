package com.eventer.objectControllers;

public class IntStringPair implements Comparable<IntStringPair> {

	public int score;
	public String name;

	@Override
	public int compareTo(IntStringPair other) {
		if (score<other.score) return -1;
		if (score>other.score) return 1;
		return 0;
	}
}
