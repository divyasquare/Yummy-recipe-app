package com.yumm.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yumm.recipe.entities.IngridentList;
import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.service.IngridentListService;
import com.yumm.recipe.service.RecipeService;

@Controller
public class IngridentController {

	
	private RecipeService recipeService;

	private IngridentListService ingridentListService;

	public IngridentController(final RecipeService recipeService,final IngridentListService ingridentListService)
	{
		this.recipeService=recipeService;
		this.ingridentListService=ingridentListService;

	}
	
	@GetMapping("recipes/all")
	public String getIngridentList(final Model model,@RequestParam final int id)
	{
		
		
		Optional<YummyRecipe> recipe = recipeService.getRecipe(id);
		
		List<IngridentList> itemList = ingridentListService.getIngridentList(id);
		
		
		
		model.addAttribute("recipe",recipe.isPresent() ? recipe.get() : new YummyRecipe());
		model.addAttribute("items", itemList);
		
		model.addAttribute("id", id);
		
		return "recipes/item";
	}
	
	@PostMapping("recipes/saveList")
	public String saveIngridentList(final Model model,@RequestParam("name") String name,@RequestParam("id") int id)
	{
		
  
		IngridentList ingridentName= new IngridentList();
		ingridentName.setRecipeId(id);
		ingridentName.setName(name);
		
		 ingridentListService.save(ingridentName);
		 
			model.addAttribute("id", id);

		
		return "redirect:list";
	}
}
