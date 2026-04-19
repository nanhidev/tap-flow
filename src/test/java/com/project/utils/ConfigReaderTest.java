
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConfigReaderTest {

    @InjectMocks
    private ConfigReader configReader;

    @Mock
    private FileInputStream fileInputStream;

    @Mock
    private File file;

    @BeforeEach
    void setUp() throws Exception {
        System.setProperty("user.dir", "testDir");
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(file.canRead()).thenReturn(true);
        Mockito.whenNew(File.class).withArguments("testDir/config.properties").thenReturn(file);
        Mockito.when(fileInputStream.read(any(byte[].class))).thenReturn(-1);
    }

    @Test
    void shouldReturnBrowserWhenGetBrowserCalled() {
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        configReader.loadProperties();
        assertEquals("chrome", configReader.getBrowser());
    }

    @Test
    void shouldReturnBaseUrlWhenGetBaseUrlCalled() {
        Properties properties = new Properties();
        properties.setProperty("url", "http://localhost");
        configReader.loadProperties();
        assertEquals("http://localhost", configReader.getBaseUrl());
    }

    @Test
    void shouldReturnImplicitWaitWhenGetImplicitWaitCalled() {
        Properties properties = new Properties();
        properties.setProperty("implicit.wait", "10");
        configReader.loadProperties();
        assertEquals(10, configReader.getImplicitWait());
    }

    @Test
    void shouldReturnExplicitWaitWhenGetExplicitWaitCalled() {
        Properties properties = new Properties();
        properties.setProperty("explicit.wait", "20");
        configReader.loadProperties();
        assertEquals(20, configReader.getExplicitWait());
    }

    @Test
    void shouldReturnHeadlessWhenIsHeadlessCalled() {
        Properties properties = new Properties();
        properties.setProperty("browser.headless", "true");
        configReader.loadProperties();
        assertEquals(true, configReader.isHeadless());
    }

    @Test
    void shouldReturnEnvironmentWhenGetEnvironmentCalled() {
        Properties properties = new Properties();
        properties.setProperty("environment", "staging");
        configReader.loadProperties();
        assertEquals("staging", configReader.getEnvironment());
    }

    @Test
    void shouldReturnFrameworkTypeWhenGetFrameworkTypeCalled() {
        Properties properties = new Properties();
        properties.setProperty("framework.type", "cucumber-testng");
        configReader.loadProperties();
        assertEquals("cucumber-testng", configReader.getFrameworkType());
    }

    @Test
    void shouldReturnTestRunnerWhenGetTestRunnerCalled() {
        Properties properties = new Properties();
        properties.setProperty("test.runner", "junit");
        configReader.loadProperties();
        assertEquals("junit", configReader.getTestRunner());
    }

    @Test
    void shouldReturnCucumberTagsWhenGetCucumberTagsCalled() {
        Properties properties = new Properties();
        properties.setProperty("cucumber.tags", "@smoke");
        configReader.loadProperties();
        assertEquals("@smoke", configReader.getCucumberTags());
    }

    @Test
    void shouldReturnFeaturePathWhenGetFeaturePathCalled() {
        Properties properties = new Properties();
        properties.setProperty("cucumber.features.path", "src/test/resources/features");
        configReader.loadProperties();
        assertEquals("src/test/resources/features", configReader.getFeaturePath());
    }

    @Test
    void shouldReturnGluePathWhenGetGluePathCalled() {
        Properties properties = new Properties();
        properties.setProperty("cucumber.glue.path", "com.project.stepdefs");
        configReader.loadProperties();
        assertEquals("com.project.stepdefs", configReader.getGluePath());
    }

    @Test
    void shouldReturnReportPathWhenGetReportPathCalled() {
        Properties properties = new Properties();
        properties.setProperty("report.path", "target/reports");
        configReader.loadProperties();
        assertEquals("target/reports", configReader.getReportPath());
    }

    @Test
    void shouldReturnScreenshotOnFailureWhenIsScreenshotOnFailureCalled() {
        Properties properties = new Properties();
        properties.setProperty("screenshot.on.failure", "false");
        configReader.loadProperties();
        assertEquals(false, configReader.isScreenshotOnFailure());
    }

    @Test
    void shouldReturnPlaywrightEnabledWhenIsPlaywrightEnabledCalled() {
        Properties properties = new Properties();
        properties.setProperty("playwright.enabled", "true");
        configReader.loadProperties();
        assertEquals(true, configReader.isPlaywrightEnabled());
    }

    @Test
    void shouldReturnVisualRegressionEnabledWhenIsVisualRegressionEnabledCalled() {
        Properties properties = new Properties();
        properties.setProperty("visual.regression.enabled", "false");
        configReader.loadProperties();
        assertEquals(false, configReader.isVisualRegressionEnabled());
    }

    @Test
    void shouldReturnPlaywrightBrowserWhenGetPlaywrightBrowserCalled() {
        Properties properties = new Properties();
        properties.setProperty("playwright.browser", "chrome");
        configReader.loadProperties();
        assertEquals("chrome", configReader.getPlaywrightBrowser());
    }
}
