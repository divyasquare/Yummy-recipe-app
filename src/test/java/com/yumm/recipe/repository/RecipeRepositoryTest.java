package com.yumm.recipe.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.service.RecipeService;

import net.bytebuddy.NamingStrategy.SuffixingRandom.BaseNameResolver.ForGivenType;

@ExtendWith(SpringExtension.class)
@DataJpaTest
 public class RecipeRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecipeRepository recipeRepository;

	
	
    @Test
    public void save_StoresRecipe_WhenRecipeIsValid() {

        final YummyRecipe expected = new YummyRecipe();
        expected.setRecipeName("");
        expected.setRecipeType("");

        final YummyRecipe saved = recipeRepository.save(expected);

        final YummyRecipe actual = entityManager.find(YummyRecipe.class, saved.getRecipeId());

        assertThat(actual).isEqualTo(expected);
    }
	
}
