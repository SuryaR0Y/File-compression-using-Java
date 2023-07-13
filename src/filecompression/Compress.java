
package filecompression;

import java.io.*;
import java.util.zip.*;

public class Compress {
    
    public static void compress(File source,File destination) throws IOException{
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPOutputStream gzos = new GZIPOutputStream(fos);
        int read;
        
        while((read = fis.read(buffer)) != -1){
            gzos.write(buffer,0,read);
        }
        gzos.finish();
        gzos.close();
        fos.close();
        fis.close();
    }
    public static void main(String args[]){
        File source = new File("C:\\Users\\Surya\\Desktop\\text1.txt");
        File destination = new File("C:\\Users\\Surya\\Desktop\\compressedtext.txt");
        try{
            compress(source,destination);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
