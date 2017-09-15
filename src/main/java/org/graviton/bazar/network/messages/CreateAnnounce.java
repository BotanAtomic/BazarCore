package org.graviton.bazar.network.messages;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.network.messages.api.Message;
import org.json.JSONObject;

public class CreateAnnounce implements Message {

    @Override
    public void deserialize(JSONObject data, ChannelHandlerContext channelHandlerContext, DatabaseService databaseService) {
        long responseId = databaseService.createAnnounce(data);

        JSONObject object = new JSONObject();
        object.put("message", 1);
        object.put("announce_id", responseId);

        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(object.toString(), CharsetUtil.UTF_8));
    }
}
