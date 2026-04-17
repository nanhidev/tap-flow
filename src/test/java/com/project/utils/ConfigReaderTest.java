
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;

import java.util.Properties;

@ExtendWith(MockitoExtension.class)
class ConfigReaderTest {

    @InjectMocks
    private ConfigReader configReader;

    @Mock
    private Properties properties;

    @Test
    void shouldReturnBrowserProperty() {
        when(properties.getProperty("browser")).thenReturn("chrome");
        assertEquals("chrome", configReader.getBrowser());
    }

    @Test
    void shouldReturnBaseUrlProperty() {
        when(properties.getProperty("url")).thenReturn("http://localhost");
        assertEquals("http://localhost", configReader.getBaseUrl());
    }

    @Test
    void shouldReturnImplicitWaitProperty() {
        when(properties.getProperty("implicit.wait")).thenReturn("10");
        assertEquals(10, configReader.getImplicitWait());
    }

    @Test
    void shouldReturnExplicitWaitProperty() {
        when(properties.getProperty("explicit.wait")).thenReturn("20");
        assertEquals(20, configReader.getExplicitWait());
    }

    @Test
    void shouldReturnHeadlessProperty() {
        when(properties.getProperty("browser.headless")).thenReturn("true");
        assertEquals(true, configReader.isHeadless());
    }

    @Test
    void shouldReturnEnvironmentProperty() {
        when(properties.getProperty("environment")).thenReturn("staging");
        assertEquals("staging", configReader.getEnvironment());
    }

    @Test
    void shouldReturnFrameworkTypeProperty() {
        when(properties.getProperty("framework.type")).thenReturn("cucumber-junit");
        assertEquals("cucumber-junit", configReader.getFrameworkType());
    }

    @Test
    void shouldReturnTestRunnerProperty() {
        when(properties.getProperty("test.runner")).thenReturn("junit");
        assertEquals("junit", configReader.getTestRunner());
    }

    @Test
    void shouldReturnCucumberTagsProperty() {
        when(properties.getProperty("cucumber.tags")).thenReturn("@smoke");
        assertEquals("@smoke", configReader.getCucumberTags());
    }

    @Test
    void shouldReturnFeaturePathProperty() {
        when(properties.getProperty("cucumber.features.path")).thenReturn("src/test/resources/features");
        assertEquals("src/test/resources/features", configReader.getFeaturePath());
    }

    @Test
    void shouldReturnGluePathProperty() {
        when(properties.getProperty("cucumber.glue.path")).thenReturn("com.project.stepdefinitions");
        assertEquals("com.project.stepdefinitions", configReader.getGluePath());
    }

    @Test
    void shouldReturnReportPathProperty() {
        when(properties.getProperty("report.path")).thenReturn("reports/test-report");
        assertEquals("reports/test-report", configReader.getReportPath());
    }

    @Test
    void shouldReturnScreenshotOnFailureProperty() {
        when(properties.getProperty("screenshot.on.failure")).thenReturn("false");
        assertEquals(false, configReader.isScreenshotOnFailure());
    }

    @Test
    void shouldReturnPlaywrightEnabledProperty() {
        when(properties.getProperty("playwright.enabled")).thenReturn("true");
        assertEquals(true, configReader.isPlaywrightEnabled());
    }

    @Test
    void shouldReturnVisualRegressionEnabledProperty() {
        when(properties.getProperty("visual.regression.enabled")).thenReturn("false");
        assertEquals(false, configReader.isVisualRegressionEnabled());
    }

    @Test
    void shouldReturnPlaywrightBrowserProperty() {
        when(properties.getProperty("playwright.browser")).thenReturn("firefox");
        assertEquals("firefox", configReader.getPlaywrightBrowser());
    }
}
