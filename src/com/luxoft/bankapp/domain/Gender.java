package com.luxoft.bankapp.domain;

public enum Gender {
	MALE("Mr.", "m"), FEMALE("Ms.", "f");

	private final String greeting;
	private final String stringLine;

	Gender(String greeting, String stringLine) {
        this.greeting = greeting;
        this.stringLine = stringLine;
    }

	public String getGreeting() {
		return greeting;
	}
	
	 public static Gender parse(String stringLine) {
        for (Gender gender: values()) {
            if (stringLine.equals(gender.stringLine)) {
                return gender;
            }
        }
        return null;
    }

    public String getStringLine() {
        return stringLine;
    }
}
