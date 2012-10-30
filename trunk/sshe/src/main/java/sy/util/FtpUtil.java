package sy.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

public class FtpUtil {;  
  
    FtpClient ftpClient;  
  
    private String host;  
  
    private int port;  
  
    private String user;  
  
    private String pwd;  
      
    private String localDirFile;  
      
    private String serverDirFile;  
    public FtpUtil() {  
        /*this.host = Constant.HOST; 
        this.port = Integer.parseInt(Constant.PORT); 
        this.user = Constant.USER; 
        this.pwd = Constant.PASSWORD; 
        this.localDirFile = Constant.LOCALDIR; 
        this.serverDirFile = Constant.SERVERDIR;*/  
        this.host ="ftp://192.168.2.120";  
        this.port = 8821;  
        this.user = "huifeng";  
        this.pwd = "huifeng";  
        this.localDirFile = "temp";  
        this.serverDirFile = "/test";  
        ftpClient = new FtpClient();  
    }  
    public void uploadFiles(String filename,String webroot) {  
        try {  
            ftpClient.openServer(host, port);//打开ftp连接  
            ftpClient.login(user, pwd);//输入用户名密码  
            upload(this.serverDirFile+"/" + filename, webroot+System.getProperty("file.separator")+this.localDirFile + System.getProperty("file.separator") + filename);  
            ftpClient.closeServer();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
  
    private void upload(String serverName, String loacalName) {  
        try {  
            TelnetOutputStream os = ftpClient.put(serverName);  
            InputStream is = new FileInputStream(loacalName);  
            byte[] bytes = new byte[1024];  
            int c;  
            while ((c = is.read(bytes)) != -1) {  
                os.write(bytes, 1, c);  
            }  
            is.close();  
            os.close();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }  
      
    public static void main (String[] ags){  
        FtpUtil ftp=new FtpUtil();  
        ftp.uploadFiles("1.xls", "C:\\work\\eclipse\\workspace\\wap\\WebRoot");  
    }  
}  