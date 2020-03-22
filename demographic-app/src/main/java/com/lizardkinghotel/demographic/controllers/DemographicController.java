package com.lizardkinghotel.demographic.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.lizardkinghotel.demographic.data.PropertyData;
//import com.code3design.io.repositories.UserRepository;
import com.lizardkinghotel.demographic.entities.DemographicEntity;
import com.lizardkinghotel.demographic.repos.DemographicRepository;
import com.lizardkinghotel.demographic.service.DemographicService;

@Controller
public class DemographicController {

	@Autowired
	DemographicService demoService;
	
	@Autowired
	DemographicRepository demoRepo;

	@RequestMapping("/showCreate") // the url
	public String showCreate(ModelMap modelMap, @RequestParam(required = false) String msg) {

		
		
		Map<String, String> mapCountries = this.getCountries();
		
		modelMap.addAttribute("mapCountries", mapCountries);
		
		modelMap.addAttribute("maritalStatus", this.getMaritalStatusList());		
		modelMap.addAttribute("education", this.getEducation());
		modelMap.addAttribute("reasonsChosen", this.getReasonsChosen());
		modelMap.addAttribute("hearAbout", this.getHearAbout());
		modelMap.addAttribute("gender", this.getGender());
		modelMap.addAttribute("mostImportantOne", this.getMostImportantOne());
		modelMap.addAttribute("mostImportantTwo", this.getMostImportantTwo());
		modelMap.addAttribute("mostImportantThree", this.getMostImportantThree());
		
		return "createDemo"; // the page name

	}

	@RequestMapping("/saveDemo") //url
	public String saveDemo(@ModelAttribute("demographic") DemographicEntity demoEntity, 
									ModelMap modelMap) throws UnsupportedEncodingException {

		DemographicEntity demoSaved = demoService.saveDemo(demoEntity);

		String msg = "Demograph saved with id " + demoSaved.getId();

		modelMap.addAttribute("msg", msg);

		//return "createDemo"; //page
		return "redirect:showCreate/?msg=" + URLEncoder.encode(msg, "UTF-8"); //.encode(msg);
	}
	

	@RequestMapping("/displayDemographics") // url
	public String displayDemos(ModelMap modelMap) {

		List<DemographicEntity> demoEntity = demoService.getAllDemographics();
		
		modelMap.addAttribute("demoEntity", demoEntity);
		
		modelMap.addAttribute("header", PropertyData.getHeader());

		return "displayDemos"; //page name
	}
	
	
	
	@RequestMapping("/deleteDemo")
	public String deleteDemo(@RequestParam("id") Long id, ModelMap modelMap) {
		
		//it can be done with this one line below but it takes a hit in the database
		//DemographicEntity demoEntity = demoService.getDemoById(id);
		
		//these two lines are an alternative lessening a hit to the database
		DemographicEntity demoEntity = new DemographicEntity();
		demoEntity.setId(id);
		
		demoService.deleteDemo(demoEntity);
		
		//after deleting, we want all the demographics to show up again
		//to avoid boilerplate code, we'll call the method displayDemos
		return this.displayDemos(modelMap);				
		
	}
	
	@RequestMapping("/updateDemoPage") //url
	public String showUpdateDemo(@RequestParam("id") Long id, ModelMap modelMap) {
		
		DemographicEntity demoEntity = demoService.getDemoById(id);		
		
		modelMap.addAttribute("demoEntity", demoEntity);
		
		Map<String, String> mapCountries = this.getCountries();
		
		modelMap.addAttribute("mapCountries", mapCountries);		
		modelMap.addAttribute("maritalStatus", this.getMaritalStatusList());		
		modelMap.addAttribute("education", this.getEducation());
		modelMap.addAttribute("reasonsChosen", this.getReasonsChosen());
		modelMap.addAttribute("hearAbout", this.getHearAbout());
		modelMap.addAttribute("gender", this.getGender());
		modelMap.addAttribute("mostImportantOne", this.getMostImportantOne());
		modelMap.addAttribute("mostImportantTwo", this.getMostImportantTwo());
		modelMap.addAttribute("mostImportantThree", this.getMostImportantThree());					  
		
		return "updateDemoPage"; //page
	}
	
	
	@RequestMapping("/saveUpdate")
	public String updateDemo(DemographicEntity demoEntity, ModelMap modelMap) {		
		
		demoService.updateDemo(demoEntity);
		
		List<DemographicEntity> demoEntities = demoService.getAllDemographics();
		
		modelMap.addAttribute("demoEntity", demoEntities);
		
		return "redirect:/displayDemographics";
	}
	
	
//	@RequestMapping(value = "/saveUpdate/{id}", method = RequestMethod.POST)
//	public String updateDemo(@PathVariable("id") Long id, ModelMap modelMap, HttpServletRequest request) {		
//		
//		
//		
//		DemographicEntity demoEntity = demoService.getDemoById(id);
//		
//		//////////////////
//		
//		demoService.updateDemo(demoEntity);
//		
//		List<DemographicEntity> demoEntities = demoService.getAllDemographics();
//		
//		modelMap.addAttribute("demoEntity", demoEntities);
//		
//		return "displayDemos";
//	}	
	
	
	
