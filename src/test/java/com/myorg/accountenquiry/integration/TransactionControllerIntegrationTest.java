package com.myorg.accountenquiry.integration;

import com.myorg.accountenquiry.domain.Transaction;
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
public class TransactionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    public void getTransactions() {
        Transaction[] transactions = RestAssured.get(uri + "/account/123123345/transactions").then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Transaction[].class);

        assertThat(transactions.length).isEqualTo(2);
        assertThat(transactions[0].getTransactionId()).isEqualTo(5001);
    }

    @Test
    public void getTransactions_NoTransactionExist() {
        Transaction[] transactions = RestAssured.get(uri + "/account/2222/transactions").then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Transaction[].class);
        assertThat(transactions.length).isEqualTo(0);
    }


}
