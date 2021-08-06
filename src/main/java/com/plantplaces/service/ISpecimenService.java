package com.plantplaces.service;

import com.plantplaces.dto.SpecimenDTO;

import java.util.List;

import com.plantplaces.dto.PlantDTO;

/*
 * CRUD operations for specimens
 * @author Administrator
 */
public interface ISpecimenService {

	SpecimenDTO fetchById(int id);

	boolean save(SpecimenDTO specimenDTO) throws Exception;
	
	/*
	 * Return a list of plants that contain this string
	 * @param string - the search criteria: can be genus, species, cultivar or common
	 * @return a list of matching plants
	 */
	List<PlantDTO> fetchPlants(String string);

}