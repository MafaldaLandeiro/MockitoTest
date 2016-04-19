package org.MockitoTest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository  extends CrudRepository<Country,Integer>{
	
	List<Country> findByCurrency(String currency);

}
