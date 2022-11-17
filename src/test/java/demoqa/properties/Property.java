package demoqa.properties;

public class Property {

    public static String login() {
        return System.getProperty("login", "user1");
    }

    public static String password() {
        return System.getProperty("password", "1234");
    }

    public static String url() {
        return System.getProperty("url", "selenoid.autotests.cloud/wd/hub");
    }

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static String browserVersion() {
        return System.getProperty("browserVersion", "100");
    }

    public static String browserSize() {
        return System.getProperty("browserSize", "1920x1080");
    }

    public static String remoteUrl() {
        return System.getProperty("remoteUrl", "");
    }
}
