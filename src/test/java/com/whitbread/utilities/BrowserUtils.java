package com.whitbread.utilities;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BrowserUtils {

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void screemshotOfSpecificElement() throws IOException {
        WebElement confirmInfo = Driver.get().findElement(By.cssSelector("div[data-ng-if='availabilitySuccess && !availabilityCheckInProgress']"));
        File screenshot =  ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = confirmInfo.getLocation();
        int confirmInfoWidth = confirmInfo.getSize().getWidth();
        int confirmInfoHight = confirmInfo.getSize().getHeight();
        BufferedImage realScreenShot = fullImg.getSubimage(point.getX(),point.getY(),confirmInfoWidth,confirmInfoHight);
        ImageIO.write(realScreenShot,"png",screenshot);
        FileUtils.copyFile(screenshot,new File("test.jpeg"));
    }

    public static void writeAndReadCsv(String filepath) {
        File file = new File(filepath);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            String[] header = {Driver.get().findElement(By.xpath("//h3[@class='wb-notification-text']")).getText()};
            writer.writeNext(header);
            String[] data = {Driver.get().findElement(By.xpath("//div[@class='wb-notification-text font-size--s ng-binding']/p")).getText()};
            writer.writeNext(data);
            writer.close();
            FileReader filereader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
