
package filecompression;

import java.io.*;
import java.util.zip.*;

public class Decompress {
    
    public static void decompress(File source,File destination) throws IOException{
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPInputStream gzis = new GZIPInputStream(fis);
        int read;
        
        while((read = gzis.read(buffer)) != -1){
            fos.write(buffer,0,read);
        }
        gzis.close();
        fis.close();
        fos.close();
    }
    public static void main(String args[]){
        File source = new File("C:\\Users\\Surya\\Desktop\\compressedtext.txt");
        File destination = new File("C:\\Users\\Surya\\Desktop\\decompressedtext.txt");
        try{
            decompress(source,destination);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

