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

public class RequestPersonalAnnounce implements Message {
    @Override
    public void deserialize(JSONObject data, ChannelHandlerContext channelHandlerContext, DatabaseService databaseService) {
        List<Announce> baseQuery = new ArrayList<>(databaseService.getAnnounceRepository().values());

        baseQuery.removeIf(announce -> !announce.getContactNumber().equals(channelHandlerContext.channel().attr(PHONE).get()));

        List<Announce> currentQuery = baseQuery.stream().limit(20).collect(Collectors.toList());

        JSONObject response = new JSONObject();

        response.put("message", 2);
        response.put("query_size", currentQuery.size());

        currentQuery.forEach(announce -> {
            int index = currentQuery.indexOf(announce);
            response.put(index + "announce_id", announce.getId());
            response.put(index + "announce_title", announce.getTitle());
            response.put(index + "announce_description", announce.getDescription());
            response.put(index + "announce_price", announce.getPrice());
            response.put(index + "announce_category", announce.getCategory().ordinal());
            response.put(index + "announce_location", announce.getLocation().ordinal());
            response.put(index + "announce_owner_name", announce.getContactName());
            response.put(index + "announce_owner_number", announce.getContactNumber());
            response.put(index + "announce_image_count", announce.getImageCount());
            response.put(index + "announce_date", announce.getDate().getTime());
            response.put(index + "announce_saved", announce.getFavorites().contains(channelHandlerContext.channel().attr(PHONE).get()));
            baseQuery.remove(announce);
        });

        channelHandlerContext.channel().attr(QUERY).set(baseQuery);
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(response.toString(), CharsetUtil.UTF_8));
    }
}
