package com.prasad.tutorial.devops.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Calculator calculator;

    @Autowired
    private CalculatorController calculatorController;

	@Test
	public void contextLoads() {
		assertThat(calculatorController).isNotNull();
	}

	@Test
	public void testSum() {
	    assertEquals(7,calculator.sum(3,4));
    }

    @Test
    public void shouldReturnSum() throws Exception {
	    this.mockMvc.perform(get("/sum").param("a","1").param("b","2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("3")));
    }
}
