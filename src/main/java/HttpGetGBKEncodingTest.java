

import java.io.FileOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpGetGBKEncodingTest {

    public static void main(String[] args) throws Exception {
        
        String msg = "你好;[世界|http://www.baidu.com]";
        System.out.println(msg);
        byte[] bytes = msg.getBytes("gbk");
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append("%" + Integer.toHexString((b & 0xff)).toUpperCase());
        }
        String url = "http://168.168.170.170:8012/sendnotify.cgi?msg=" + builder.toString() + "&receiver=guest";
        System.out.println(url);
        
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);
        HttpResponse response = client.execute(request);
        
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            System.out.println("OK");
        } else {
            System.out.println("Failed");
        }

        // http://168.168.170.170:8012/sendnotify.cgi?msg=hello&receiver=guest

//        String s = "你好";
//        byte[] bytes = s.getBytes("GBK");
//        FileOutputStream out = new FileOutputStream("output.txt");
//        out.write(bytes);
//        out.close();
    }
}
