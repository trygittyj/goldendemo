package com.example.demo.socket.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {
	public static void main1(String args[]) throws IOException {
		File f=new File("d:\\BugReport.txt");
		try {
			FileOutputStream fos=new FileOutputStream(f);
			FileChannel fileChannel=fos.getChannel();
			ByteBuffer bf=ByteBuffer.allocate(1024);
			fileChannel.read(bf);
			String appendStr="testtesttest";
			bf.put(appendStr.getBytes());
			bf.flip();
			try {
				fileChannel.write(bf);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fileChannel.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException{
		try {
			File f=new File("d:\\BugReport.txt");
			FileInputStream fis=new FileInputStream(f);
			FileChannel fc=fis.getChannel();
			ByteBuffer bf=ByteBuffer.allocate(1024);
			fc.read(bf);
			bf.flip();
			System.out.println(bf.getChar());
			while (bf.remaining()>0) {
			    byte b = bf.get();
			    System.out.print(((char)b));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
