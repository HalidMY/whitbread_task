package com.whitbread.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "accept-all-cookies-button")
    public WebElement acceptCookiesBtn;

    @FindBy(id = "find-a-booking")
    public WebElement manageBookingBtn;

    @FindBy(id = "booking-reference-input")
    public WebElement bookingRefInput;

    @FindBy(id = "booking-surname-input")
    public WebElement bookingSurnameInput;

    @FindBy(xpath = "(//input[@readonly='readonly'])[3]")
    public WebElement arrivalDate;

    @FindBy(xpath = "(//img[@class='calendar_arrow-right'])[2]")
    public WebElement nextMonth;

    @FindBy(id = "find-booking-form-button")
    public WebElement searchBtn;

    @FindBy(id = "date-picker-day-2182022")
    public WebElement day21;

    @FindBy(id = "date-picker-day-2582022")
    public WebElement day25;

    @FindBy(id = "date-picker-day-2882022")
    public WebElement day28;



}
