package com.domain.lesson15NIO.selectors;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class NIOFiles {
    public static void main(String[] args) {
        // NIO
        // каналы Channel
        // селекторы Selector- объекты, переключающие каналы. Следит за каналом
        // буфферы Buffer
        // кодировки Charset / StandartCharset
        // для работы с файловой системой Path + Files (начиная с JAVA & пакет files) ДОМА посмотреть документацию по методам!!!

        // Chanel:
        // FileChannel - аналог InputStream OutputStream
//                fileInputStream.getChannel()
//                fileOutputStream.getChannel()
//                randomAccessFile.getChannel()
        // DatagramChannel - для пердачи по udp
        // SocketChannel
        // ServerSocketChannel

        File file = new File("nio.txt");
        if(!file.exists()){
            try{
                file.createNewFile();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            writeToFile(file.toPath(), "String");
            readFromFile(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(Path path, String string) throws IOException {
       // Files.write(path, string.getBytes(), StandardOpenOption.APPEND); // стандартная реализация
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.APPEND)){
            ByteBuffer byteBuffer = ByteBuffer.allocate(string.getBytes().length);
            byteBuffer.put(string.getBytes(StandardCharsets.UTF_8));
            byteBuffer.flip();

            fileChannel.write(byteBuffer); // пишем из буфера в канал


        }

    }
    public static void readFromFile(Path path) throws IOException {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(path)){
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            while (fileChannel.read(byteBuffer) > 0){
                byteBuffer.flip();
                for (int i =0; i < byteBuffer.limit(); i ++){
                    System.out.println((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        }
        List<String> lines = Files.readAllLines(path);
        Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);
    }


}
