package UiTests;

import UiTests.Pages.HomePage;
import UiTests.Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UiTests extends BaseClass {
    @Test
    public void useCase1() {
        open("/home");
        HomePage homePage = new HomePage();
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
        HomePage homePage = new HomePage();
        String nameLastname = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .clickAddJobButton()
                .fillNewJob(getTitle(),getDescription(),getPrice());
        ProfilePage profilePage = new ProfilePage();
        Assert.assertEquals(profilePage.getNewJobTitle().getText(),nameLastname);
    }

    @Test
    public void useCase3() {
        open("/home");
        HomePage homePage = new HomePage();
        homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .openJobOffer()
                .addComment();
    }

    @Test
    public void useCase4() {
        open("/home");
        HomePage homePage = new HomePage();
        homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage();
    }
}
