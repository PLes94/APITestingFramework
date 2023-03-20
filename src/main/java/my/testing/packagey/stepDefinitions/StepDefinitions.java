package my.testing.packagey.stepDefinitions;

import my.testing.packagey.helper.TestContext;
import net.datafaker.Faker;
import org.picocontainer.annotations.Inject;

public abstract class StepDefinitions {
    @Inject
    protected TestContext testContext;
    protected Faker faker = new Faker();
}
