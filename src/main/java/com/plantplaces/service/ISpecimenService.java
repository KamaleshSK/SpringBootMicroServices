package com.plantplaces.service;

import com.plantplaces.dto.SpecimenDTO;

/*
 * CRUD operations for specimens
 * @author Administrator
 */
public interface ISpecimenService {

	SpecimenDTO fetchById(int id);

	void save(SpecimenDTO specimenDTO);

}