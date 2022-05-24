package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    //locators
    SelenideElement
            itemCalculator = $$("#item-calculator").findBy(Condition.text("Рассчитать")),
            itemCalculatorTitle = $("div.calculator__title"),
            internetStoreCalculator = $(byName("calculator_pip")),
            internetStoreCalculatorButton = $(".nav__item"),
            partershipDeliveryButton = $(byText("Бизнес-партнерам")),
            acceptingcookies = $(".cookie-info__btn"),
            internationalDeliveryNavigationButton = $(byText("International delivery"));

    //actions
    public MainPage openPage() {
        open("https://boxberry.ru/");
        return this;
    }

    public void cooperationTransfer() {
        partershipDeliveryButton.click();

    }

    public void itemCalculatorTransfer() {
        itemCalculator.click();

    }

    public void itemCalculatorScreenCheck() {
        itemCalculatorTitle.shouldHave(Condition.text("Калькулятор расчета доставки"));

    }

    public void itemCalculatorCheck() {
        internetStoreCalculator.shouldHave(Condition.text("Интернет-магазинам"));

    }

    public void internetStoreTransfer() {
        internetStoreCalculatorButton.click();

    }

    public void internationalDeliveryTransfer() {
        internationalDeliveryNavigationButton.click();

    }

}
