package com.serenity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.steps.DefinitionSteps;

import net.serenitybdd.jbehave.SerenityStory;
import net.serenitybdd.jbehave.runners.SerenityReportingRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityReportingRunner.class)
public class JunitTest extends SerenityStory{
	@Managed(driver="chrome")
	WebDriver driver;
	
	@Steps
	DefinitionSteps definitionSteps;
	
	@Test
	public void should_be_able_to_search_in_wiki() {
		// Given
		definitionSteps.givenTheUserIsOnTheWikionaryHomePage();
		
		// When
		definitionSteps.whenTheUserLooksUpTheDefinitionOf("morgan stanley");
		
		// Then
		definitionSteps.thenTheyShouldSeeADefinitionContainingTheWords("morgan stanley");
	}

}
