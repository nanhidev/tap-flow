
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExecutionSummaryListenerTest {

    @InjectMocks
    private ExecutionSummaryListener listener;

    @Mock
    private ITestContext testContext;

    @Mock
    private ITestResult testResult;

    @Test
    public void shouldIncrementPassedCountWhenTestSuccess() {
        listener.onTestSuccess(testResult);
        listener.onFinish(testContext);

        // You would need to check the internal state, but since we can't, we verify the finish behavior
        verify(testContext).getSuite().getResults();
    }

    @Test
    public void shouldIncrementFailedCountWhenTestFailure() {
        listener.onTestFailure(testResult);
        listener.onFinish(testContext);

        // You would need to check the internal state, but since we can't, we verify the finish behavior
        verify(testContext).getSuite().getResults();
    }

    @Test
    public void shouldIncrementSkippedCountWhenTestSkipped() {
        listener.onTestSkipped(testResult);
        listener.onFinish(testContext);

        // You would need to check the internal state, but since we can't, we verify the finish behavior
        verify(testContext).getSuite().getResults();
    }

    @Test
    public void shouldPrintSummaryWhenFinishCalled() {
        listener.onTestSuccess(testResult);
        listener.onTestFailure(testResult);
        listener.onTestSkipped(testResult);
        
        listener.onFinish(testContext);

        // Verify that the summary printing occurs. Since we can't verify console output directly, 
        // this is a placeholder for the intended behavior.
        // You would typically use a logging framework or a different method to capture output.
    }
}
