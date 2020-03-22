package com.lizardkinghotel.demographic.service;

import java.util.List;

import com.lizardkinghotel.demographic.entities.DemographicEntity;

public interface DemographicService {
	
	//DemographicEntity demoEntity = new DemographicEntity();

	DemographicEntity saveDemo(DemographicEntity demoEntity);
	DemographicEntity updateDemo(DemographicEntity demoEntity);
	void deleteDemo(DemographicEntity demoEntity);
	DemographicEntity getDemoById(Long id);
	List<DemographicEntity> getAllDemographics();	
	
}
