package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement iconProfile = $(".mat-focus-indicator.mat-menu-trigger");
    private SelenideElement profile = $(By.xpath("//*[.='Profile']"));

    private SelenideElement jobOffer= $(By.xpath("(//button)[2]"));


    public MainPage clickProfileIcon() {
        iconProfile.click();
        return new MainPage();
    }

    public ProfilePage clicklinkText() {
        profile.click();
        return new ProfilePage();
    }

    public ProfilePage goToProfilePage() {
        clickProfileIcon();
        clicklinkText();
        return new ProfilePage();
    }
    public JobPages openJobOffer(){
        jobOffer.click();
        return new JobPages();
    }

}