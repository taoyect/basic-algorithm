import com.google.protobuf.InvalidProtocolBufferException;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
/**
 * @author ct
 * @date 2025-02-20 10:02
 */
public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8001; // 服务端监听的端口
        System.out.println("服务端启动，监听端口 " + port + "...");

        // 创建 ServerSocket，监听指定端口
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端连接成功，IP: " + clientSocket.getInetAddress());

                InputStream in = clientSocket.getInputStream();
                // 获取输入流，读取客户端发送的数据
//                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                // 创建一个字节数组用于读取1024字节的数据
                byte[] bytes = new byte[5];

                // 读取数据，最多读取1024字节
                int bytesRead = in.read(bytes);
                VideoInfo.VideoFeature parse = parse(bytes);
                System.out.println(parse);

                // 处理完客户端消息后，关闭流和连接
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("处理客户端连接时发生错误: " + e.getMessage());
            }
        }
    }

    public static VideoInfo.VideoFeature parse(byte[] buf) {
        try {
            return VideoInfo.VideoFeature.parseFrom(buf);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}
