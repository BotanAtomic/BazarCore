package org.graviton.bazar.module;


import com.google.inject.AbstractModule;
import org.graviton.bazar.network.MessageHandler;
import org.graviton.bazar.network.ServerService;

public class NetworkModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageHandler.class).asEagerSingleton();
        bind(ServerService.class).asEagerSingleton();
    }

}