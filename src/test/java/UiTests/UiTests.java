package UiTests;

import UiTests.Pages.homePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UiTests extends BaseClass {
    @Test
    public void useCase1() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign();
    }

    @Test
    public void useCase2() {

    }

    @Test
    public void useCase3() {

    }

    @Test
    public void useCase4() {

    }
}
