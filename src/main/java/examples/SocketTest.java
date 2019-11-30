package examples;

import generic.Socket;

public class SocketTest {
    public static void main(String[] args) throws InterruptedException {
        Socket socket = Socket.of("127.0.0.1", 8080);
        socket.connect();

        byte[] data = socket.read0();
        System.out.println(new String(data));

        while (true) {
            Thread.sleep(1000);
            int result = socket.write0(data);

            /**
             * 0x00000000 0x00000000 0x00000008 0x00000000 0x00000045 0x00000000 0x00000000 0x00000054 0x0000005A 0x000000B6 0x00000040 0x00000000 0x00000040 0x00000001 0x0000005E
             * 0x0000009F 0x000000C0 0x000000A8 0x00000000 0x00000001 0x000000C0 0x000000A8 0x00000000 0x00000002 0x00000008 0x00000000 0x00000004 0x000000CA 0x00000052 0x000000DA
             * 0x00000000 0x00000006 0x00000073 0x000000A9 0x000000E1 0x0000005D 0x00000000 0x00000000 0x00000000 0x00000000 0x00000085 0x0000007B 0x00000007 0x00000000 0x00000000
             * 0x00000000 0x00000000 0x00000000 0x00000010 0x00000011 0x00000012 0x00000013 0x00000014 0x00000015 0x00000016 0x00000017 0x00000018 0x00000019 0x0000001A 0x0000001B
             * 0x0000001C 0x0000001D 0x0000001E 0x0000001F 0x00000020 0x00000021 0x00000022 0x00000023 0x00000024 0x00000025 0x00000026 0x00000027 0x00000028 0x00000029 0x0000002A
             * 0x0000002B 0x0000002C 0x0000002D 0x0000002E 0x0000002F 0x00000030 0x00000031 0x00000032 0x00000033 0x00000034 0x00000035 0x00000036 0x00000037
             */

            if(result < 0) {
                throw new RuntimeException("blah blah");
            }
        }
    }
}