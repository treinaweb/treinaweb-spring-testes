package br.com.treinaweb.twjobs.api.candidates.controllers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import br.com.treinaweb.twjobs.testutils.factories.CandidateRequestFactory;
import br.com.treinaweb.twjobs.testutils.factories.CandidateResponseFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/candidates/candidates-insert.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/candidates/candidates-delete.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class CandidateRestControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.basePath = "/api/candidates";
        RestAssured.port = port;
    }

    @Test
    @Tags({@Tag("controller"), @Tag("slow")})
    @DisplayName("when POST /api/candidates with valid candidate then returns 201")
    void whenPostCandidatesWithValidBodyThenRetuns201() {
        var body = CandidateRequestFactory.createJaneDoe();
        var expected = CandidateResponseFactory.createJaneDoe();

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post()
        .then()
            .statusCode(201)
            .body(
                "id", notNullValue(),
                "name", equalTo(expected.getName()),
                "description", equalTo(expected.getDescription()),
                "email", equalTo(expected.getEmail()),
                "linkedin", equalTo(expected.getLinkedin()),
                "github", equalTo(expected.getGithub())
            );
    }
    
    @Test
    @Tags({@Tag("controller"), @Tag("slow")})
    @DisplayName("when POST /api/candidates with duplicated email then returns 409")
    void whenPostCandidatesWithDuplicatedEmailThenRetuns409() {
        var body = CandidateRequestFactory.createJaneDoe();
        body.setEmail("john@mail.com");

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post()
        .then()
            .statusCode(409);
    }
    
    @Test
    @Tags({@Tag("controller"), @Tag("slow")})
    @DisplayName("when POST /api/candidates with duplicated linkedin then returns 409")
    void whenPostCandidatesWithDuplicatedLinkedInThenRetuns409() {
        var body = CandidateRequestFactory.createJaneDoe();
        body.setLinkedin("john-doe");

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post()
        .then()
            .statusCode(409);
    }
    
    @Test
    @Tags({@Tag("controller"), @Tag("slow")})
    @DisplayName("when POST /api/candidates with duplicated github then returns 409")
    void whenPostCandidatesWithDuplicatedGitHubThenRetuns409() {
        var body = CandidateRequestFactory.createJaneDoe();
        body.setGithub("john-doe");

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post()
        .then()
            .statusCode(409);
    }

}
