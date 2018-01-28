package com.serenity.steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = JBehaveTest.StoryLoader.class,
		storyReporterBuilder = JBehaveTest.ReportBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false,
		ignoreFailureInView = true, verboseFailures = true)
@UsingSteps(instances = { DefinitionSteps.class})
public class JBehaveTest extends InjectableEmbedder{
	@Test
	public void run() {
		URL storyURL = null;
		try {
			storyURL = new URL("file://" + System.getProperty("user.dir") + "/src/test/resources/stories/");
			List<String> storyPath = new StoryFinder().findPaths(storyURL, "*/*.story", "");
			injectedEmbedder().runStoriesAsPaths(storyPath);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static class StoryLoader extends LoadFromClasspath {
		public StoryLoader() {
			super(JBehaveTest.class.getClassLoader());
		}
	}
	
	public static class ReportBuilder extends StoryReporterBuilder {
		public ReportBuilder() {
			new StoryReporterBuilder().withFormats(Format.XML);
		}
	}


}
