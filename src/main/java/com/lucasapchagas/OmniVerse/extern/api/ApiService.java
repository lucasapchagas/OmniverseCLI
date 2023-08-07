package com.lucasapchagas.OmniVerse.extern.api;

import com.lucasapchagas.OmniVerse.Main;
import com.lucasapchagas.OmniVerse.common.BasicUser;
import com.lucasapchagas.OmniVerse.common.Constant;
import com.lucasapchagas.OmniVerse.common.NetworkErrorHandler;
import com.lucasapchagas.OmniVerse.common.User;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;

public class ApiService {
    private static String TAG = ApiService.class.getName();

    public static String baseUrl = "";

    private static Retrofit retrofit;
    private static ApiInterface apiService;

    public static void initialize(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.trim())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiInterface.class);
    }

    public static void getUserById(String id) {
        Call<User> call = apiService.getUserById(id.trim());

        try {
            Response<User> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                NetworkErrorHandler.handleErrorCode(TAG, response.code(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUserList() {
        Call<List<User>> call = apiService.getUserList();

        try {
            Response<List<User>> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                NetworkErrorHandler.handleErrorCode(TAG, response.code(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUserById(String id) {
        Call<User> call = apiService.deleteUserById(id.trim());

        try {
            Response<User> response = call.execute();

            if (response.isSuccessful()) {
               System.out.println(TAG + ": deleteUserById returns No Content. " +
                       "Check with `user list` or `user info <id>`. Code: " + response.code());
            } else {
                NetworkErrorHandler.handleErrorCode(TAG, response.code(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerUser() {
        String name, email, cep;

        System.out.print("Input user name: ");
        name = Main.scanner.nextLine().trim();

        System.out.print("Input user email: ");
        email = Main.scanner.nextLine().trim();

        System.out.print("Input user cep (valid cep, only digits): ");
        cep = Main.scanner.nextLine().trim();

        Call<User> call = apiService.registerUser(new BasicUser(null, name, email, cep));

        try {
            Response<User> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                NetworkErrorHandler.handleErrorCode(TAG, response.code(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUserById(String id) {
        String name= null , email= null , cep = null , option;

        System.out.print("Do you want to change user name? (YES / NO): ");
        option = Main.scanner.nextLine().trim().toLowerCase();

        if (option.equals(Constant.Args.OPTION_YES)) {
            name = Main.scanner.nextLine().trim();
        }

        System.out.print("Do you want to change user cep? (YES / NO): ");
        option = Main.scanner.nextLine().trim().toLowerCase();

        if (option.equals(Constant.Args.OPTION_YES)) {
            cep = Main.scanner.nextLine().trim();
        }

        Call<User> call = apiService.updateUser(new BasicUser(id, name, email, cep));

        try {
            Response<User> response = call.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                NetworkErrorHandler.handleErrorCode(TAG, response.code(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
