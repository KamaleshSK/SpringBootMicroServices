package com.plantplaces;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;
import com.plantplaces.dao.ISpecimenDAO;

@Controller
public class PlantPlacesController { 
	
	@Autowired
	private ISpecimenService specimenServiceStub;
	
	@GetMapping(value="/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(73);
		return "start";
	}
	
	// Handle the /start endpoint
	@GetMapping(value="/start")
	public String read(Model model) {
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";
	}
	
	@GetMapping(value="/addspecimen")
	public String addSpecimen(Model model, @RequestParam(value="id", required=false, defaultValue="0") int specimenID) {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		specimenDTO.setSpecimenID(specimenID);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}
	
	@GetMapping(value="/start", params={"loyalty=blue"})
	public String readBlue() {
		return "start";
	}
	
	/*
	 * Model and view design instead of plain old return model and view seperately
	 */
	@GetMapping(value="/start", params={"loyalty=silver"})
	public ModelAndView readSilver() {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		specimenDTO.setSpecimenID(139031);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("start");
		modelAndView.addObject("specimenDTO", specimenDTO);
		return modelAndView;
	}
	
	@GetMapping(value="/start", headers= {"content-type=text/json"})
	@ResponseBody
	public SpecimenDTO readJSON(Model model) {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		return specimenDTO;
	}
	
	@PostMapping("/start")
	public String create() {
		return "start";
	}
	
	@GetMapping("/searchPlants")
	public String searchPlants(@RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm) {
		String enhancedString = searchTerm + "";
		return "start";
	}
	
	@GetMapping("/searchPlantsAll") 
	public String searchPlantsAll(@RequestParam Map<String, String> requestParams) {
		int params = requestParams.size();
		requestParams.get("searchTerm");
		return "start";
	}
	
}


 