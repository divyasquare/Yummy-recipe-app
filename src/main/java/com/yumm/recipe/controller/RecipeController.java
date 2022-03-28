package com.yumm.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yumm.recipe.entities.IngridentList;
import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.service.IngridentListService;
import com.yumm.recipe.service.RecipeService;





@Controller
public class RecipeController {

	static final int DEFAULT_PAGE_SIZE=3;
	private RecipeService recipeService;
	private IngridentListService ingridentListService;

	
	
	public RecipeController(final RecipeService recipeService,final IngridentListService ingridentListService)
	{
		this.recipeService=recipeService;
		this.ingridentListService=ingridentListService;

	}
	
	
	
	@GetMapping("/recipes/")
	public String index()
	{
		return "redirect:list";
	}
	
	@GetMapping("/recipes/list")
	public String getRecipes(final Model model,
		@RequestParam(value="page",defaultValue = "0")	final int pageNumber,
		@RequestParam(value="size",defaultValue = DEFAULT_PAGE_SIZE+"")	final int pageSize)
	{
		
		final Page<YummyRecipe>page= recipeService.getRecipe(pageNumber, pageSize);
		
		final int currentPageNum= page.getNumber();
		final int previousPageNum=page.hasPrevious()?currentPageNum - 1:-1;
		final int nextPageNum=page.hasNext() ? currentPageNum +1 :-1;

		
		model.addAttribute("recipes", page.getContent());
		model.addAttribute("previousPageNum", previousPageNum);
		model.addAttribute("nextPageNum", nextPageNum);

		
		return "recipes/list";
	}
	
	@GetMapping("/recipes/add")
	public String add(final Model model)
	{
		model.addAttribute("recipe", new YummyRecipe());
		return "recipes/add";
	}
	
	@GetMapping("/recipes/view")
	public String view(final Model model,@RequestParam final int id)
	{  
		
		
		Optional<YummyRecipe> recipe = recipeService.getRecipe(id);
		 
		
		
		List<IngridentList> itemList = ingridentListService.getIngridentList(id);
		
		
		model.addAttribute("recipe",recipe.isPresent() ? recipe.get() : new YummyRecipe());
		
		
		model.addAttribute("items",itemList);
		model.addAttribute("id",id);


		return "recipes/view";
	}
	@GetMapping("/recipes/edit")
	public String edit(final Model model,@RequestParam final int id)
	{
		Optional<YummyRecipe> recipe = recipeService.getRecipe(id);
		
		List<IngridentList> itemList = ingridentListService.getIngridentList(id);

		model.addAttribute("recipe",recipe.isPresent() ? recipe.get() : new YummyRecipe());
		model.addAttribute("items",itemList);
		model.addAttribute("id",id);

	
		
		return "recipes/edit";
	}
	
	
	@PostMapping("/recipes/save")
	public String save(final Model model,@ModelAttribute final YummyRecipe recipe ,final BindingResult error)
	{
		recipeService.save(recipe);	
		return "redirect:list";
	}
	
	
	@GetMapping("/recipes/delete")
	public String delete(final Model model, @RequestParam final int id)
	{
		
		Optional<YummyRecipe> recipe = recipeService.getRecipe(id);
		model.addAttribute("recipe",recipe.isPresent() ? recipe.get() : new YummyRecipe());

		model.addAttribute("id",id);
		return "recipes/delete";
	}
	
	
	@PostMapping("/recipes/delete")
    public String deletion(final Model model, @RequestParam final int recipeId) {

		
       ingridentListService.deleteIngridentList(recipeId);

		recipeService.delete(recipeId);

        return "redirect:list";
    }
	
	
}

