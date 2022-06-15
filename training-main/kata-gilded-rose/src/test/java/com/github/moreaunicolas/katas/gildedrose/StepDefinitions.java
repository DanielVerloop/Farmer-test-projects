package com.github.moreaunicolas.katas.gildedrose;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.presentation.StandardRepresentation.registerFormatterForType;

public class StepDefinitions {

    private GildedRose gildedRose;

    @Before
    public void setUp() {
        registerFormatterForType(Item.class, this::formatItem);
    }

    @Given("^I register the following items in the inventory$")
    public void i_register_the_following_items_in_the_inventory(List<Item> items) {
        assertThat(items).as("inventory items").isNotEmpty();
        gildedRose = new GildedRose(toArray(items));
    }

    @When("^(\\d+) day(?:s)? pass(?:es)?$")
    public void day_passes(int days) {
        assertThat(gildedRose).isNotNull();
        for (int i = 0; i < days; ++i) {
            gildedRose.updateQuality();
        }
    }

    @Then("^the inventory holds the following items$")
    public void the_inventory_holds_the_following_items(List<Item> items) {
        assertThat(gildedRose.items)
                .usingFieldByFieldElementComparator()
                .containsOnly(toArray(items));
    }

    private String formatItem(Object object) {
        Item item = (Item) object;
        return format("(%s, sellIn=%d, quality=%d)", item.name, item.sellIn, item.quality);
    }

    private Item[] toArray(List<Item> items) {
        return items.toArray(new Item[items.size()]);
    }

    @Given("^there exists an inventory$")
    public void thereExistsAnInventory() {
    }

    @And("^the inventory holds an item with properties <name>, <sellIn> and <quality>$")
    public void theInventoryHoldsAnItemWithPropertiesNameSellInAndQuality() {
    }

    @Then("^the inventory holds the item with <name>, <newSellIn>, <newQuality>$")
    public void theInventoryHoldsTheItemWithNameNewSellInNewQuality() {
    }
}
