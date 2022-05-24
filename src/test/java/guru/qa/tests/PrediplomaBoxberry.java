package guru.qa.tests;

import guru.qa.helpers.DriverUtils;
import guru.qa.pages.EStorePage;
import guru.qa.pages.CooperationPage;
import guru.qa.pages.InternationalDeliveryPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class PrediplomaBoxberry extends TestBase {
    @Test
    @Description("Проверка работы страницы Международной доставки")
    @DisplayName("Расчет международной доставки")
    void internationalPageTest() {
        step("Открываем сайт Boxberry", () -> {
           mainPage.openPage();
        });

        step("Переходим на страницу расчета международной доставки", () -> {
            mainPage.internationalDeliveryTransfer();
        });

        step("Проверяем, что мы на верной странице", () -> {
            intPage.internationalDeliveryPageCheck();
        });
    }

    @Test
    @Description("Проверка работы страницы сотрудничества")
    @DisplayName("Заявка на сотрудничество")
    void contractTest() {
        step("Открываем сайт Boxberry", () -> {
            mainPage.openPage();
        });

        step("Переходим на страницу сотрудничества", () -> {
            mainPage.cooperationTransfer();
        });

        step("Проверяем, что мы на верной странице", () -> {
            coopPage.coopPageTitleCheck();
        });

        step("Переходим на форму заполнения заявки", () -> {
            coopPage.applicationStart();
        });

        step("Проверяем, что мы на верной странице", () -> {
            coopPage.applicationFormCheck();
        });
    }

    @Test
    @Description("Проверка работы кнопки рассчета доставки и работы перехода на страницу интернет-магазинов")
    @DisplayName("Рассчет доставки")
    void OrderTest() {
        step("Открываем сайт Boxberry", () -> {
            mainPage.openPage();
        });

        step("Переходим на экран рассчета заказа", () -> {
            mainPage.itemCalculatorTransfer();
        });

        step("Проверяем, что мы на верной странице", () -> {
            mainPage.itemCalculatorScreenCheck();
        });

        step("Проверяем, что мы на верном экране", () -> {
            mainPage.itemCalculatorCheck();
        });

        step("Выбрать интернет-магазинам", () -> {
            mainPage.internetStoreTransfer();
        });

        step("Проверяем, что мы на верной странице", () -> {
            eStorePage.eStorePageCheck();
        });
    }

    @Test
    @Description("Проверка наличия Title на странице")
    @DisplayName("Заголовок страницы должен иметь заголовок")
    void titleTest() {
        step("Открываем сайт Boxberry", () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие Title", () -> {
            String expectedTitle = "Boxberry – служба доставки для интернет-магазинов и частных лиц.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Проверка наличия ошибок в консоли")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт Boxberry", () -> {
            mainPage.openPage();
        });

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}