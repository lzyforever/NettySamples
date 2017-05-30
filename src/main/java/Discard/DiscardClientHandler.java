package Discard;

import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by LEESF on 2017/5/30.
 */
public class DiscardClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
