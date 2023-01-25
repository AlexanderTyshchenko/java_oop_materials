package pro.tyshchenko.oop.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Alexander Tyshchenko.
 */
public class HttpURLConnectionExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com.ua");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream())))
        {
            char[] buf = new char[1000];
            StringBuilder sb = new StringBuilder();
            int r;
            do {
                if ((r = br.read(buf)) > 0) {
                    sb.append(new String(buf, 0, r));
                }
            }
            while (r > 0);
            http.getHeaderField("Date");
            System.out.println(sb);
        } finally {
            http.disconnect();
        }
    }

}
