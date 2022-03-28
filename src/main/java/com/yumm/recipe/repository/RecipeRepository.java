package com.yumm.recipe.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yumm.recipe.entities.YummyRecipe;

@Repository
public interface RecipeRepository extends JpaRepository<YummyRecipe, Integer> {

}
