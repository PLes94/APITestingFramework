package my.testing.packagey.testrunner;

import io.cucumber.core.cli.Main;

import java.util.stream.Stream;

public final class TestRunner {
    public static final String CUCUMBER_REPORTS_DIR = "cucumber-reports";
    public static final String CUCUMBER_JSON_RESULTS = CUCUMBER_REPORTS_DIR + "/cucumber-report.json";
    public static final String CUCUMBER_JUNIT_RESULTS = CUCUMBER_REPORTS_DIR + "/cucumber-junit.xml";
    private static final String[] defaultOptions = {
            "--glue", "my/testing/packagey/stepdefinitions",
            "--plugin", "json:" + CUCUMBER_JSON_RESULTS,
            "--plugin", "junit:" + CUCUMBER_JUNIT_RESULTS,
            "--plugin", "pretty",
            "--monochrome",
            // TODO: check why sending args in main() method does not work
            "classpath:features"
    };

    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("You have to pass arguments how to run the jar file.");
//            return;
//        }

        String[] cucumberOptions = Stream.of(defaultOptions, args).flatMap(Stream::of).toArray(String[]::new);
        Main.run(cucumberOptions);
    }
}
