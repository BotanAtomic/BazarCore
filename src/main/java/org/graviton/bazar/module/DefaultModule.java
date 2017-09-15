package org.graviton.bazar.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.graviton.bazar.api.DatabaseProperties;
import org.graviton.bazar.utils.DatabasePropertiesFormatter;

import java.io.IOException;
import java.util.Properties;

public class DefaultModule extends AbstractModule {

    @Override
    protected void configure() {
        try {
            Properties properties = new Properties() {{
                load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            }};

            bind(Properties.class).annotatedWith(DatabaseProperties.class).toInstance(DatabasePropertiesFormatter.format((Properties) properties.clone()));

            Names.bindProperties(binder(), properties);

            install(new DatabaseModule());
            install(new NetworkModule());
        } catch (IOException e) {
            addError(e);
        }
    }
}
