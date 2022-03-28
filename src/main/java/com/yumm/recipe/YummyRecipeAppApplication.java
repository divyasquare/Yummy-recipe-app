package com.yumm.recipe;


import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.yumm.recipe.entities.IngridentList;

import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.repository.IngridentListRepo;
import com.yumm.recipe.repository.RecipeRepository;
import com.yumm.recipe.repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;




@SpringBootApplication
@EnableWebSecurity
@SecurityScheme(name = "recipeApi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@OpenAPIDefinition(info = @Info(title = "Recipe API", version = "2.0", description = "Recipe Information"))
public class YummyRecipeAppApplication {

	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	RecipeRepository   recipeRepository;
	
	@Autowired
	IngridentListRepo   ingridentListRepo;
	
	
	
	public static void main(String[] args) {
		 SpringApplication.run(YummyRecipeAppApplication.class, args);
		
		 
		
		
	}
	
	
	 @Bean
	    public CommandLineRunner mappingDemo(RecipeRepository   recipeRepository,
	    		IngridentListRepo   ingridentListRepo) {
	        return args -> {

	            // create a new recipe
	            YummyRecipe recipe1 = new YummyRecipe("Paneer Butter Masala Recipe","veg","4",ZonedDateTime.now()," 1. Soak 18 to 20 cashews in ⅓ cup hot water for 20 to 30 minutes.\n"
	            		+ " 2. When the cashews are soaking, you can prep the other ingredients like chopping tomatoes, chopping and preparing the ginger-garlic paste, slicing paneer etc\n"
	            		+ " 3. Crush 1-inch ginger + 3 to 4 medium-sized garlic to a paste in a mortar pestle to a semi-fine or fine paste. Keep aside. Don’t add any water while crushing ginger & garlic.\n"
	            		+ " 4. After 20 to 30 minutes, drain the water and add the soaked cashews in a blender or mixer-grinder. Also, add 2 to 3 tablespoons fresh water or as required.\n"
	            		+ " 5. Blend to a smooth paste without any tiny bits or chunks of cashews. Remove the cashew paste in a bowl and set aside.\n"
	            		+ " 6. In the same blender add 2 cups of diced or roughly chopped tomatoes. No need to blanch the tomatoes before blending.\n"
	            		+ "7. Blend to a smooth tomato puree. Set aside. Don’t add any water while blending the tomatoes.\n"
	            		+ "8. Heat a thick bottomed pan or a heavy pan. Keep the flame to a low or medium-low. Add 2 tablespoons butter OR 1 tablespoon oil + 1 or 2 tbsp butter in a pan.\n"
	            		+ "Adding oil prevents the butter from browning too quickly. You can even add 3 to 4 tablespoons butter for a rich buttery version. Both salted or unsalted butter can be added.\n"
	            		+ "9. Keep the flame to a low. Add 1 medium-sized tej patta (Indian bay leaf). Fry for 2 to 3 seconds or till the oil becomes fragrant from the aroma of the tej patta.\n"
	            		+ "10. Add the prepared crushed ginger-garlic or 1 teaspoon ready ginger-garlic paste\n"
	            		+ "11. Fry for some seconds till the raw aroma of the ginger-garlic disappears.\n"
	            		+ "12. Pour the prepared tomato puree. Be careful while adding the puree as it may splutter.\n"
	            		+ "13. Mix it very well with the butter.\n"
	            		+ "14. Begin to cook the tomato puree on a low to medium-low flame. Stir at intervals.\n"
	            		+ "15. The tomato puree mixture will start simmering.\n"
	            		+ "16. In case the tomato puree splutters too much while cooking then cover the pan partly with a lid or cover fully with a splatter lid (channi lid). \n"
	            		+ "the tomato puree might splutter if there is more water content in the tomatoes\n"
	            		+ "17. Do stir at intervals.\n"
	            		+ "18. Simmer the puree for 5 to 6 minutes.\n"
	            		+ "19. Then add 1 teaspoon Kashmiri red chilli powder or deghi mirch. You can even add ½ teaspoon Kashmiri red chilli powder or ¼ to ½ teaspoon of cayenne pepper or paprika\n"
	            		+ " or any other variety of red chilli powder.\n"
	            		+ "20. Mix well and continue to stir and sauté the tomato puree.\n"
	            		+ "21. Sauté till the butter starts leaving the sides of the pan and the entire tomato puree mixture comes together as a whole.\n"
	            		+ "This entire cooking and sautéing of the tomato puree take about 14 to 17 minutes on a low flame to medium-low flame.\n"
	            		+ "Time will vary depending on the thickness of the pan, size, the intensity of flame etc.\n"
	            		+ "22. Now add the prepared cashew paste.\n"
	            		+ "23. Mix the cashew paste very well with the cooked tomato puree and continue to stir and sauté on a low to medium-low flame. Stir non-stop after adding cashew paste.\n"
	            		+ "24. Sauté till the cashew paste is cooked and again the oil will start to leave the sides of the masala. The cashew will begin to cook fast. \n"
	            		+ "Approx 3 to 4 minutes on a low flame. So keep on stirring non-stop.\n"
	            		+ "25. Next add 1.5 cups water.\n"
	            		+ "26. Mix the water very well with the tomato-cashew makhani masala. If there are lumps of the tomato-cashew masala, then break with a spoon. You can even use a wired whisk for mixing.\n"
	            		+ "27. Let the curry simmer and come to a boil. Stir occasionally\n"
	            		+ "28. After 2 to 3 mins, add ginger julienne (about 1-inch ginger – cut in julienne (thin matchstick-like strips). Reserve a few for garnishing. The curry will also begin to thicken\n"
	            		+ "29. After 3 to 4 minutes, add 1 or 2 slit green chillies.\n"
	            		+ "30. Also add salt as per taste and ½ to 1 teaspoon sugar (optional). You can add sugar from ¼ tsp to 1 teaspoon or more depending on the sourness of the tomatoes.\n"
	            		+ "Sugar is optional and you can skip it too. If you add cream, then you will need to add less sugar.\n"
	            		+ "31. Mix very well and simmer for a minute.\n"
	            		+ "32. After the gravy thickens to your desired consistency, then add the paneer cubes (200 or 250 grams).\n"
	            		+ "33. Stir and mix the paneer cubes gently in the gravy. You can switch off the heat at this point.\n"
	            		+ "34. Now quickly add 1 teaspoon crushed kasuri methi leaves (dry fenugreek leaves) and 1 teaspoon garam masala to the gravy.\n"
	            		+ "35. Next add 2 to 3 tablespoons of low-fat cream or 1 to 2 tablespoons of heavy whipping cream.\n"
	            		+ "36. Stir gently but well and switch off the heat.\n"
	            		+ "37. Serve Paneer Butter Masala hot garnished with 1 to 2 tablespoons of chopped coriander leaves (cilantro) and the remaining ginger julienne. \n"
	            		+ "You can also drizzle some cream or dot with butter while serving");

	            YummyRecipe recipe2 = new YummyRecipe("Lamb lagoto","Non-Veg","3",ZonedDateTime.now(),"1-Place the whole unpeeled bulb of garlic into a pan of boiling water over a medium-low heat, then simmer for 15 to 20 minutes, or until softened.\n"
	            		+ "2-When the time's up, remove the garlic, drain on kitchen paper and allow to cool slightly. Squeeze each clove of garlic into a mortar and pound to a rough paste with a pestle.\n"
	            		+ "3-Heat 4 tablespoons of olive oil over a medium heat in a large saucepan and sauté the lamb for 5 to 7 minutes, or until browned on all sides.\n"
	            		+ "4-Meanwhile, peel and roughly chop the tomatoes (if using fresh). Stir the tomatoes into the pan with the tomato purée, oregano, mint and garlic. Season generously with sea salt and black pepper.\n"
	            		+ "5-Add enough water to just cover the stew and simmer for 1 hour 30 minutes to 2 hours, or until the lamb is tender and sauce has thickened.\n"
	            		+ "6-During the last 15 minutes, squeeze in and stir through the lemon juice. Delicious served with chips.");

	            YummyRecipe recipe3 = new YummyRecipe("Souvlaki (Wicked kebabs)","Non-Veg","8",ZonedDateTime.now(),"1- If using wooden skewers, cut 8 to fit your griddle pan and soak them in a tray of water to stop them burning.Put all your kebab ingredients into a bowl and use your clean hands to mix everything together really well. \n"
	            		+ "Cover with clingfilm, then pop into the fridge for 30 minutes, or longer if you want the flavours to get a bit more intense.\n"
	            		+ "\n"
	            		+ "2-Meanwhile, blacken the peppers directly over the flame of your hob, in a hot dry griddle pan or under a hot grill. Turn them every so often and when they look almost ruined, pop them into a bowl, \n"
	            		+ "cover with clingfilm and put to one side to steam for 5 minutes or so – this will help their skins to come off.\n"
	            		+ "\n"
	            		+ "3-Make your tzatziki by coarsely grating the cucumber into a sieve set up over a bowl. Add a few good pinches of sea salt, then use your hands to squeeze out as much water as you can. Pour the water away, then tip the cucumber \n"
	            		+ "into the empty bowl and add the yoghurt. Pound the garlic in a pestle and mortar with a good pinch of salt until you have a paste, and spoon that into the bowl with the cucumber. \n"
	            		+ "Add the dried mint and red wine vinegar and mix really well. Have a taste to make sure you’ve got the balance right, then put aside.\n"
	            		+ "\n"
	            		+ "4-Preheat a griddle pan or grill on a high heat. Thread the skewers through the marinated pork pieces, leaving little spaces between them so that the heat cooks everything evenly. \n"
	            		+ "Cook the kebabs on the screaming hot griddle or grill for about 8 to 10 minutes, turning occasionally until done on all sides. Warm your flatbreads in the oven or in a hot dry pan while your kebabs are cooking.\n"
	            		+ "\n"
	            		+ "5-Just before your kebabs are ready, peel and deseed your blackened peppers, then tear them into strips and put them into a bowl. Roll up your mint leaves, finely slice them and add to the bowl along with the dill. \n"
	            		+ "Add a few splashes of red wine vinegar, a pinch or two of salt and black pepper and a lug of extra virgin olive oil. Toss and mix together, then have a taste to check the balance of flavours. Cut your lemon into wedges.\n"
	            		+ "\n"
	            		+ "6-Put a dollop of tzatziki and the meat from one skewer on each warmed flatbread. Top with some of your pepper mixture, a drizzle of extra virgin olive oil and a good squeeze of lemon juice. Life doesn’t get much better.");

	            
	            
	            YummyRecipe recipe4 = new YummyRecipe("Greek Salad","Veg","8",ZonedDateTime.now(),"1-I think it’s quite nice to have different shapes and sizes in a salad, so cut your medium tomato into wedges, halve the cherry tomatoes and slice the beef tomato into large rounds. Put all the tomatoes into a large salad bowl. Slice the onion very finely so it’s wafer thin and add to the tomatoes. Scratch a fork down the sides of the cucumber so it leaves deep grooves in the skin, then cut it into thick slices. Deseed your pepper, slice it into rings and add them to the salad along with the cucumber.\n"
	            		+ "\n"
	            		+ "2- Roughly chop the dill and most of the mint leaves, reserving the smaller ones for garnish. Add the chopped herbs to the bowl of salad, then squeeze your handful of olives over so they season the vegetables, then drop them in.\n"
	            		+ "\n"
	            		+ "3- Add a pinch of sea salt, the vinegar and the extra virgin olive oil. Quickly toss everything together with your hands. The minute all those flavours start working with the veg is when the magic starts to happen. Have a taste, \n"
	            		+ "and adjust the flavours if need be.\n"
	            		+ "\n"
	            		+ "4-To serve, pop the block of feta right on the top of the salad. Sprinkle the oregano over the top along with the reserved mint leaves, drizzle with extra virgin olive oil and take it straight to the table. \n"
	            		+ "It’s confident and scruffy with a bit of attitude. Delicious.\n"
	            		+ "\n"
	            		+ "PS I’ve been known to pop leftover Greek salad into a liquidizer with a splash of extra virgin olive oil and a few ice cubes, then blitz it up to a smooth consistency so it's basically a Greek gazpacho. \n"
	            		+ "It’s not a classic thing to do, but it is very delicious, not to mention a great way of using up leftovers!");
	            
	            // save the recipe
	            recipeRepository.save(recipe1);
	            recipeRepository.save(recipe2);
	            recipeRepository.save(recipe3);
	            recipeRepository.save(recipe4);



	            // create and save Ingridents records
	            ingridentListRepo.save(new IngridentList("18 to 20 whole cashews",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "⅓ cup hot water for soaking cashews",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "2 cups diced tomatoes or 300 grams tomatoes or 4 to 5 medium size – pureed",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "1 inch ginger",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "3 to 4 medium -sized garlic cloves",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "1 tej patta (Indian bay leaf) – optional\n"+ "",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "	½ to 1 teaspoon kashmiri red chili powder or deghi mirch or ¼ to ½ teaspoon cayenne pepper or paprika\n"+ "",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "1.5 cups water or add as required",1, recipe1));
	            ingridentListRepo.save(new IngridentList( " 1 inch ginger – julienned, reserve a few for garnish",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "	1 or 2 green chili – slit, reserve a few for garnish\n"
	            		+ "",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "200 to 250 grams Paneer (Indian cottage cheese) – cubed or diced",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "1 teaspoon kasuri methi (dry fenugreek leaves) – optional",1, recipe1));
	            ingridentListRepo.save(new IngridentList( " ½ to 1 teaspoon garam masala or tandoori masala",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "	 2 to 3 tablespoons low-fat cream or half & half or 1 to 2 tablespoons heavy cream – optional\n"
	            	+ "",1, recipe1));
	            ingridentListRepo.save(new IngridentList( "	 1 to 2 tablespoons chopped coriander leaves (cilantro ) – optional\n"
	            		+ "",1, recipe1));

	            
	            
	            ingridentListRepo.save(new IngridentList("1 bulb of garlic",2, recipe2));
	            ingridentListRepo.save(new IngridentList("2 kg boned leg of lamb , trimmed and cut into 5cm pieces",2, recipe2));
	            ingridentListRepo.save(new IngridentList("6 plum tomatoes , or 1 x 400g tin of chopped tomatoes",2, recipe2));
	            ingridentListRepo.save(new IngridentList("1 tablespoon tomato purée",2, recipe2));
	            ingridentListRepo.save(new IngridentList("1 teaspoon dried oregano",2, recipe2));

	            
	            
	            ingridentListRepo.save(new IngridentList("3 sweet pointed peppers",3, recipe3));
	            ingridentListRepo.save(new IngridentList("8 flatbreads , to serve",3, recipe3));
	            ingridentListRepo.save(new IngridentList("4 sprigs fresh mint , leaves picked",3, recipe3));
	            ingridentListRepo.save(new IngridentList("1 small bunch fresh dill , chopped (stalks and all)",3, recipe3));
	            ingridentListRepo.save(new IngridentList("red wine vinegar",3, recipe3));
	            ingridentListRepo.save(new IngridentList("Greek extra virgin olive oil",3, recipe3));
	            ingridentListRepo.save(new IngridentList("800 g higher-welfare leg of pork , shin if you can get it, cut into 2cm chunks",3, recipe3));
	            ingridentListRepo.save(new IngridentList("1 tablespoon dried mint",3, recipe3));

	            
	            ingridentListRepo.save(new IngridentList("1 medium ripe tomato",4, recipe4));
	            ingridentListRepo.save(new IngridentList("200 g ripe cherry tomatoes",4, recipe4));
	            ingridentListRepo.save(new IngridentList("1 medium red onion , peeled",4, recipe4));
	            ingridentListRepo.save(new IngridentList("1 cucumber",4, recipe4));
	            ingridentListRepo.save(new IngridentList("1 green pepper",4, recipe4));
	            ingridentListRepo.save(new IngridentList("1 handful fresh mint leaves",4, recipe4));
	            ingridentListRepo.save(new IngridentList("200 g block feta cheese",4, recipe4));


	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	           
	            
	            
	           
	            
	            
	           
	        };
	    }
	
	
	

	
	
	
	
	
	
	 
	
	
		
}
