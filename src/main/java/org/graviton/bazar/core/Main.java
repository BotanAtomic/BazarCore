package org.graviton.bazar.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.module.DefaultModule;
import org.graviton.bazar.network.ServerService;
import org.graviton.bazar.repository.AnnounceRepository;
import org.graviton.bazar.utils.Header;

public class Main {

    public static void main(String[] args) throws Exception {
        Header.build();
        Injector injector = Guice.createInjector(new DefaultModule());

        injector.getInstance(DatabaseService.class).start();
        injector.getInstance(AnnounceRepository.class).start();
        injector.getInstance(ServerService.class).start();

    }


}
