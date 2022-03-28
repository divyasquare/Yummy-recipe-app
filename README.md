# Yummy-recipe-app
Introduction
This is an assignment  web application which allow user to manage their favourite recipe.
Api to show all avalible recipe and the action to create ,update and delete recipe by user.
This is Spring Boot web application project.

# Technologies Used
* Java - 1.8.
* Spring Boot (Tomcat).
* Maven
* Spring Security
* Spring Data (Jpa & H2)
* Thymleaf
* Swagger

# IDE used
* Spring tool suit.

# Usage
Run the project through the IDE and head out to http://localhost:8080/recipes/   
Provide you login page .
Please fill these details.

* User name - welcome2022
* password - welcome

# Api Explanation

1- http://localhost:8080/recipes/list
This API will give you home page with all details about application come from in memory db.

2- http://localhost:8080/recipes/add
This API will give add   page to enter new  recipe detail .

3- http://localhost:8080/recipes/view/{recipeId}
This API will give all detail of  recipe, for this  we send the recipe id in the url.
if we send wrong id in url it will  show error page.

4- http://localhost:8080/recipes/delete/{recipeId}
This API will give delete  detail of  recipe, for this we send the recipe id in the url.
if we send wrong id in url it will  show error page.it will delete record from database.

5- http://localhost:8080/recipes/edit/{recipeId}
This API will edit  the details of an recipe. (update the recipe table)

6- http://localhost:8080/recipes/all/{recipeId}
This API will give you ingredient list for a perticular recipe

7- http://localhost:8080/recipes/saveList/{recipeId}/{name}
  This api  provide user to edit in recipe ingrident.
  This api will take recipe id and ingrident name and store data in to ingrident table.



# Project Structure








