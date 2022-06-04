package com.whitbread.step_defs;

import com.whitbread.pages.BookingInformationPage;
import com.whitbread.pages.HomePage;
import com.whitbread.utilities.BrowserUtils;
import com.whitbread.utilities.ConfigurationReader;
import com.whitbread.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;



public class AmendBookingDefs {

    HomePage homePage = new HomePage();
    BookingInformationPage bookingPage = new BookingInformationPage();

    @Given("Load the page")
    public void load_the_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        homePage.acceptCookiesBtn.click();
    }

    @When("Click on manage bookings")
    public void click_on_manage_bookings() {
        homePage.manageBookingBtn.click();
    }

    @When("Load the booking details {string}, {string} and {string}")
    public void load_the_booking_details_and(String string, String string2, String string3) {
        homePage.bookingRefInput.click();
        homePage.bookingRefInput.sendKeys(string);
        homePage.bookingSurnameInput.click();
        homePage.bookingSurnameInput.sendKeys(string2);
        homePage.arrivalDate.click();
        BrowserUtils.waitForVisibility(homePage.nextMonth,5);
        homePage.nextMonth.click();
        homePage.nextMonth.click();
        if (string3.equals("21- Aug -22")){
            homePage.day21.click();
        }else if (string3.equals("25- Aug -22")){
            homePage.day25.click();
        }else {
            homePage.day28.click();
        }
        homePage.searchBtn.click();
    }

    @Then("Click on Amend Booking")
    public void click_on_Amend_Booking() {
        bookingPage.amendBookingBtn.click();
    }

    @Then("In the Amend Booking page, change the arrival date to different date")
    public void in_the_Amend_Booking_page_change_the_arrival_date_to_different_date(){
        bookingPage.arrivalDate.click();
        bookingPage.nextBtn.click();
        bookingPage.nextBtn.click();
        bookingPage.nextBtn.click();
        bookingPage.day15.click();
    }

    @Then("Capture the information in the rooms available")
    public void capture_the_information_in_the_rooms_available() throws IOException, InterruptedException {
        BrowserUtils.screemshotOfSpecificElement();
    }

    @Then("Write the information capture to a csv file")
    public void write_the_information_capture_to_a_csv_file() {
        BrowserUtils.writeCsv("test.jpeg");

    }


}
