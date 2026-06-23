package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
   @Test
    public void test(){
       ExternalApi api= Mockito.mock(ExternalApi.class);
       Mockito.when(api.getData("101")).thenReturn("Mocked Data");
       Service service = new Service(api);
       service.getData("101");
       verify(api).getData(anyString());

   }
}