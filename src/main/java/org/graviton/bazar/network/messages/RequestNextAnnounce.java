package org.graviton.bazar.network.messages;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.model.Announce;
import org.graviton.bazar.network.messages.api.Message;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.graviton.bazar.network.ServerHandler.PHONE;
import static org.graviton.bazar.network.ServerHandler.QUERY;

public class RequestNextAnnounce implements Message {

    @Override
    public void deserialize(JSONObject data, ChannelHandlerContext channelHandlerContext, DatabaseService databaseService) {
        List<Announce> baseQuery =  channelHandlerContext.channel().attr(QUERY).get();
        List<Announce> currentQuery = baseQuery.stream().limit(20).collect(Collectors.toList());

        data.put("message", data.getInt("message"));
        data.put("query_size", currentQuery.size());

        currentQuery.forEach(announce -> {
            int index = currentQuery.indexOf(announce);
            data.put(index + "announce_id", announce.getId());
            data.put(index + "announce_title", announce.getTitle());
            data.put(index + "announce_description", announce.getDescription());
            data.put(index + "announce_price", announce.getPrice());
            data.put(index + "announce_category", announce.getCategory().ordinal());
            data.put(index + "announce_location", announce.getLocation().ordinal());
            data.put(index + "announce_owner_name", announce.getContactName());
            data.put(index + "announce_owner_number", announce.getContactNumber());
            data.put(index + "announce_image_count", announce.getImageCount());
            data.put(index + "announce_date", announce.getDate().getTime());
            data.put(index + "announce_saved", announce.getFavorites().contains(channelHandlerContext.channel().attr(PHONE).get()));
            baseQuery.remove(announce);
        });

        System.err.println("Send -> " + data.getInt("message"));

        channelHandlerContext.channel().attr(QUERY).set(baseQuery);
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(data.toString(), CharsetUtil.UTF_8));
    }
}
