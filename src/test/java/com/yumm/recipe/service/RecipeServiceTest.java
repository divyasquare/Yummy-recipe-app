package com.yumm.recipe.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yumm.recipe.entities.YummyRecipe;
import com.yumm.recipe.repository.RecipeRepository;



@ExtendWith(SpringExtension.class)
 public class RecipeServiceTest {

	@MockBean
    private RecipeRepository repository;

    private RecipeService fixture;

    @BeforeEach
    public void setUp() {
        fixture = new RecipeService(repository);
    }
    @Test
    public void getRecipes_ReturnsRecipes_WhenRecipesIsExists() {

        final int pageNumber = (int) (Math.random() * 100);
        final int pageSize = (int) (Math.random() * 100);

        final int totalRecords = (int) (Math.random() * 100);

        final YummyRecipe recipe1 = new YummyRecipe();
        final YummyRecipe recipe2 = new YummyRecipe();

        final List<YummyRecipe> recipes = Arrays.asList(recipe1, recipe2);

        final PageRequest page = PageRequest.of(pageNumber, pageSize);

        final Page<YummyRecipe> expected = new PageImpl<>(recipes, page, totalRecords);

        given(repository.findAll(page)).willReturn(expected);

        final Page<YummyRecipe> actual = fixture.getRecipe(pageNumber, pageSize);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual.getContent()).hasSameElementsAs(recipes);
        assertThat(actual.getPageable()).isEqualTo(page);

        then(repository).should().findAll(page);
        then(repository).shouldHaveNoMoreInteractions();
    }
    
    
    
    

    @Test
    public void getRecipe_ReturnsRecipe_WhenRecipeDoesNotExist() {

        final int id=1;

        final Optional<YummyRecipe> expected = Optional.empty();

        given(repository.findById(id)).willReturn(expected);

        final Optional<YummyRecipe> actual = fixture.getRecipe(id);

        assertThat(actual).isEqualTo(expected);

        then(repository).should().findById(id);
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void save_RecipeSaved_WhenRecipeRecordIsCreated() {

    	 final int id=1;

        final YummyRecipe expected = new YummyRecipe();
        expected.setRecipeName("");
        expected.setRecipeType("");

        given(repository.save(expected)).willAnswer(invocation -> {

            final YummyRecipe toSave = invocation.getArgument(0);

            toSave.setRecipeId(id);

            return toSave;
        });

        final YummyRecipe actual = fixture.save(expected);

        assertThat(actual).isEqualTo(expected);

        then(repository).should().save(expected);
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void delete_DeletesRecipe_WhenRecipeExists() {

        final int id = 1;

        willDoNothing().given(repository).deleteById(id);

        fixture.delete(id);

        then(repository).should().deleteById(id);
        then(repository).shouldHaveNoMoreInteractions();
    }

}
