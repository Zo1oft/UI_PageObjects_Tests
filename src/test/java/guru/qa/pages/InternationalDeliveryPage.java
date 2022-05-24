package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InternationalDeliveryPage {
    //locator

    SelenideElement
            sliderName = $(".slider__itemInfo");

    //action
    public void internationalDeliveryPageCheck() {
        sliderName.shouldHave(Condition.text("International delivery"));
    }
}
