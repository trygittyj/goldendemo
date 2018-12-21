package com.example.demo.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class HanleReadWrite implements Runnable{
	private Selector selector;
	private ServerSocketChannel serverChannel;
	private volatile boolean started;
	public HanleReadWrite(int port) {
		try {
			selector=Selector.open();
			serverChannel=ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(port),1024);
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			started=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void stop() {this.started=false;}
	public void run() {
		while(started) {
			try {
				selector.select(1000);
				Set<SelectionKey> keys=selector.selectedKeys();
				Iterator<SelectionKey> it=keys.iterator();
				SelectionKey key=null;
				while(it.hasNext()) {
					key=it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if(key!=null) {
							key.cancel();
							if(key.channel()!=null) {
								key.channel().close();
							}
						}
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(selector!=null) {
			try {
				selector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void handleInput(SelectionKey key) {
		if(key.isValid()) {
			if(key.isAcceptable()) {
				ServerSocketChannel ssc=(ServerSocketChannel)key.channel();
				SocketChannel sc;
				try {
					sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(key.isReadable()) {
				SocketChannel sc=(SocketChannel)key.channel();
				ByteBuffer buffer=ByteBuffer.allocate(1024);
				try {
					int readBytes=sc.read(buffer);
					if(readBytes>0) {
						buffer.flip();
						byte[] bytes=new byte[buffer.remaining()];
						buffer.get(bytes);
						String readcontent=new String(bytes,"UTF-8");
						System.out.println(readcontent);
						doWrite(sc,readcontent);
					}else if(readBytes<0) {
						key.cancel();
						sc.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	private void doWrite(SocketChannel sc, String response) {
		byte[] bytes=response.getBytes();
		ByteBuffer writeBuffer=ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		try {
			sc.write(writeBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