	private Map<String, String> getCountries() {
		
		String[] countryCodes = Locale.getISOCountries();
		
		Map<String, String> mapCountries = new TreeMap<>();
		
		for(String countryCode : countryCodes) {
			
			Locale locale = new Locale("", countryCode);
			String code = locale.getCountry();
			String name = locale.getDisplayCountry();
			mapCountries.put(code, name);			
			
		}
		
		return mapCountries;
		
	}
	
	

	public Map<String, String> getMaritalStatusList(){

	    Map<String, String> maritalStatusList = new HashMap<String, String>();
	    
	    maritalStatusList.put("married/casado", "married/casado");
	    maritalStatusList.put("married/casado", "married/casado");
	    maritalStatusList.put("divorced/divorciado", "divorced/divorciado");
	    maritalStatusList.put("widow(er)/viudo(a)", "widow(er)/viudo(a)");
	    
	    return maritalStatusList;
    
	}
	
	public Map<String, String> getEducation(){
		
		
	    Map<String, String> education = new HashMap<String, String>();
	    
		education.put("highschool", "Highschool/Secundaria");
		education.put("bachelors degree", "Bachelor's Degree/Bachillerato Universitario");
		education.put("masters degree", "Masters/Maestria");
		education.put("doctorate", "Doctorate/Doctorado");
	    
	    return education;
		
	}
	
	
	
	public Map<String, String> getReasonsChosen(){
		
		
	    Map<String, String> reasonsChosen = new HashMap<String, String>();
	    
	    reasonsChosen.put("breakfast", "Because of the breakfast");
	    reasonsChosen.put("cleaning", "Because of the cleanliness");
	    reasonsChosen.put("receptionist", "Because of the receptionist");
	    reasonsChosen.put("housekeepers", "Because of the housekeeping");
	    reasonsChosen.put("general staff", "Because of the staff in general");
	    reasonsChosen.put("swimming pool", "Because of swimming pool");
	    reasonsChosen.put("parking lot", "Because of parking lot");
	    reasonsChosen.put("bed", "Because of the beds");
	    reasonsChosen.put("room floor", "Because of the room floors");
	    reasonsChosen.put("room size", "Because of the room size");
	    reasonsChosen.put("room decoration", "Because of the room decoration");
	    reasonsChosen.put("room in general", "Because of the room in general");
	    reasonsChosen.put("facilities", "Because of the facilities");
	    reasonsChosen.put("it is quiet", "Because it is quiet");
	    reasonsChosen.put("location", "Because of the location");
	    reasonsChosen.put("business hours", "Because of the business hours");
	    reasonsChosen.put("AC", "Because of the AC");
	    reasonsChosen.put("TV or Cable", "Because of the TV or Cable");
	    reasonsChosen.put("water", "Because of the water");
	    reasonsChosen.put("weather", "Because of the weather");
	    reasonsChosen.put("bar", "Because of the bar");
	    reasonsChosen.put("prices", "Because of ");
	    reasonsChosen.put("I do not know", "I do not know");
	    reasonsChosen.put("everything", "everything");
	    
	    return reasonsChosen;
	    		
	}
	
	
	
	public Map<String, String> getHearAbout(){		
		
	    Map<String, String> hearAbout = new HashMap<String, String>();
	    
	    hearAbout.put("google or other search", "Google search or other search web site");
	    hearAbout.put("booking.com", "Booking.com");
	    hearAbout.put("expedia", "Expedia");
	    hearAbout.put("other travel web site", "Other travel web site");
	    hearAbout.put("hotel web site", "The hotel web site");
	    hearAbout.put("friend family recommendation", "Friend or family recommendation");
	    hearAbout.put("facebook", "Facebook");
	    hearAbout.put("instagram", "Instagram");
	    hearAbout.put("youtube", "Youtube");
	    hearAbout.put("twitter", "Twitter");
	    hearAbout.put("linkedIn", "LinkedIn");
	    hearAbout.put("other social network", "Other social network");
	    hearAbout.put("walk in", "Saw location from the street");
	    hearAbout.put("other", "Other not mentioned on this list");
	    	    	    
	    return hearAbout;	    
		
	}	
	
	public Map<String, String> getGender(){
				
	    Map<String, String> gender = new HashMap<String, String>();
	    
	    gender.put("male", "male");
	    gender.put("female", "female");	    	    
	    
	    return gender;	    
		
	}
	
	
	
