import com.google.common.io.Files;
import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;
import com.google.typography.font.sfntly.data.WritableFontData;
import com.google.typography.font.tools.conversion.woff.WoffWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Woff {
    public static void main(String[] args) {
        WoffWriter ww = new WoffWriter();
        FontFactory fontFactory = FontFactory.getInstance();
        byte[] bytes;
        try {
            File actualFile = new File("../resources/font.ttf");
            bytes = Files.toByteArray(actualFile);
            Font font = fontFactory.loadFonts(bytes)[0];
            WritableFontData wfd = ww.convert(font);

            FileOutputStream fs = new FileOutputStream(actualFile.getName().substring(0, actualFile.getName().lastIndexOf(".")) + ".woff");
            wfd.copyTo(fs);
            fs.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
