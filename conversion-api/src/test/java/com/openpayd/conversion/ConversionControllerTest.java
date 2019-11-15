package com.openpayd.conversion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openpayd.client.feign.FixerApiFeignClient;
import com.openpayd.conversion.controller.ConversionController;

@WebMvcTest(ConversionController.class)
public class ConversionControllerTest {

	@Autowired
    MockMvc mvc;
	
	@MockBean
	FixerApiFeignClient client;
	
	@Test
	public void testFindById() throws Exception{
		mvc.perform(get("/conversions/id/1"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testFindByDate() throws Exception{
		mvc.perform(get("/conversions")
				.param("date", LocalDate.now().toString())
				.param("pageNo", "0")
				.param("pageSize", "1"))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
