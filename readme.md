# Project: Recipe Suggestion API

## Background
This project is a backend for a hypothetical recipe suggestion website, where we must manage our users' accounts as well as any recipes that they submit to the application. In our hypothetical application, any user should be able to see all the recipe suggestions posted to the site, or they can see the suggestions posted by a particular user.  In either case, we require a backend which is able to deliver the data needed to disply this information as well as process actions like logins, registrations, recipe suggestion creations, recipe suggestion updates, and recipe suggestions deletions. 

## Database Tables
These tables have been created in a sql script, and a ConnctionUtil class that will run the sql script has been included. 

### Account
~~~
account_id integer primary key auto_increment,
username varchar(255),
password varchar(255)
~~~
### Recipe
~~~
recipe_id integer primary key auto_increment,
posted_by integer, 
recipe_name varchar(255),
main_ingredient varchar(25),
foreign key (posted_by) references Account(account_id)
~~~

# Requirements

### 1: API should be able to process new User registration. 

### 2: API should be able to process User logins. 

### 3: API should be able to process the creation of a new recipe suggestion. 

A user should be able to submit a new post on the endpoint POST localhost:8080/recipes. The request body will contain a JSON representation of a recipe, which should be persisted to the database, but will not contain a recipe_id. 

- The creation of the recipe will be successful if and only if the recipe_name is not blank, is under 255 characters, and posted_by refers to a real, existing user.  If successful, the response body should contain a JSON of the recipe, including its recipe_id. The response status should be 200, which is default. The new recipe should be persisted to the database. 
- If the creation of the recipe is not successful, the response status should be 400. (client error)

### 4: API should be able to retrieve all recipe suggestions. 

A user should be able to submit a GET request on the endpoint GET localhost:8080/recipes.

- The response body should contain a JSON representation of a list containing all recipe suggestions retrieved from the database. It is expected for the list to simply be empty if there are no recipe suggestions. The response status should always be 200, which is the default.

### 5: API should be able to retrieve a recipe suggestion by its ID

A user should be able to submit a GET request on the endpoint GET localhost:8080/recipes/{recipe_id}.

- The response body should contain a JSON representation of the recipe suggestion identified by the recipe_id. It is expected for the response body to simply be empty if there is no such recipe suggestion. The response status should always be 200, which is the default.


### 6: API should be able to delete a recipe suggestion identified by a recipe ID

A user should be able to submit a DELETE request on the endpoint DELETE localhost:8080/recipes/{recipe_id}.

- The deletion of an existing recipe suggestion should remove an existing recipe suggestion from the database. If the recipe suggestion existed, the response body should contain the now-deleted recipe suggestion. The response status should be 200, which is the default.
- If the recipe suggestion did not exist, the response status should be 200, but the response body should be empty.

### 7: API should be able to update a recipe suggestion or main ingredient identified by the recipe ID

A user should be able to submit a PATCH request on the endpoint PATCH localhost:8080/recipes/{recipe_id}. The request body should contain a new main_ingredient values to replace the main_ingredient identified by recipe_id. The request body can not be guaranteed to contain any other information.

- The update of a main_ingredient should be successful if and only if the recipe id already exists and the new main_ingredient is not blank and is not over 25 characters. If the update is successful, the response body should contain the full updated recipe (including recipe_id, posted_by, recipe_name, and main_ingredient), and the response status should be 200, which is the default. The recipe existing on the database should have the updated main_ingredient.
- If the update of the recipe is not successful for any reason, the response status should be 400. (Client error)
### 8: API should be able to retrieve all recipe suggestions written by a particular user. 

A user should be able to submit a GET request on the endpoint GET localhost:8080/accounts/{account_id}/recipes.

- The response body should contain a JSON representation of a list containing all recipes posted by a particular user, which is retrieved from the database. It is expected for the list to simply be empty if there are no recipes. The response status should always be 200, which is the default.


