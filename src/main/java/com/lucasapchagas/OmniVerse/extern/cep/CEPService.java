package com.lucasapchagas.OmniVerse.extern.cep;

import com.lucasapchagas.OmniVerse.common.BasicAddress;
import com.lucasapchagas.OmniVerse.common.Constant;
import com.lucasapchagas.OmniVerse.common.NetworkErrorHandler;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CEPService {
    private static String TAG = CEPService.class.getName();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.baseViacepURL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    private static CEPInterface cepInterface = retrofit.create(CEPInterface.class);

    public static void findAddressByCEP(String cep) {
        Call<BasicAddress> call = cepInterface.getAddressByCEP(cep.trim());

        try {
            Response<BasicAddress> response =
                    call.execute();

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
