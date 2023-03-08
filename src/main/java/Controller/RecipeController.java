package Controller;

import Model.Account;
import Model.Recipe;
import Service.AccountService;
import Service.RecipeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin; // update dependencies
import io.javalin.http.Context;

public class RecipeController {
    RecipeService recipeService;
    AccountService accountService;
    public RecipeController(){
        this.accountService = new AccountService();
        this.recipeService = new RecipeService();
    }

    // create the endpoints to be used.
    public Javalin startAPI(){
        Javalin app = Javalin.create();
        // create the endpoints here
        app.post("/register", this::postAccountHandler);
        app.post("/login", this::postLoginHandler);


        return app;
    }
    private void postAccountHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account addedAccount = accountService.createAccount(account);
        if(addedAccount!=null){
            ctx.json(mapper.writeValueAsString(addedAccount));

        }else{
            ctx.status(400);
        }

    }


    private void postLoginHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account loginedAccount = accountService.loginAccount(account);
        if(loginedAccount!=null){
            ctx.json(mapper.writeValueAsString(loginedAccount));

        }else{
            ctx.status(401);
        }
    }

}
