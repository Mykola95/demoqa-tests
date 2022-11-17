package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.pages.RegistrationPage;
import demoqa.properties.Property;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";

        String login = Property.login();
        String password = Property.password();
        String url = Property.url();

        if (url != null) {
            Configuration.remote = "https://" + login + ":" + password + "@" + url;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.browser = Property.browser();
        Configuration.browserVersion = Property.browserVersion();
        Configuration.browserSize = Property.browserSize();

    }

//    @BeforeAll
//    static void configure() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//
//        Configuration.browserCapabilities = capabilities;
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = browser();
//        Configuration.browserVersion = browserVersion();
//        Configuration.browserSize = browserSize();
//        if (!remoteUrl().equals("")) {
//            Configuration.remote = remoteUrl() + "https://" + login() + ":" + password() + "@" + url();
//        }
//    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
//        closeWebDriver();

        Attach.attachAsText("Browser: ", Configuration.browser);
        Attach.attachAsText("Version: ", Configuration.browserVersion);
        Attach.attachAsText("Size ", Configuration.browserSize);
        Attach.attachAsText("Remote Url: ", Configuration.remote);
    }

}
