package UiTests;

import UiTests.Pages.homePage;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class UiTests extends BaseClass {
    @Test
    public void useCase1() {
        open("/home");
        homePage homePage = new homePage();
        String nameLastname = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .clickEditInfoButton()
                .inputName(getName())
                .inputLastName(getLastname())
                .clickUpdate();
        Assert.assertEquals(nameLastname, getName() + " " + getLastname());
    }

    @Test
    public void useCase2() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .clickAddJobButton()
                .fillNewJob(getTitle(),getDescription(),getPrice());
    }

    @Test
    public void useCase3() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword());

    }

    @Test
    public void useCase4() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage();
    }
}
