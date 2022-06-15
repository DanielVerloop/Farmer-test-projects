Feature: Gilded Rose Inventory management

    Scenario Outline: items lose 1 quality each day while sell-in date is not past
        Given we have an item with properties <name>, <sellIn> and <quality>
        And There exists an inventory of Gilded Rose
        When 1 day passes
        Then the inventory holds the item with <name>, <newSellIn>, <newQuality>

        Examples:
            | name                   | sellIn | quality | newSellIn | newQuality |
            | +5 Dexterity Vest      | 10     | 20      | 9         | 19         |
            | Elixir of the Mongoose | 5      | 7       | 4         | 6          |

    Scenario Outline: items lose 2 quality each day after sell-in date
        Given there exists an inventory
        And the inventory holds an item with properties <name>, <sellIn> and <quality>
        When 1 day passes
        Then the inventory holds the item with <name>, <newSellIn>, <newQuality>

        Examples:
            | name                   | sellIn | quality | newSellIn | newQuality |
            | +5 Dexterity Vest      | 0      | 20      | -1        | 18         |
            | Elixir of the Mongoose | 0      | 7       | -1        | 5          |

#    Scenario: the quality of an item is never negative
#        Given I register the following items in the inventory
#            | name                   | sellIn | quality |
#            | +5 Dexterity Vest      | -1     | 0       |
#            | Elixir of the Mongoose | 1      | 0       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                   | sellIn | quality |
#            | +5 Dexterity Vest      | -2     | 0       |
#            | Elixir of the Mongoose | 0      | 0       |
#
#    Scenario: the quality of "Aged brie" increases over time
#        Given I register the following items in the inventory
#            | name      | sellIn | quality |
#            | Aged Brie | 1      | 3       |
#            | Aged Brie | 1      | 5       |
#            | Aged Brie | 0      | 5       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name      | sellIn | quality |
#            | Aged Brie | 0      | 4       |
#            | Aged Brie | 0      | 6       |
#            | Aged Brie | -1     | 7       |
#
#    Scenario: the quality of an item is never more than 50
#        Given I register the following items in the inventory
#            | name      | sellIn | quality |
#            | Aged Brie | 2      | 48      |
#            | Aged Brie | 2      | 49      |
#        When 2 days pass
#        Then the inventory holds the following items
#            | name      | sellIn | quality |
#            | Aged Brie | 0      | 50      |
#            | Aged Brie | 0      | 50      |
#
#    Scenario: Sulfuras never has to be sold nor decreases in quality
#        Given I register the following items in the inventory
#            | name                       | sellIn | quality |
#            | Sulfuras, Hand of Ragnaros | 0      | 80      |
#            | Sulfuras, Hand of Ragnaros | -1     | 80      |
#        When 2 days pass
#        Then the inventory holds the following items
#            | name                       | sellIn | quality |
#            | Sulfuras, Hand of Ragnaros | 0      | 80      |
#            | Sulfuras, Hand of Ragnaros | -1     | 80      |
#
#    Scenario: the quality of "Backstage passes" increases over time
#        Given I register the following items in the inventory
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 20     | 3       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 19     | 4       |
#
#    Scenario: the quality of "Backstage passes" increases by 2 starting 10 days before the concert
#        Given I register the following items in the inventory
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 11     | 3       |
#            | Backstage passes to a TAFKAL80ETC concert | 10     | 2       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 10     | 4       |
#            | Backstage passes to a TAFKAL80ETC concert | 9      | 4       |
#
#    Scenario: the quality of "Backstage passes" increases by 3 starting 5 days before the concert
#        Given I register the following items in the inventory
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 6      | 3       |
#            | Backstage passes to a TAFKAL80ETC concert | 5      | 2       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 5      | 5       |
#            | Backstage passes to a TAFKAL80ETC concert | 4      | 5       |
#
#    Scenario: the quality of "Backstage passes" drops to 0 after the concert
#        Given I register the following items in the inventory
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 1      | 1       |
#            | Backstage passes to a TAFKAL80ETC concert | 0      | 2       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                                      | sellIn | quality |
#            | Backstage passes to a TAFKAL80ETC concert | 0      | 4       |
#            | Backstage passes to a TAFKAL80ETC concert | -1     | 0       |
#
#    Scenario: the quality of "Conjured" items decreases twice as fast as normal
#        Given I register the following items in the inventory
#            | name                            | sellIn | quality |
#            | Conjured +5 Dexterity Vest      | 4      | 5       |
#            | Conjured Elixir of the Mongoose | 3      | 6       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                            | sellIn | quality |
#            | Conjured +5 Dexterity Vest      | 3      | 3       |
#            | Conjured Elixir of the Mongoose | 2      | 4       |
#
#    Scenario: the quality of "Conjured" items decreases after its sell-in date
#        Given I register the following items in the inventory
#            | name                            | sellIn | quality |
#            | Conjured +5 Dexterity Vest      | 0      | 5       |
#            | Conjured Elixir of the Mongoose | 0      | 6       |
#        When 1 day passes
#        Then the inventory holds the following items
#            | name                            | sellIn | quality |
#            | Conjured +5 Dexterity Vest      | -1     | 1       |
#            | Conjured Elixir of the Mongoose | -1     | 2       |
