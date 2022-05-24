package guru.qa.tests;

import guru.qa.config.Project;
import guru.qa.helpers.AllureAttachments;
import guru.qa.helpers.DriverSettings;
import guru.qa.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.CooperationPage;
import guru.qa.pages.EStorePage;
import guru.qa.pages.InternationalDeliveryPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    MainPage mainPage = new MainPage();
    InternationalDeliveryPage intPage = new InternationalDeliveryPage();
    CooperationPage coopPage = new CooperationPage();
    EStorePage eStorePage = new EStorePage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
