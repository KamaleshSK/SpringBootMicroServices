package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;

//allow us to save specimen DTOs to some kind of persistence mechanism (database)

@Component
public class SpecimenServiceStub implements ISpecimenService {
	
	@Autowired
	private ISpecimenDAO specimenDAO;
	
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
	public boolean save(SpecimenDTO specimenDTO) throws Exception {
		boolean result = specimenDAO.save(specimenDTO);	
		return result;
	}
	
	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {
		// stub out a plant fetch mechanism
		List<PlantDTO> matchingPlants = new ArrayList<PlantDTO>();
		
		if (searchTerm.contains("edbud") || searchTerm.contains("Cercis")) {
			PlantDTO plant = new PlantDTO();
			plant.setGenus("Cercis");
			plant.setSpecies("canadensis");
			plant.setCommon("Eastern Redbud");
			matchingPlants.add(plant);
		}
		
		return matchingPlants;
	}

	public ISpecimenDAO getSpecimenDAO() {
		return specimenDAO;
	}

	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}
}
