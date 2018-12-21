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


public class NioPractice {
	private static final int NIOSERVERPORT=2233;
	public static void start() {
		
	}
}

class NioServer2 implements Runnable{
	private static int port;
	private volatile boolean startFlag;
	private Selector selector;
	private ServerSocketChannel ssc;
	private SocketChannel sc;
	public NioServer2(int port) {
		this.port=port;
		try {
			selector=Selector.open();
			ssc=ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(port),1024);
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("the server is ready for connection");
			startFlag=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stop() {
		startFlag=false;
	}
	public void run() {
		while(startFlag) {
			try {
				selector.select(1000);
				Set<SelectionKey> keySet=selector.selectedKeys();
				Iterator<SelectionKey> keyit=keySet.iterator();
				SelectionKey key=null;
				while(keyit.hasNext()) {
					key=keyit.next();
					keyit.remove();
					handleclient(key);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	private void handleclient(SelectionKey key) throws IOException {
		if(key.isValid()) {
			if(key.isAcceptable()) {
				sc=ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()) {
				sc=(SocketChannel)key.channel();
				ByteBuffer buffer=ByteBuffer.allocate(1024);
				int readBytes=sc.read(buffer);
				if(readBytes>0) {
					buffer.flip();
					byte[] bytes = new byte[buffer.remaining()];
					//将缓冲区可读字节数组复制到新建的数组中
					buffer.get(bytes);
					String got=new String(bytes,"UTF-8");
					System.out.println(got);
					writeBack(sc,got);
				}else {
					key.cancel();
					sc.close();
				}
				
						
			}
		}
	}
	private void writeBack(SocketChannel sc, String got) throws IOException {
		byte[] bytes=got.getBytes();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		buffer.put(bytes);
		buffer.flip();
		sc.write(buffer);
		
	}
}
