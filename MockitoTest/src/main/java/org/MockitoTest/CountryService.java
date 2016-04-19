package org.MockitoTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}

	/**
	 * @return the countryRepository
	 */
	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	/**
	 * @param countryRepository
	 *            the countryRepository to set
	 */
	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}

	public List<Country> findByCurrency(String currency) {
		return countryRepository.findByCurrency(currency);
	}

}
