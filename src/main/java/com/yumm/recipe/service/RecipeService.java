package com.yumm.recipe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.repository.RecipeRepository;

@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;

	@Autowired
	public RecipeService(final RecipeRepository recipeRepository )
	{
		this.recipeRepository=recipeRepository;
	}
	
	public Page<YummyRecipe> getRecipe( final int pageNum,final int size)
	{
		return recipeRepository.findAll(PageRequest.of(pageNum, size));
	}

	public Optional<YummyRecipe> getRecipe(final int id)
	{
		return recipeRepository.findById(id);
	}
	
	@Transactional
	public YummyRecipe save(final YummyRecipe yummyRecipe)
	{
		return recipeRepository.save(yummyRecipe);
	}
	 public void delete(final int id)
	 {
		 recipeRepository.deleteById(id);
	 }
}
