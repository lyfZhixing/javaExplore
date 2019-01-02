# NIO 学习
## channel 
[com.lyf.nio.demo1.ChannelTest](https://github.com/lyfZhixing/javaExplore/blob/master/NIO/src/main/java/com/lyf/nio/demo1/ChannelTest.java)主要是根据api写了一些测试用例：
1. `bufferTest()`：缓冲区的分配和常用属性——position、limit、capacity
2. `testCopy()`：基本的复制文件，其主要的元素包括：
    - 文件输入流`fileInputStream`，文件输出流`fileOutputStream`，文件输入输出管道`in/outChannel`
    - 缓冲区`byteBuffer`
    - 循环读写文件`inChannel.read(byteBuffer) != -1`
        - byteBuffer.flip();
        - outChannel.write(byteBuffer);
        - byteBuffer.clear();
    - 依次关管道和流（代码中没写）
3. `testMapCopy()`：映射内存复制文件，相关api:[java.nio.MappedByteBuffer](https://docs.oracle.com/javase/8/docs/api/index.html)
    - FileChannel.open(……)打开通道
    - MapByteBuffer var = fileChannel.map(……)内存映射
    - var.get / put , 内存复制
4. `testTransCopy()`：通道传输 in To out /  out From in   相关方法：`transferTo`和`transferFrom`
    - FileChannel.open(……)
    - in To out / out From in(直接通道传输)
5. `testRandomCopy()`：分散读取，聚集写入，将通道中的数据分散到多个缓冲区中（ByteBuffer[]） ，将多个缓冲区中的数据聚集到通道中
