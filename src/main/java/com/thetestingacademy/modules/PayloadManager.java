package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.*;

public class PayloadManager {
    //ser and Deser


    Gson gson;

    public String CreatePayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingsdates = new BookingDates();
        bookingsdates.setCheckin("2024-02-01");
        bookingsdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingsdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);
        return jsonStringpayload;
    }

    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;


    }

    //Get Token

    public String setAuthPayload(){
        //auth object -> json string
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("payload set to the ->" + jsonPayloadString);
        return jsonPayloadString;
    }
    public  String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }

    //get Booking ID
    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }
    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

}
