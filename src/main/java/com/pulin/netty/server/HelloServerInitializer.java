package com.pulin.netty.server;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * 在HelloServer中的HelloServerInitializer在这里实现。

　　首先我们需要明确我们到底是要做什么的。很简单。HelloWorld!。我们希望实现一个能够像服务端发送文字的功能。服务端假如可以最好还能返回点消息给客户端，然客户端去显示。

　　需求简单。那我们下面就准备开始实现。

　　DelimiterBasedFrameDecoder Netty在官方网站上提供的示例显示 有这么一个解码器可以简单的消息分割。

　　其次 在decoder里面我们找到了String解码编码器。着都是官网提供给我们的。
 * @author Administrator
 *
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 自己的逻辑Handler
        pipeline.addLast("handler", new HelloServerHandler());
    }
}