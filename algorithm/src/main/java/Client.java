import com.example.newProto.Contacts;
import com.example.newProto.PeopleInfo;
import com.example.start.Phone;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

    public static byte msg[];

    public static void main(String[] args) throws IOException {
//        System.out.println("客户端启动...");
        // 创建一个流套接字并将其连接到指定主机上的指定端口号
//        Socket socket = new Socket("localhost", 8001);
        // 向服务器端发送数据
//        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

//        PeopleInfo p1 = PeopleInfo.newBuilder()
//                .setName("程涛")
//                .setAge(30)
//                .build();
//        byte[] p1B = p1.toByteArray();
//        System.out.println("序列化结果为: " + Arrays.toString(p1B));
//
//        PeopleInfo peopleInfo = PeopleInfo.parseFrom(p1B);
//        System.out.println("反序列化结果为: " + peopleInfo);
//        System.out.println("姓名: " + peopleInfo.getName());

//        write2File();
        readFromFile();

//        out.write(msg);
//        out.close();
//        socket.close();
    }

    public static void write2File() throws IOException {
        Contacts.Builder builder = Contacts.newBuilder();

        String filePath = "src/main/java/com/example/newProto/contacts.bin";
        //读取本地已存在的联系人文件
        //反序列化出通讯录对象
//        Contacts existContacts = Contacts.parseFrom(Files.newInputStream(Paths.get(filePath)));
//        Contacts.Builder existBuilder = existContacts.toBuilder();

        try {
            //从流中读取数据，并合并到builder已有的数据中
            builder.mergeDelimitedFrom(Files.newInputStream(Paths.get(filePath)));
        } catch (Exception e) {
            System.out.println("contacts.bin not find, create new file.");
        }
        //向通讯录中新增一个联系人
        builder.addContacts(generatePeopleInfo());

        //序列化通讯录并写入文件
        FileOutputStream out = new FileOutputStream(filePath);
        builder.build().writeTo(out);
    }

    public static PeopleInfo generatePeopleInfo() {
        PeopleInfo.Builder builder = PeopleInfo.newBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------新增联系人-------------");
        System.out.print("请输入联系人姓名:");
        String name = sc.nextLine();
        builder.setName(name);
        System.out.print("请输入联系人年龄:");
        int age = sc.nextInt();
        sc.nextLine();  //避免用户输入age时输入了回车，影响后续的读取
        builder.setAge(age);

        for (int i = 0; ; i++) {
            System.out.println("请输入联系人电话" + (i + 1) + "(仅输入回车完成电话新增)");
            String number = sc.nextLine();
            if(number.isEmpty()) break;

            Phone phone = Phone.newBuilder().setNumber(number).build();
            builder.addPhone(phone);
        }

        System.out.println("---------------新增联系人结束-------------");
        return builder.build();
    }

    public static void readFromFile() throws IOException {
        String filePath = "src/main/java/com/example/newProto/contacts.bin";
        //读取文件，将内容反序列化
        Contacts contacts = Contacts.parseFrom(Files.newInputStream(Paths.get(filePath)));
        int i = 1;
        for(PeopleInfo p : contacts.getContactsList()) {
            System.out.println("-------------联系人" + i++ + "--------------");
            System.out.println("姓名:" + p.getName());
            System.out.println("年龄:" + p.getAge());
            System.out.println("电话：" + p.getPhoneList());
        }

    }
}