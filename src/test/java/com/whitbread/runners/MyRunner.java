package com.whitbread.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/whitbread/step_defs",
        dryRun = false,
        tags = ""
)

public class MyRunner {
}
