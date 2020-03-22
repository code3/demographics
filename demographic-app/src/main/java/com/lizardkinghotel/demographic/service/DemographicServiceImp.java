package com.lizardkinghotel.demographic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lizardkinghotel.demographic.entities.DemographicEntity;
import com.lizardkinghotel.demographic.repos.DemographicRepository;


@Service
public class DemographicServiceImp implements DemographicService {

	@Autowired
	private DemographicRepository repo;
	

	@Override
	public void deleteDemo(DemographicEntity demoEntity) {
		
		repo.delete(demoEntity);

	}

	@Override
	public DemographicEntity getDemoById(Long id) {
		
		return repo.findById(id).get();
		
	}

	@Override
	public List<DemographicEntity> getAllDemographics() {
		
		//for this to work we need to modify the repo class from 
		//CRUDRepository to JPARepository.
		//JPARepository is a sub interface of the CRUD repository
		return repo.findAll();
	}

	public DemographicRepository getDemoRepository() {
		return repo;
	}

	public void setDemoRepository(DemographicRepository demoRepository) {
		this.repo = demoRepository;
	}
	
	
	@Override
	public DemographicEntity saveDemo(DemographicEntity demoEntity) {
		
		return repo.save(demoEntity);
		
	}

	@Override
	public DemographicEntity updateDemo(DemographicEntity demoEntity) {
		
		return repo.save(demoEntity);
		
	}	

}
