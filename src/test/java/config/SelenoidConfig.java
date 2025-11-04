package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Configuration
public class SelenoidConfig {

    @Bean(name = "chromeDriver")
    public WebDriver chromeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("121.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        return new RemoteWebDriver(new URL("http://host.docker.internal:4444/wd/hub"), capabilities);
    }

    @Bean(name = "chromeMobileDriver")
    public WebDriver chromeMobileDriver() throws MalformedURLException {
        DesiredCapabilities mobileCaps = new DesiredCapabilities();
        mobileCaps.setBrowserName("chrome");
        mobileCaps.setCapability("enableVNC", true);
        mobileCaps.setCapability("enableVideo", true);
        mobileCaps.setCapability("goog:chromeOptions", Map.of(
                "mobileEmulation", Map.of("deviceName", "iPhone X")
        ));
        return new RemoteWebDriver(new URL("http://host.docker.internal:4444/wd/hub"), mobileCaps);
    }
}
