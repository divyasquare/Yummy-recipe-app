package com.yumm.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yumm.recipe.entities.IngridentList;

@Repository
public interface IngridentListRepo extends JpaRepository<IngridentList, Integer>{
    
	List<IngridentList> findByRecipeId(int id);
	@Transactional
	void deleteByRecipeId( int id);
	
	

}
