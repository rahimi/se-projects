package patterns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TemplatePattern {
    public static void main(String[] args) throws Exception {
        ConsolePrinter printer = new ConsoleMirror(); 
        //printer.printToConsole();

        ConsolePrinter filePrinter = new FilePrinter(
                System.getProperty("user.dir") + "/TestProject/src/patterns/filereader.txt");
        filePrinter.printToConsole();

        ConsolePrinter webPrinter = new WebPrinter("http://quotes.rest/qod?language=en");
        webPrinter.printToConsole();
    }
}

abstract class ConsolePrinter {
    InputStream in;

    void printToConsole() throws Exception {
        in = connectService();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String out;
        while ((out = br.readLine()) != null) {
            System.out.println(out);
        }
        close();
    }

    abstract InputStream connectService() throws Exception;

    void close() throws IOException {
        in.close();
    }
}

class ConsoleMirror extends ConsolePrinter {
    InputStream connectService() {
        return System.in;
    }
}

class FilePrinter extends ConsolePrinter {
    String uri;

    public FilePrinter(String uri) {
        this.uri = uri;
    }

    InputStream connectService() throws Exception {
        File f = new File(uri);
        return new FileInputStream(f);
    }
}

class WebPrinter extends ConsolePrinter {
    URL url;
    HttpURLConnection conn;

    public WebPrinter(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
    InputStream connectService() throws Exception {
        return url.openStream();
    }
}