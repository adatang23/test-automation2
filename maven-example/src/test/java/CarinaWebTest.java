import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import projects.fifth_topic.gui.components.SignInForm;
import projects.fifth_topic.gui.components.WhatsNewMainForm;
import projects.fifth_topic.gui.pages.desktop.*;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;
import static projects.fifth_topic.constant.ProjectConstant.*;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;


public class CarinaWebTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarinaWebTest.class);

    @Test(priority = 1)
    @MethodOwner(owner = "stang")
    public void verifyHomePagePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertTrue(homePage.getHeaderMenu().isLogoPresent(), "Logo is not present");
        sa.assertAll();
    }

    @Test(priority = 2)
    @MethodOwner(owner = "stang")
    public void verifySignInFormPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        sa.assertTrue(signInPage.getSignInForm().isSignInFormTitlePresent(), "SignIn Form is not visible");
        String signInFormTitle = signInPage.getSignInForm().getSignInFormTitle(SIGNIN_FORM_TITLE);
        sa.assertEquals(signInFormTitle, SIGNIN_FORM_TITLE, "Sign In Form Title does not match");
        sa.assertAll();
    }

    @Test(priority = 3)
    @MethodOwner(owner = "stang")
    public void verifySignInFormContent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        sa.assertTrue(signInPage.getSignInForm().isSignInEmailPresent(), "Email Field is not visible");
        sa.assertTrue(signInPage.getSignInForm().isSignInPasswordPresent(), "Password Field is not visible");
        sa.assertTrue(signInPage.getSignInForm().isSignInButtonPresent(), "SignIn Button is not visible");
        sa.assertAll();
    }

    @Test(priority = 4)
    @MethodOwner(owner = "stang")
    public void verifySignInFormErrorMsg() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertAll();
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.getSignInForm().signInButtonClickError();
        if (signInPage.getSignInForm().isEmailErrorMsgPresent() && signInPage.getSignInForm().isPasswordErrorMsgPresent()) {
            sa.assertEquals(signInPage.getSignInForm().getEmailErrorMsgText(), "This is a required field.");
            sa.assertEquals(signInPage.getSignInForm().getPasswordErrorMsgText(), "This is a required field.");
            sa.assertAll();
        }
    }

    /*
    @Test()
    public void verifyHomePageUserName() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        String email = "james.smith@gmail.com";
        String password = "12345678@js";
        String userName = "James Smith";
        homePage = signInPage.getSignInForm().signIn(email, password);
        sa.assertTrue(homePage.getHeaderMenu().getUserName().contains(userName), "User Name is incorrect");
        if (homePage.getHeaderMenu().isActionSwitchButtonPresent()) {
            homePage.getHeaderMenu().actionSwitchButtonClick();
            if (homePage.getHeaderMenu().isSignOutHyperLinkPresent()) {
                homePage.getHeaderMenu().signOut();
            }
        }
    }*/

    @Test(priority = 5)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        String createAccountFormTitle = createAccountPage.getCreateAccountForm().getCreateAccountTitleText(CREATE_ACCOUNT_FORM_TITLE);
        sa.assertEquals(createAccountFormTitle, CREATE_ACCOUNT_FORM_TITLE, "The title does not match");
        sa.assertAll();
    }

    @Test(priority = 6)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormContent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        sa.assertTrue(createAccountPage.getCreateAccountForm().isCreateAccountFirstNamePresent(), "First Name Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isCreateAccountLastNamePresent(), "Last Name Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isCreateAccountEmailPresent(), "Email Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isCreateAccountPasswordPresent(), "Password Field is not visible");
        sa.assertTrue(createAccountPage.getCreateAccountForm().isCreateAccountConfirmPasswordPresent(), "Confirm Password Field is not visible");
        sa.assertAll();
    }

    @Test(priority = 7)
    @MethodOwner(owner = "stang")
    public void verifyCreateAccountFormErrorMsg() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        sa.assertAll();
        CreateAccountPage createAccountPage = homePage.getHeaderMenu().clickCreateAccountButton();
        createAccountPage.getCreateAccountForm().createAccountButtonClick();
        if (createAccountPage.getCreateAccountForm().isCreateAccountFirstNameErrorMsgPresent()
                && createAccountPage.getCreateAccountForm().isCreateAccountPasswordErrorMsgPresent()) {
            sa.assertEquals(createAccountPage.getCreateAccountForm().getCreateAccountFirstNameErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getCreateAccountLastNameErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getCreateAccountEmailErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getCreateAccountPasswordErrorMsg(), "This is a required field.");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getPasswordStrength(), "No Password");
            sa.assertEquals(createAccountPage.getCreateAccountForm().getCreateAccountConfirmPasswordErrorMsg(), "This is a required field.");
            sa.assertAll();
        }
    }

    @Test(priority = 8)
    @MethodOwner(owner = "stang")
    public void verifyWhatsNewPagePresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LOGGER.info("magento software testing board page is opened");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.isPageOpened(), "Page is not opened");
        WhatsNewPage whatsNewPage = homePage.getHeaderMenu().clickWhatsNewButton();
        sa.assertTrue(whatsNewPage.getWhatsNewMainForm().isWhatsNewMainFormTitlePresent(), "Whats New Form Title is not visible");
        String whatsNewFormTitle = whatsNewPage.getWhatsNewMainForm().getWhatsNewMainFormTitleText(WHATS_NEW_FORM_TITLE);
        sa.assertEquals(whatsNewFormTitle, WHATS_NEW_FORM_TITLE, "What's New Form Title does not match");
        List<String> names = new ArrayList<>();
        names.add("Hoodies & Sweatshirts");
        names.add("Jackets");
        names.add("Tees");
        names.add("Bras & Tanks");
        names.add("Pants");
        names.add("Shorts");
        List<String> ItemsNames = whatsNewPage.getWhatsNewMainForm().getItemsNames();
        sa.assertEquals(ItemsNames, names, "The items' names are not same");
    }

    @Test(priority = 9)
    @MethodOwner(owner = "stang")
    public void verifyWomenPagePresent() {

    }

    @Test(priority = 10)
    @MethodOwner(owner = "stang")
    public void verifyMenPagePresent() {

    }

}
