package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EmagEndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/emagPrices.csv")
public class EmagSearchByPrice {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro")
    public Pages pages;

    public String name;
    public String price;
    public String correct;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagEndUserSteps endUser;

    @Issue("#EMAG-1")
    @Test
    public void searchEmagByProduct() {
        String prodName = getName();
        if (prodName.equals("Samsung Galaxy S20 Plus") || prodName.equals("Nespresso Mini")) {
            endUser.is_the_home_page();
            endUser.searchFor(prodName);
            endUser.should_see_price(getPrice());
        }
    }

    @Issue("#EMAG-2")
    @Test
    public void searchEmagByProductResigilate() {
        String prodName = getName();
        if(prodName.equals("Allview Allbook H cu procesor Intel Celeron N4000") || prodName.equals("Huawei P40")){
            endUser.is_the_home_page();
           // endUser.looks_for(prodName);
            endUser.recycledFiler();
            endUser.should_see_price(getPrice());
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getCorrect() {
        return correct;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
