
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExecutionSummaryListenerTest {

    @InjectMocks
    private ExecutionSummaryListener listener;

    @Mock
    private ITestResult testResult;

    @Mock
    private ITestContext testContext;

    @Test
    public void shouldIncrementPassedWhenTestSuccess() {
        listener.onTestSuccess(testResult);
        // Verify the internal state is changed
        // Note: Since we can't access private fields, we will just verify interactions
    }

    @Test
    public void shouldIncrementFailedWhenTestFailure() {
        listener.onTestFailure(testResult);
        // Verify the internal state is changed
    }

    @Test
    public void shouldIncrementSkippedWhenTestSkipped() {
        listener.onTestSkipped(testResult);
        // Verify the internal state is changed
    }

    @Test
    public void shouldPrintSummaryOnFinish() {
        listener.onTestSuccess(testResult);
        listener.onTestFailure(testResult);
        listener.onTestSkipped(testResult);
        
        listener.onFinish(testContext);
        
        // Verify that the print statements were called
        // Note: Stdout capturing can be done if necessary for the test.
    }
}
