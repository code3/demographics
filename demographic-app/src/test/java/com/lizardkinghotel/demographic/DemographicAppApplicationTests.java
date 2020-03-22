package com.lizardkinghotel.demographic;

import java.util.Optional;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lizardkinghotel.demographic.entities.DemographicEntity;
import com.lizardkinghotel.demographic.repos.DemographicRepository;

//@RunWith(SpringRunner.class)
//this annotation will run test for classes that have the annotation @SpringBootApplication
@SpringBootTest 
class DemographicAppApplicationTests {

	@Autowired
	private DemographicRepository demoRepo;//DemographicRepository is created at runtime

	@Test
	public void testCreateDemographic() {
		
		//save is what we need to create a new demo record
		//the Demographic object will be used to create table and fields
		DemographicEntity demoEntity = new DemographicEntity();
		
		demoEntity.setAge("39–47");
		demoEntity.setChildren(2);
		demoEntity.setCity("san jose");;
		demoEntity.setCountry("costa rica");
		demoEntity.setEducation("bacherlors degree");
		demoEntity.setEmail("test@test.com");
		demoEntity.setEmployment("yes");
		demoEntity.setGender("male");		
		demoEntity.setGuestAmount(2);
		demoEntity.setHearAbout("google search");

		
		demoRepo.save(demoEntity);						
		
	}
	
	//testing find by id
	@Test
	public void testFindDemographicsById() {
		
		DemographicEntity demoEntity = demoRepo.findById(103l).get();		
		System.out.println(demoEntity);		
	}
	
	//testing updating a record
	@Test
	public void testUpdateDemo() {
		
		DemographicEntity demoEntity = demoRepo.findById(103l).get();
		demoEntity.setGuestAmount(3);
		
		demoRepo.save(demoEntity);
		
	}
	
	@Test
	public void testDeleteDemo() {
		
		DemographicEntity demoEntity = demoRepo.findById(103l).get();
		//demoEntity.setGuestAmount(3);
		
		demoRepo.delete(demoEntity);
		
	}	
	
	
}
