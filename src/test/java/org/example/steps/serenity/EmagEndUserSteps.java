package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.EmagPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmagEndUserSteps {

    EmagPage emagPage;

    @Step
    public void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPage.lookForProducts();
    }

    @Step
    public void should_see_price(String price) {
        assertThat(emagPage.getProductPrice(), hasItem(containsString(price)));
    }

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void searchFor(String price) {
        enters(price);
        starts_search();
    }

    @Step
    public void recycledFiler(){
        emagPage.filterRecycled();
    }

}
