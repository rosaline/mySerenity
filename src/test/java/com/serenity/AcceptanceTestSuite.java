package com.serenity;

import net.serenitybdd.jbehave.SerenityStories;

public class AcceptanceTestSuite extends SerenityStories {
	public AcceptanceTestSuite() {
	      runSerenity().inASingleSession();
	    }
}
