package org.graviton.bazar.module;

import com.google.inject.AbstractModule;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.repository.AnnounceRepository;

public class DatabaseModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(DatabaseService.class).asEagerSingleton();
        bind(AnnounceRepository.class).asEagerSingleton();
    }
}