	public Map<String, String> getMostImportantOne(){
		
	    Map<String, String> mostImportantOne = new HashMap<String, String>();
	    
	    mostImportantOne.put("breakfast", "breakfast");
	    mostImportantOne.put("cleaning", "cleaning");
	    mostImportantOne.put("check-in", "check-in");
	    mostImportantOne.put("check-out", "check-out");
	    mostImportantOne.put("receptionist", "receptionist");
	    mostImportantOne.put("housekeepers", "housekeepers");
	    mostImportantOne.put("general", "general");
	    mostImportantOne.put("swimming pool", "swimming pool");
	    mostImportantOne.put("parking lot", "parking lot");
	    mostImportantOne.put("bed", "bed");
	    mostImportantOne.put("room floor", "room floor");
	    mostImportantOne.put("room size", "room size");
	    mostImportantOne.put("room decoration", "room decoration");
	    mostImportantOne.put("room in general", "room in general");
	    mostImportantOne.put("facilities", "facilities");
	    mostImportantOne.put("noise", "noise");
	    mostImportantOne.put("location", "location");
	    mostImportantOne.put("business hours", "business hours");
	    mostImportantOne.put("AC", "AC");
	    mostImportantOne.put("TV or Cable", "TV or Cable");
	    mostImportantOne.put("water", "water");
	    mostImportantOne.put("weather", "weather");
	    mostImportantOne.put("bar", "bar");
	    mostImportantOne.put("prices", "prices");
	    mostImportantOne.put("nothing good", "nothing good");
	    mostImportantOne.put("all good", "all good");
	    
	    return mostImportantOne;	    		
	
	}	
	
	
	public Map<String, String> getMostImportantTwo(){
		
	    Map<String, String> mostImportantTwo = new HashMap<String, String>();
	    
	    mostImportantTwo.put("breakfast", "breakfast");
	    mostImportantTwo.put("cleaning", "cleaning");
	    mostImportantTwo.put("check-in", "check-in");
	    mostImportantTwo.put("check-out", "check-out");
	    mostImportantTwo.put("receptionist", "receptionist");
	    mostImportantTwo.put("housekeepers", "housekeepers");
	    mostImportantTwo.put("general", "general");
	    mostImportantTwo.put("swimming pool", "swimming pool");
	    mostImportantTwo.put("parking lot", "parking lot");
	    mostImportantTwo.put("bed", "bed");
	    mostImportantTwo.put("room floor", "room floor");
	    mostImportantTwo.put("room size", "room size");
	    mostImportantTwo.put("room decoration", "room decoration");
	    mostImportantTwo.put("room in general", "room in general");
	    mostImportantTwo.put("facilities", "facilities");
	    mostImportantTwo.put("noise", "noise");
	    mostImportantTwo.put("location", "location");
	    mostImportantTwo.put("business hours", "business hours");
	    mostImportantTwo.put("AC", "AC");
	    mostImportantTwo.put("TV or Cable", "TV or Cable");
	    mostImportantTwo.put("water", "water");
	    mostImportantTwo.put("weather", "weather");
	    mostImportantTwo.put("bar", "bar");
	    mostImportantTwo.put("prices", "prices");
	    mostImportantTwo.put("nothing good", "nothing good");
	    mostImportantTwo.put("all good", "all good");
	    
	    return mostImportantTwo;	    		
	
	}
	
	
	public Map<String, String> getMostImportantThree(){
		
	    Map<String, String> mostImportantThree = new HashMap<String, String>();
	    
	    mostImportantThree.put("breakfast", "breakfast");
	    mostImportantThree.put("cleaning", "cleaning");
	    mostImportantThree.put("check-in", "check-in");
	    mostImportantThree.put("check-out", "check-out");
	    mostImportantThree.put("receptionist", "receptionist");
	    mostImportantThree.put("housekeepers", "housekeepers");
	    mostImportantThree.put("general", "general");
	    mostImportantThree.put("swimming pool", "swimming pool");
	    mostImportantThree.put("parking lot", "parking lot");
	    mostImportantThree.put("bed", "bed");
	    mostImportantThree.put("room floor", "room floor");
	    mostImportantThree.put("room size", "room size");
	    mostImportantThree.put("room decoration", "room decoration");
	    mostImportantThree.put("room in general", "room in general");
	    mostImportantThree.put("facilities", "facilities");
	    mostImportantThree.put("noise", "noise");
	    mostImportantThree.put("location", "location");
	    mostImportantThree.put("business hours", "business hours");
	    mostImportantThree.put("AC", "AC");
	    mostImportantThree.put("TV or Cable", "TV or Cable");
	    mostImportantThree.put("water", "water");
	    mostImportantThree.put("weather", "weather");
	    mostImportantThree.put("bar", "bar");
	    mostImportantThree.put("prices", "prices");
	    mostImportantThree.put("nothing good", "nothing good");
	    mostImportantThree.put("all good", "all good");
	    
	    return mostImportantThree;	    		
	
	}	
	

}
