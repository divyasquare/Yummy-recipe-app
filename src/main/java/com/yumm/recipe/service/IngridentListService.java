package com.yumm.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumm.recipe.entities.IngridentList;
import com.yumm.recipe.repository.IngridentListRepo;

@Service
public class IngridentListService {

	
	private final IngridentListRepo ingridentListRepo;

	@Autowired
	public IngridentListService(final IngridentListRepo ingridentListRepo )
	{
		this.ingridentListRepo=ingridentListRepo;
	}
	
	
	 public List<IngridentList> getIngridentList(final int id) {
		 
	 return ingridentListRepo.findByRecipeId(id); 
	 
	 }
	 
	 public void deleteIngridentList(final int id) {
		 
		  ingridentListRepo.deleteByRecipeId(id); 
		 
		 }


	public void save(IngridentList ig) {

		ingridentListRepo.save(ig); 
	}

			
	
	
}
