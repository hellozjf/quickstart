
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class GBKTest {
    
    private static String encodeGBK(String s) throws Exception {
        byte[] bytes = s.getBytes("gbk");
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append("%" + Integer.toHexString((b & 0xff)).toUpperCase());
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        
        String uriAPI = "http://168.168.170.170:8012/sendnotify.cgi";//Post方式没有参数在这里  
        String result = "";  
        HttpPost httpRequst = new HttpPost(uriAPI);//创建HttpPost对象  
          
        List <NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("msg", "我是字符串")); 
        params.add(new BasicNameValuePair("receiver", "guest"));
          
        try {  
            httpRequst.setEntity(new UrlEncodedFormEntity(params, "gbk"));  
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);  
            if (httpResponse.getStatusLine().getStatusCode() == 200)  
            {  
                System.out.println("OK");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  

        // String msg = "你好;[世界|http://www.baidu.com]";
        // System.out.println(msg);
        // byte[] bytes = msg.getBytes("gbk");
        // StringBuilder builder = new StringBuilder();
        // for (byte b : bytes) {
        // builder.append("%" + Integer.toHexString((b & 0xff)).toUpperCase());
        // }
        // String url = "http://168.168.170.170:8012/sendnotify.cgi?msg=" +
        // builder.toString() + "&receiver=guest";
        // System.out.println(url);

//        HttpClient httpClient = new DefaultHttpClient();
//
//        // 设置超时时间
//        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
//        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
//
//        String url = "http://168.168.170.170:8012/sendnotify.cgi";
//        HttpPost post = new HttpPost(url);
//
//        // 构造消息头
//        // post.setHeader("Content-type", "application/json; charset=utf-8");
//        // post.setHeader("Connection", "Close");
//        // String sessionId = getSessionId();
//        // post.setHeader("SessionId", sessionId);
//        // post.setHeader("appid", appid);
//
//        // 构建消息实体
//        StringEntity entity = new StringEntity("msg=你好世界&receiver=guest", Charset.forName("GBK"));
//        entity.setContentEncoding("GBK");
//        // 发送Json格式的数据请求
//        entity.setContentType("text/plain");
//        post.setEntity(entity);
//
//        HttpResponse response = httpClient.execute(post);
//
//        // 检验返回码
//        int statusCode = response.getStatusLine().getStatusCode();
//
//        if (statusCode == HttpStatus.SC_OK) {
//            System.out.println("OK");
//        } else {
//            System.out.println("Failed");
//        }

        // http://168.168.170.170:8012/sendnotify.cgi?msg=hello&receiver=guest

        // String s = "你好";
        // byte[] bytes = s.getBytes("GBK");
        // FileOutputStream out = new FileOutputStream("output.txt");
        // out.write(bytes);
        // out.close();
    }
}
