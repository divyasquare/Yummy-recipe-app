package com.yumm.recipe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="INGRIDENT_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngridentList {

	@Id @GeneratedValue(strategy  = GenerationType.AUTO)
	private int id;
	private String name;
    private int recipeId;

	
	@ManyToOne()
    @JoinColumn(name = "recipeId", insertable= false,updatable = false)	
	    private YummyRecipe yummyRecipe;


	public IngridentList(String name, int recipeId, YummyRecipe yummyRecipe) {
		this.name = name;
		this.recipeId = recipeId;
		this.yummyRecipe = yummyRecipe;
	}

	

	
	
	



	
	
	
}
