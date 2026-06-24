package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {
    @Test
    void test() {
        Repository r = mock(Repository.class);
        when(r.getData()).thenReturn("First Mock Data").thenReturn("Second Mock Data");
        Service s = new Service(r);
        assertEquals("Processed First Mock Data", s.processData());
        assertEquals("Processed Second Mock Data", s.processData());
    }
}