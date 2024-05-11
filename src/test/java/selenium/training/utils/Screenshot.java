package selenium.training.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    public static void getScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

        String directory = "screenshots/";
        createDirectoryIfNotExists(directory);

        String screenshotPath = directory + testName + ".png";
        Path path = Paths.get(screenshotPath);
        try {
            Files.write(path, screenshotBytes);
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectoryIfNotExists(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
