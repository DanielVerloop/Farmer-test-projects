package com.github.moreaunicolas.katas.gildedrose;

class LegendaryItemUpdatePolicy implements UpdatePolicy {

    @Override
    public void update(Item unused) {
        // Legendary items never change!
    }
}
