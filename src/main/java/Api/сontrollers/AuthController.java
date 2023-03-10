package Api.сontrollers;

import entities.SignInData;
import entities.SignUpData;
import com.google.gson.*;
import okhttp3.*;


import java.io.IOException;

public class AuthController {
    public void signUp(SignUpData authSignup) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(authSignup), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
    }

    public String signIn(SignInData authSignIn) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(authSignIn), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        SignInData newUser = gson.fromJson(response.body().string(), SignInData.class);
        System.out.println(response.code());
        System.out.println(newUser);
        String token = newUser.getToken();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return token;
    }
}
