package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EStorePage {
    //locator
    SelenideElement
            eStoreCalculator = $("#calculator");

    //action

    public void eStorePageCheck() {
        eStoreCalculator.shouldHave(Condition.text("Расчёт и отправка посылок" +
                " для интернет-магазинов"));;
    }
}
