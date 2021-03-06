package com.projeto.projetoapi.configs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class Deserialize extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        StringBuilder nomeProduto = new StringBuilder(jsonParser.getText());
        nomeProduto = nomeProduto.deleteCharAt(nomeProduto.length()-1);
        nomeProduto = nomeProduto.deleteCharAt(0);

        return nomeProduto.toString();
    }
}
