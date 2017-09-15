package org.graviton.bazar.network.messages;

import io.netty.channel.ChannelHandlerContext;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.model.Announce;
import org.graviton.bazar.network.messages.api.Message;
import org.json.JSONObject;

public class RemoveAnnounce implements Message {
    @Override
    public void deserialize(JSONObject data, ChannelHandlerContext channelHandlerContext, DatabaseService databaseService) {
        Announce announce = databaseService.getAnnounceRepository().get(data.getLong("announce"));

        if(announce != null) {
            databaseService.removeAnnounce(announce);
            databaseService.getAnnounceRepository().remove(announce.getId());
        }

    }
}
