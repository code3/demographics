package com.lizardkinghotel.demographic.repos;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.lizardkinghotel.demographic.entities.DemographicEntity;

//DemographicEntity is the type of model class it needs to deal with
//Long is the type of the database id
//#commented out this interface
//public interface DemographicRepository extends CrudRepository<DemographicEntity, Long> {
//JpaRepository is a sub interface of CrudRepository. We needed a method to return 
//a list, however, CrudRepository does not JpaRepository does. 
public interface DemographicRepository extends JpaRepository<DemographicEntity, Long> {
	
}
