package com.openpayd.conversion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.openpayd.conversion.model.Conversion;
import com.openpayd.conversion.repository.ConversionRepository;
import com.openpayd.conversion.util.ConversionBuilder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConversionRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	ConversionRepository repository;

	@Before
	public void setUp(){
		Conversion conversion = ConversionBuilder.createInstance()
				.setSource("EUR")
				.setTarget("TRY")
				.setExchangeRate("6.35")
				.setAmount("20")
				.calculateResult()
				.build();

		testEntityManager.persist(conversion);
	}

	@Test
	public void testFindById() {
		Conversion conversion = repository.findById(1L).get();
		assertThat(conversion.getSource()).isEqualTo("EUR");
	}

}
