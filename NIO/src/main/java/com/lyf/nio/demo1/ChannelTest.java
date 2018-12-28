package com.lyf.nio.demo1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description NIO Channel 管道学习
 * @author lyf
 * @date 2018-12-28 9:53
 * @modified by TODO
 */
public class ChannelTest {

    private long time;
    @Before
    public void strar() {
        time = System.currentTimeMillis();
    }
    @After
    public void end() {
        System.out.println(System.currentTimeMillis()-time);
    }

    @Test
    public void bufferTest() {
        // 使用allocate分配缓冲区  byte
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    /**
     * @description 复制文件
     * @author lyf
     * @date 2018/12/28 10:00
     * @return void
     */
    @Test
    public void testCopy() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        fileInputStream = new FileInputStream("test.jpg");
        fileOutputStream = new FileOutputStream("test_copy.jpg");
        // 获取通道
        inChannel = fileInputStream.getChannel();
        outChannel = fileOutputStream.getChannel();
        // 使用静态方法allocate分配缓冲区
        // 1024byte
        ByteBuffer byteBuffer = ByteBuffer.allocate(102400);
        // 复制
        while (inChannel.read(byteBuffer) != -1) {
            // 读
            byteBuffer.flip();
            // 写
            outChannel.write(byteBuffer);
            // 清
            byteBuffer.clear();
        }

    }

    /**
     * @description 映射内存复制  java.nio.MappedByteBuffer
     * @author lyf
     * @date 2018/12/28 15:15
     * @param []
     * @return void
     */

    @Test
    public void testMapCopy() throws IOException {
        // Opens or creates a file, returning a file channel to access the file.
        // 打开或创建文件，返回文件通道以访问该文件。
        FileChannel inChannel = FileChannel.open(Paths.get("test.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("test_map_copy.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        // 将文件映射到内存的某一范围
        // Maps a region of this channel's file directly into memory.
        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        // dst 目标数组 The destination array
        byte[] dst = new byte[inMappedBuffer.limit()];

        // Relative bulk get method.
        inMappedBuffer.get(dst);
        // Relative bulk put method (optional operation)
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();

    }

    /**
     * @description 通道传输 in To out /  out From in   transferTo和transferFrom
     * @author lyf
     * @date 2018/12/28 16:07
     * @param []
     * @return void
     */

    @Test
    public void testTransCopy() throws IOException {
        // Opens or creates a file, returning a file channel to access the file.
        FileChannel inFileChannel = FileChannel.open(Paths.get("test.jpg"), StandardOpenOption.READ);
        FileChannel outfileChannel = FileChannel.open(Paths.get("test_trans_copy.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        // transferTo和transferFrom二选一

        // Transfers bytes into this channel's file from the given readable byte channel.
        // 从给定的可读字节通道将字节传输到此通道的文件中  'out' from 'in'
        // outfileChannel.transferFrom(inFileChannel,0,inFileChannel.size());

        // Transfers bytes from this channel's file to the given writable byte channel.
        // 'in' to 'out'
        inFileChannel.transferTo(0,inFileChannel.size(),outfileChannel);
        inFileChannel.close();
        outfileChannel.close();
    }

    /**
     * @description 分散读取，聚集写入  如果文件大小比缓冲区大就会损坏文件（参考test_random_copy.jpg）
     * @author lyf
     * @date 2018/12/28 17:15
     * @param []
     * @return void
     */
    @Test
    public void testRandomCopy() throws IOException {

        // Creates a random access file stream to read from, and optionally to write to, a file with the specified name. A new  {@link FileDescriptor} object is created to represent the  connection to the file.
        // the mode argument is equal to one of "r", "rw", "rws", or "rwd"
        // 创建随机访问文件流，以便从具有指定名称的文件进行读取，并可选择写入该文件。 创建一个新的{@link FileDescriptor}对象来表示与该文件的连接。
        RandomAccessFile inFile = new RandomAccessFile("test.jpg","r");
        FileChannel inFileChannel = inFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2048);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(5120);

        ByteBuffer[] dsts = {byteBuffer,byteBuffer1,byteBuffer2};

        // Reads a sequence of bytes from this channel into the given buffers
        // 从通道里将一系列字节读取到缓冲区
        inFileChannel.read(dsts);

        for (ByteBuffer dst : dsts) {
            dst.flip();
        }

        RandomAccessFile outFile = new RandomAccessFile("test_random_copy.jpg","rw");
        FileChannel outChannel = outFile.getChannel();
        outChannel.write(dsts);
        inFileChannel.close();
        outChannel.close();

    }

    /**
     * @description  testRandomCopy的改良版
     * @author lyf
     * @date 2018/12/28 17:18
     * @param []
     * @return void
     */

    @Test
    public void testRandomLoopCopy() throws IOException {

        // Creates a random access file stream to read from, and optionally to write to, a file with the specified name. A new  {@link FileDescriptor} object is created to represent the  connection to the file.
        // the mode argument is equal to one of "r", "rw", "rws", or "rwd"
        // 创建随机访问文件流，以便从具有指定名称的文件进行读取，并可选择写入该文件。 创建一个新的{@link FileDescriptor}对象来表示与该文件的连接。
        RandomAccessFile inFile = new RandomAccessFile("test.jpg","r");
        FileChannel inFileChannel = inFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2048);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(512);

        RandomAccessFile outFile = new RandomAccessFile("test_random_loop_copy.jpg","rw");
        FileChannel outChannel = outFile.getChannel();
        ByteBuffer[] dsts = {byteBuffer,byteBuffer1,byteBuffer2};

        while (inFileChannel.read(dsts) != -1) {
            for (ByteBuffer dst : dsts) {
                dst.flip();
                outChannel.write(dst);
                dst.clear();
            }
        }
        inFileChannel.close();
        outChannel.close();
    }


}
