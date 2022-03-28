package com.yumm.recipe.entities;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="RECIPIE_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YummyRecipe {

	
	@Id @GeneratedValue(strategy  = GenerationType.AUTO)
	//@Column(name="RECIPE_ID")
	private int recipeId;
	
   //	@Column(name="RECIPE_NAME")
	private String recipeName;
	
	//@Column(name="RECIPE_TYPE")
	private String recipeType;
	
	//@Column(name="RECIPE_FOR_PERSON)")
	private String servingFor;
	
	//@Column(name="RECIPE_CREATE_TIME")
	@UpdateTimestamp
	private ZonedDateTime createdTime;
	

	//@Column(name="RECIPE_PROCESS")
	@Lob
	private String cookingInstruction;
	
	//@Column(name="RECIPE_INGRIDENT_LIST")
	@OneToMany(mappedBy = "yummyRecipe")
    private List<IngridentList> ingridentList;

	public YummyRecipe(String recipeName, String recipeType, String servingFor, ZonedDateTime createdTime,
			String cookingInstruction) {
		super();
		this.recipeName = recipeName;
		this.recipeType = recipeType;
		this.servingFor = servingFor;
		this.createdTime = createdTime;
		this.cookingInstruction = cookingInstruction;
	}



	
	
}
