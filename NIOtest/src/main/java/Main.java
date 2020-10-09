import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {

        try (FileOutputStream binaryFile = new FileOutputStream("data.dat")) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(12345);
            buffer.putInt(-5678);
            byte[] outputBytes2 = "yoyoyoyo".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(6);

            FileChannel channel = binaryFile.getChannel();
            buffer.flip();
            channel.write(buffer);

            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel2 = randomAccessFile.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel2.read(readBuffer);

            readBuffer.flip();

            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("Inputstring = " + new String(inputString));
            System.out.println("Int 1 = " + readBuffer.getInt());
            System.out.println("Int 2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("Inputstring 2 = " + new String(inputString2));
            System.out.println("Int 3 = " + readBuffer.getInt());
//            randomAccessFile.close();


            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel2.position(0);
            long numTranferred = copyChannel.transferFrom(channel2, 0, channel.size());
            System.out.println("Num transferred = " + numTranferred);

            copyChannel.close();
            copyFile.close();
            channel2.close();
            randomAccessFile.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
