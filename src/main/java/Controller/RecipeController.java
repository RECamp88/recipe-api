package Controller;

import Model.Recipe;
import Service.RecipeService;

import io.javalin.Javalin; // update dependencies
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

}
