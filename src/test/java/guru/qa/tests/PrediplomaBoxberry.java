package guru.qa.tests;

import guru.qa.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class PrediplomaBoxberry extends TestBase {
    @Test
    @Description("Проверка работы страницы Международной доставки")
    @DisplayName("Расчет международной доставки")
    void internationalTest() {
        step("Открываем сайт Boxberry", () -> {
            open("https://boxberry.ru/");
        });

        step("Перейти на страницу расчета международной доставки", () -> {
            $(byText("International delivery")).click();
        });

        step("Убедиться, что мы на верной странице", () -> {
            $(".slider__itemInfo").shouldHave(Condition.text("International delivery"));
        });
    }

    @Test
    @Description("Проверка работы страницы сотрудничества")
    @DisplayName("Заявка на сотрудничество")
    void contractTest() {
        step("Открываем сайт Boxberry", () -> {
            open("https://boxberry.ru");
        });

        step("Перейти на страницу сотрудничества", () -> {
            $(byText("Бизнес-партнерам")).click();
        });

        step("Убедиться, что мы на верной странице", () -> {
            $("div.slider").shouldHave(Condition.text("Откройте пункт выдачи\n" +
                    "заказов в своем городе"));
        });

        step("Перейти на форму заполнения заявки", () -> {
            $(".cta__button").click();
        });

        step("Убедиться, что мы на верной странице", () -> {
            $(".form__title").shouldHave(Condition.text(" Заявка на открытие пункта выдачи Boxberry "));
        });
    }

    @Test
    @Description("Проверка работы кнопки рассчета доставки и работы перехода на страницу интернет-магазинов")
    @DisplayName("Рассчет доставки")
    void OrderTest() {
        step("Открываем сайт Boxberry", () -> {
            open("https://boxberry.ru");
        });

        step("Принимаем Cookies", () -> {
            $(".cookie-info__btn").click();
        });

        step("Перейти на экран рассчета заказа", () -> {
            $$("#item-calculator").findBy(Condition.text("Рассчитать")).click();
        });

        step("Убедиться, что мы на верной странице", () -> {
            $("div.calculator__title").shouldHave(Condition.text("Калькулятор расчета доставки"));
        });

        step("Убедиться, что мы на верной экране", () -> {
            $(byName("calculator_pip")).shouldHave(Condition.text("Интернет-магазинам"));
        });

        step("Выбрать интернет-магазинам", () -> {
            $$(".nav__item").findBy(Condition.text("Интернет-магазинам")).click();
        });

        step("Убедиться, что мы на верной странице", () -> {
            $("#calculator").shouldHave(Condition.text("Расчёт и отправка посылок" +
                    " для интернет-магазинов"));
        });
    }

    @Test
    @Description("Проверка наличия Title на странице")
    @DisplayName("Заголовок страницы должен иметь заголовок")
    void titleTest() {
        step("Открываем страницу 'https://boxberry.ru'", () ->
            open("https://boxberry.ru"));

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
        step("Open url 'https://boxberry.ru'", () ->
            open("https://boxberry.ru"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}