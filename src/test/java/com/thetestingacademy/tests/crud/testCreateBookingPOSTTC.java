package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingResponse;
import com.thetestingacademy.utlis.PropertyReader;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

// Wait i will send u the screenshot of my directory see that once
//i think it will come later beacuse my code is at starting phase
// not like that when u create test ng that time only automatic created
// how can it will be come
 // can u create new dummy project
// i will create new project with starting

public class
testCreateBookingPOSTTC extends BaseTest {
    @Test
    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("null")
    @TmsLink("null")
    @Owner("RAhul")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that POST request is working fine.")
    public void testVerifyCreateBookingPOST01() {
        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.CreatePayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(Integer.parseInt(PropertyReader.readKey("booking.post.statuscode.success")));


        //Default Rest Assured
        validatableResponse.body("booking.firstname", Matchers.equalTo(PropertyReader.readKey("booking.post.firstname")));


        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


         //assertj
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotZero();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(PropertyReader.readKey("booking.post.firstname"));



        // TestNG Assertions
        assertActions.verifyStatusCode(response, 200);



    }

}