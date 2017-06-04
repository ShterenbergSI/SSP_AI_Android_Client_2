package ru.ds_release.database;

/**
 * Created by stass on 03.06.2017.
 */

import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] ar) {
        int serverPort = 9090;
        String address = "10.208.2.0";


        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("IP-адрес " + address + "port " + serverPort + "?");
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Соединение");


            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();


            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);


            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Введите что-то и нажмите enter. Отправьте это на сервер.....");
            System.out.println();

            while (true) {
                line = keyboard.readLine();
                System.out.println("Отправка этой строки на сервер...");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("Сервер ответил : " + line);
                System.out.println("Удачное соединение");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static class Serv_Catch {
        public static void main(String[] ar)    {
            int port = 6666;
            try {
                ServerSocket ss = new ServerSocket(port);
                System.out.println("ждем ответку...");

                Socket socket = ss.accept();
                System.out.println("переходим к клиенту");
                System.out.println();


                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();


                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);

                String line = null;
                while(true) {
                    line = in.readUTF();
                    System.out.println("тут клиент что-то мне пишет " + line);
                    System.out.println("я посылаю обратно");
                    out.writeUTF(line);
                    out.flush();
                    System.out.println("ждем далее");
                    System.out.println();
                }
            } catch(Exception x) { x.printStackTrace(); }
        }
    }
}