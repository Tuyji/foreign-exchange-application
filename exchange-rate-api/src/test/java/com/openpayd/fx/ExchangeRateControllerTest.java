package com.openpayd.fx;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openpayd.client.feign.FixerApiFeignClient;
import com.openpayd.fx.controller.ExchangeRateController;


@WebMvcTest(ExchangeRateController.class)
public class ExchangeRateControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	FixerApiFeignClient client;

	@Test
	public void testGetExchangeRate() throws Exception{
		mvc.perform(get("/exchangerates")
				.param("source", "EUR")
				.param("target", "USD"))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
