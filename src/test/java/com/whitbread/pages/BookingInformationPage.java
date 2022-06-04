package com.whitbread.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BookingInformationPage extends BasePage{


    @FindBy(css = "button[data-test-id='amend-button']")
    public WebElement amendBookingBtn;

    @FindBy(id = "arrivalDate")
    public WebElement arrivalDate;

    @FindBy(xpath = "//td[@data-day='15']/button")
    public WebElement day15;

    @FindBy(css = "button[class='pika-next']")
    public WebElement nextBtn;




}
