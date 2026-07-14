package com.mockito.verifying;

import static org.mockito.Mockito.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        System.out.println("Mockito Interaction Verification test passed successfully.");
    }
}