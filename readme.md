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

##1: API should be able to process new User registration. 

##2: API should be able to process User logins. 

##3: API should be able to process the creation of a new recipe suggestion. 

##4: API should be able to retrieve all recipe suggestions. 

##5: API should be able to retrieve a recipe suggestion by its ID

##6: API should be able to delete a recipe suggestion identified by a recipe ID

##7: API should be able to update a recipe suggestion or main ingredient identified by the recipe ID

##8: API should be able to retrieve all recipe suggestions written by a particular user. 


