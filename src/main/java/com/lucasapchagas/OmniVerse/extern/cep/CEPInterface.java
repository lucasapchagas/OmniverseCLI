package com.lucasapchagas.OmniVerse.extern.cep;

import com.lucasapchagas.OmniVerse.common.BasicAddress;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPInterface {
    @GET("{cep}/json/")
    Call<BasicAddress> getAddressByCEP(@Path("cep") String cep);
}
