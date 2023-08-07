package com.lucasapchagas.OmniVerse.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
        @JsonProperty("cep") String cep ,
        @JsonProperty("place") String place,
        @JsonProperty("complement") String complement,
        @JsonProperty("neighborhood") String neighborhood,
        @JsonProperty("locality") String locality,
        @JsonProperty("uf") String uf){
}
