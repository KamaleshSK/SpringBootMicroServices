package com.plantplaces.service;

import org.springframework.stereotype.Component;

import com.plantplaces.dto.SpecimenDTO;

//allow us to save specimen DTOs to some kind of persistence mechanism (database)

@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	@Override
	public SpecimenDTO fetchById(int id) {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenID(id);
		specimenDTO.setLatitude("89.90");
		specimenDTO.setLongitude("0.00");
		specimenDTO.setDescription("A beautiful sunflower");
		return specimenDTO;
	}
	
	@Override
	public void save(SpecimenDTO specimenDTO) {
		
	}
}
