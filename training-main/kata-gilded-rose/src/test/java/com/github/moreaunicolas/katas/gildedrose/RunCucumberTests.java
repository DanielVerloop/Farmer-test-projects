package com.github.moreaunicolas.katas.gildedrose;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/", tags = "~@ignore"
)
@RunWith(Cucumber.class)
public class RunCucumberTests {
}
