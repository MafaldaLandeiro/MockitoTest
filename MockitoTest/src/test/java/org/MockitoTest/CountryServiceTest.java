package org.MockitoTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryServiceTest {

	private static final Logger log = LoggerFactory
			.getLogger(CountryServiceTest.class);

	private CountryService service;

	@Mock
	private CountryRepository repository;

	@Mock
	private Country country;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		service = new CountryService();
		service.setCountryRepository(repository);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(service);
		assertNotNull(repository);
		assertNotNull(country);
	}

	@Test
	public void testFindAll() {
		List<Country> list = new ArrayList<Country>();
		list.add(new Country(1, "EUR", "PORTUGAL"));
		list.add(new Country(2, "GBP", "ENGLAND"));
		list.add(new Country(3, "EUR", "FRANCE"));
		list.add(new Country(4, "YEN", "JAPAN"));
		list.add(new Country(5, "ZAR", "SOUTH AFRICA"));
		log.info("testFindAll() - findAll() to return " + list.toString());
		when(repository.findAll()).thenReturn(list);
		log.info("testFindAll() - findAll() calling");
		List<Country> result = service.findAll();
		log.info("testFindAll() - Verifying findAll() is called at least once");
		verify(repository, atLeastOnce()).findAll();
		log.info("testFindAll() - Asserting that the result is not null or empty");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	public void testFindOne() {
		Country c = new Country(3, "EUR", "FRANCE");
		log.info("testFindOne() - findOne(3) to return " + c.toString());
		when(repository.findOne(3)).thenReturn(c);
		log.info("testFindOne() - findOne(3) calling");
		Country result = service.findOne(3);
		log.info("testFindOne() - Verifying findOne(3) is called at least once");
		verify(repository, atLeastOnce()).findOne(3);
		log.info("testFindOne() - Asserting that the result is not null");
		assertNotNull(result);
	}

	@Test
	public void testFindByCurrency() {
		List<Country> list = new ArrayList<Country>();
		list.add(new Country(1, "EUR", "PORTUGAL"));
		list.add(new Country(3, "EUR", "FRANCE"));
		log.info("testFindByCurrency() - findByCurrency(\"EUR\") to return "
				+ list.toString());
		when(repository.findByCurrency("EUR")).thenReturn(list);
		log.info("testFindByCurrency() - findByCurrency(\"EUR\") calling");
		List<Country> result = service.findByCurrency("EUR");
		log.info("testFindByCurrency() - Verifying findByCurrency(\"EUR\") is called at least once");
		verify(repository, atLeastOnce()).findByCurrency("EUR");
		log.info("testFindByCurrency() - Asserting that the result is not null or empty");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

}
