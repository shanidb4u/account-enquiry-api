package com.myorg.accountenquiry.integration;

import com.myorg.accountenquiry.domain.Account;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    public void getAccounts() {
        Account[] accounts = RestAssured.given()
                .header("userId", "anzuser")
                .get(uri + "/accounts")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Account[].class);

        assertThat(accounts.length).isEqualTo(2);
        assertThat(accounts[0].getAccountId()).isEqualTo(1001);
    }

    @Test
    public void getAccounts_NoAccounts() {
        Account[] accounts = RestAssured.given()
                .header("userId", "noaccountuser")
                .get(uri + "/accounts")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Account[].class);

        assertThat(accounts.length).isEqualTo(0);
    }

    @Test
    public void getAccounts_400Error_WhenUserIdHeaderNotPassed() {
        RestAssured.given()
                .get(uri + "/accounts")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }


}
