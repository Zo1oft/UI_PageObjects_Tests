package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CooperationPage {
    
    //locators
    SelenideElement
            cooperationTitle = $("div.slider"),
            applicationButton = $(".cta__button"),
            applicationFormStart = $(".form__title");

    //actions
    public void coopPageTitleCheck() {
        cooperationTitle.shouldHave(Condition.text("Откройте пункт выдачи заказов в своем городе"));
    }

    public void applicationStart() {
        applicationButton.click();
    }

    public void applicationFormCheck() {
        applicationFormStart.shouldHave(Condition.text("Заявка на открытие пункта выдачи Boxberry"));
    }

}
