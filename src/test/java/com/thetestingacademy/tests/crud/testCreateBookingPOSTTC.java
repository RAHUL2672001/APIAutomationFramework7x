package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.assertEquals;


public class testCreateBookingPOSTTC extends BaseTest {
    @Test
//    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
//    @Issue("null")
//    @TmsLink("null")
//    @Owner("RAhul")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Verify that POST request is working fine.")
    public void testVerifyCreateBookingPOST01() {
        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.CreatePayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        //Default Rest Assured
        validatableResponse.body("booking.firstname", Matchers.equalTo(("James")));


        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


         //assertj
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotZero();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");



        // TestNG Assertions
        assertActions.verifyStatusCode(response, 200);


    }

}