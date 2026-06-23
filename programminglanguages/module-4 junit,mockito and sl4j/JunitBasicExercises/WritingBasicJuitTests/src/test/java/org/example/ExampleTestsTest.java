package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class ExampleTestsTest extends TestCase {
    @Test
    public void test1(){
        ExampleTests obj=new ExampleTests();
        int res =obj.add(2,3);
        assertEquals(5, res);
        System.out.print("Test1 is executed Successfully");
    }
    @Test
    public void test2(){
        ExampleTests obj=new ExampleTests();
        int res =obj.mul(2,3);
        assertEquals(6, res);
        System.out.print("Test2 is executed Successfully");


    }

}