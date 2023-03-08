package Controller;

import Model.Recipe;
import Service.RecipeService;

import java.util.List;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RecipeController {
    RecipeService recipeService;

    public RecipeController(){

        this.recipeService = new RecipeService();
    }

    // create the endpoints to be used.
    public Javalin startAPI(){
        Javalin app = Javalin.create();
        // create the endpoints here
        return app;
    }

    //This handler will be working with adding new recipe to the database.
    private void postRecipeHandler(Context context){

    }

    // this handler will be working with retrieving all recipes in the database
    private void getAllRecipesHandler(Context context){

    }

    // this handler will be updating the Type column of a recipe by its id
    private void updateRecipeById(Context context){

    }

}
