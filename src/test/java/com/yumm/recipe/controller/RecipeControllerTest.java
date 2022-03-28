package com.yumm.recipe.controller;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yumm.recipe.service.RecipeService;

@ExtendWith(SpringExtension.class)
class RecipeControllerTest {

	private MockMvc mvc;

    @MockBean
    private RecipeService service;
    
    
   
    

    private RecipeController fixture;

    @BeforeEach
    public void setUp() {
        fixture = new RecipeController(service,null);
        this.mvc = MockMvcBuilders.standaloneSetup(fixture).build();
    }

    @Test
    public void index_RedirectsToListView_WhenRecipeListIsAccessed() throws Exception {

        // @formatter:off
        mvc.perform(
                get("/recipes/")
           )
           .andExpect(status().is3xxRedirection())
           .andExpect(redirectedUrl("list"))
        ;
        // @formatter:on

        then(service).shouldHaveNoInteractions();
    }

}
