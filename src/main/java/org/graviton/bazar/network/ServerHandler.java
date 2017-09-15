package org.graviton.bazar.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import org.graviton.bazar.model.Announce;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    public final static AttributeKey<List<Announce>> QUERY = AttributeKey.newInstance("query");
    public final static AttributeKey<String> PHONE = AttributeKey.newInstance("phone");
    public final static AttributeKey<String> MESSAGE = AttributeKey.newInstance("message");

    private final MessageHandler messageHandler;

    ServerHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.channel().attr(MESSAGE).set("");
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        String message = "";
        try {
            message = in.toString(CharsetUtil.UTF_8);
            messageHandler.parse(new JSONObject(context.channel().attr(MESSAGE).get() + message), context);
            System.err.println(context.channel().attr(MESSAGE).get() + message);
            context.channel().attr(MESSAGE).set("");
        } catch (JSONException e) {
            context.channel().attr(MESSAGE).set(context.channel().attr(MESSAGE).get() + message);
        } finally {
            in.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
