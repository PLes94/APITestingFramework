package my.testing.packagey.config;

import my.testing.packagey.helper.TestContext;
import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;

public final class CustomObjectFactory implements ObjectFactory {

    private final PicoFactory picoFactory = new PicoFactory();

    public CustomObjectFactory() {
        addClass(TestContext.class);
    }

    @Override
    public boolean addClass(Class<?> clazz) {
        return picoFactory.addClass(clazz);
    }

    //
    @Override
    public void start() {
        picoFactory.start();
    }

    //
    @Override
    public void stop() {
        picoFactory.stop();
    }

    //
    @Override
    public <T> T getInstance(Class<T> clazz) {
        return picoFactory.getInstance(clazz);
    }
}