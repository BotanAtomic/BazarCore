package org.graviton.bazar.network;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.network.messages.*;
import org.graviton.bazar.network.messages.api.Message;
import org.json.JSONObject;

import javax.inject.Inject;
import java.util.concurrent.ConcurrentHashMap;

public class MessageHandler extends ConcurrentHashMap<Byte, Message> {
    @Inject @Getter private DatabaseService databaseService;

    public MessageHandler() {
        put((byte) 0, new RequestBaseAnnounce());
        put((byte) 1, new CreateAnnounce());
        put((byte) 2, new RequestBaseAnnounce());
        put((byte) 3, new RequestNextAnnounce());
        put((byte) 4, new FilterSearchAnnounce());
        put((byte) 5, new RequestPersonalAnnounce());
        put((byte) 6, new RequestSavedAnnounce());
        put((byte) 7, new SaveAnnounce());
        put((byte) 8 , new RemoveAnnounce());

    }

    void parse(JSONObject data, ChannelHandlerContext channelHandlerContext) {
        get((byte) data.getInt("message")).deserialize(data, channelHandlerContext, databaseService);
    }

}
