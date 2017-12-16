package com.prasad.tutorial.devops.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

    @Autowired
    private Calculator calculator;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSum() {
	    assertEquals(7,calculator.sum(3,4));
    }
}
