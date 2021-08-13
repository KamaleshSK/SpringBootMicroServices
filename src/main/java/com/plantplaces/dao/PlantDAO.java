package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.plantplaces.dto.PlantDTO;

public class PlantDAO {

	@Autowired
	NetworkDAO networkDAO;
	
	public List<PlantDTO> fetch(String searchFilter) throws Exception {
		List<PlantDTO> allPlants = new ArrayList<PlantDTO>();
		
		// fill in the API url later
		networkDAO.request("");
		
		return allPlants;
	}
}
