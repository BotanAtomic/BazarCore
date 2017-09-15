package org.graviton.bazar.network.messages.api;

import io.netty.channel.ChannelHandlerContext;
import org.graviton.bazar.database.DatabaseService;
import org.json.JSONObject;

public interface Message {

    void deserialize(JSONObject data, ChannelHandlerContext channelHandlerContext, DatabaseService databaseService);

}
