package com.example.api.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetSteps {

    Response testPet;

    @Before
    public void setup(){
        baseURI = "https://petstore.swagger.io/v2";

    }
    private Map<String, Object> buildPetJson(Integer id, String name, boolean includeAllFields) {
        Map<String, Object> jsonPet = new HashMap<>();
        jsonPet.put("id", id);
        jsonPet.put("name", name);

        if (includeAllFields) {
            Map<String, Object> category = new HashMap<>();
            category.put("id", 1);
            category.put("name", "Cachorros");

            Map<String, Object> tag = new HashMap<>();
            tag.put("id", 1);
            tag.put("name", "vacina");

            List<Map<String, Object>> tags = new ArrayList<>();
            tags.add(tag);

            List<String> photoUrls = new ArrayList<>();
            photoUrls.add("http://imagem.com/foto1.jpg");

            jsonPet.put("category", category);
            jsonPet.put("photoUrls", photoUrls);
            jsonPet.put("tags", tags);
            jsonPet.put("status", "available");
        }

        return jsonPet;
    }
    //Teste passando o valor 1 direto como parametro no GET
    @Given("envio uma requisicao com idPet")
    public void solicitoUmaRequisicaoComIdPet() {

        testPet = given()
                .header("Accept", "application/json")
                .get("/pet/1");

        // Imprimir o corpo da resposta
        System.out.println("Corpo da resposta:");
        System.out.println(testPet.prettyPrint());

    }

    @Then("aguardo json com PET consultado")
    public void aguardoJsonComPETConsultado() {

        Assert.assertEquals(200, testPet.statusCode());
        Assert.assertEquals("doggie", testPet.path("name"));
        Assert.assertEquals("available", testPet.path("status"));
    }

    //Teste passando o valor parametrizado no GET
    @Given("envio uma requisicao com idPet invalido")
    public void envioUmaRequisicaoComIdPetInvalido() {

        testPet = given()
                .header("Accept", "application/json")
                .pathParam("idPet", 1000)
                .get("/pet/{idPet}");

        // Imprimir o corpo da resposta
        System.out.println("Corpo da resposta:");
        System.out.println(testPet.prettyPrint());
    }

    @Then("aguardo json mensagem de nao encontrato")
    public void aguardoJsonMensagemDeNaoEncontrato() {
        Assert.assertEquals(404, testPet.statusCode());
        Assert.assertEquals("error", testPet.path("type"));
        Assert.assertEquals("Pet not found", testPet.path("message"));
    }


    @Given("envio uma requisicao com {int} e {string}")
    public void envioUmaRequisicaoComIdPetEName(Integer idPet, String name) {

        testPet = given()
                .contentType(ContentType.JSON)
                .body(buildPetJson(idPet, name, true))
                .post("/pet")
                .then()
                .log().all()
                .extract().response();

    }

    @Then("aguardo json com PET cadastrado {int} e {string}")
    public void aguardoJsonComPETCadastrado(Integer idPet, String name) {
        Assert.assertEquals(200, testPet.statusCode());
        Assert.assertEquals(idPet, testPet.path("id"));
        Assert.assertEquals(name, testPet.path("name"));
    }

    @Given("envio uma requisicao para alterar pet com {int} e {string}")
    public void envioUmaRequisicaoParaAlerarPetComIdPetEName(Integer idPet, String name) {

        testPet = given()
                .contentType(ContentType.JSON)
                .body(buildPetJson(idPet, name, false))
                .put("/pet")
                .then()
                .log().all()
                .extract().response();

    }

    @Then("aguardo json com PET alterado {int} e {string}")
    public void aguardoJsonComPETAlteradoIdPetEName(Integer idPet, String name) {
        Assert.assertEquals(200, testPet.statusCode());
        Assert.assertEquals(idPet, testPet.path("id"));
        Assert.assertEquals(name, testPet.path("name"));
    }
}