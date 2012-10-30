package sy.util;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImgOperate {
	/**
	 * 获取文件后缀名
	 * @param fileName 上传的文件名
	 * @return 文件后缀名
	 */
	public static String getExtention(String fileName) 
	{
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	/**
	 * 上传文件（图片，文件）
	 * @param filename源文件路径
	 * @param tagetfilename目标文件
	 * @return
	 */
	public static boolean upload(File file,String tagetfilename) {
		boolean flag=false;
		try {
			InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
			OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(tagetfilename));
			byte [] buffer=new byte[1024];
			try {
				while (inputStream.read(buffer)>0) {
					outputStream.write(buffer);
				}
				flag=true;
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					flag=false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	/**
	 * 打水印（限文字）
	 * @param srcfilepath 要打水印的图片
	 * @param content 要打的内容
	 * @return boolean 是否成功
	 */
	public boolean Mark(String srcfilepath,String content) {
			boolean flag=false;
			Image src;
			try {
				src = ImageIO.read(new File(srcfilepath));
				 BufferedImage tag2= new BufferedImage(src.getWidth(null),src.getHeight(null) , BufferedImage.TYPE_INT_RGB);   
			        Graphics grp = tag2.getGraphics();
			        Font font = new Font(content,Font.BOLD,13);
			        grp.setFont(font);
			        grp.setColor(Color.white);
			        grp.drawImage(src, 0, 0, null);
//			        src.getWidth(null)/10,src.getHeight(null)/20
			        grp.drawString(content,3,130);
			        grp.dispose();
			        FileOutputStream out = new FileOutputStream(srcfilepath); 
			        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			        encoder.encode(tag2); 
			        out.close();  
			        flag=true;
			} catch (IOException e) {
				e.printStackTrace();
				flag=false;
			}   
	       return flag;
	}
	/**
	 * 缩放(需配合截取一起使用，先缩放后截取)
	 * @param srcfilepath 源文件路径
	 * @param w 缩放后的宽度
	 * @param h 缩放后的高度
	 * @return image图形对象
	 */
	public Image zoom(String srcfilepath,int w,int h) {
		Image image=null;
		BufferedImage bufferedImage=null;
		try {
			bufferedImage = ImageIO.read(new File(srcfilepath));
			image=bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public boolean zoom2(String srcfilepath,int w,int h) {
		boolean flag=false;
		Image image;
		BufferedImage bufferedImage;
		try {
			//获取原文件名
			String srcfilename=srcfilepath.substring(srcfilepath.lastIndexOf("\\")+1);
			//创建存放新图片的路径
			HttpServletRequest request=ServletActionContext.getRequest();
			String zoompath=request.getRealPath("/")+"zoom\\"+srcfilename;
			File file=new File(zoompath);
			if (null==file) {
				if (file.mkdir()) {
				}
			}
			//缩放
			bufferedImage = ImageIO.read(new File(srcfilepath));
			image=bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
			//创建缩放后的图片
			BufferedImage bufferedImage2=new BufferedImage(95,135,BufferedImage.TYPE_INT_RGB); 
			Graphics graphics=bufferedImage2.getGraphics();
			graphics.drawImage(image, 0, 0, null);
			ImageIO.write(bufferedImage2, "", new File(""));
		} catch (IOException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	/**
	 * 调整图片
	 * @param srcfilepath 源文件路径
	 * @param image 图片对象（可为空）
	 * @param tagfilepath 目标文件路径（默认覆盖源文件）
	 * @param typename 文件类型（默认jpeg.不支持gif）
	 * @param x 调整后横坐标
	 * @param y 调整后的纵坐标
	 * @param w 调整后的图片宽度
	 * @param h 调整后的图片高度
	 * @param width 要截取的图片宽度
	 * @param height 要截取的图片高度
	 * @param needDel 是否需要删除源文件(默认true)
	 * @return boolean 截取是否成功
	 */
	public boolean adjust(String srcfilepath,Image image,String tagfilepath,String typename,int x,int y,int w,int h,int width,int height,boolean needDel) {
		boolean flag=false;
		ImageFilter imageFilter;
		try {
//			File srcfile=new File(srcfilepath);
			if (null==image) {
				image=ImageIO.read(new File(srcfilepath));
			}
			//**截取图片开始**
			imageFilter=new CropImageFilter(x,y,95,135);
			ImageProducer imageProducer=new FilteredImageSource(image.getSource(),imageFilter);
			Button button=new Button();
			Image image3=button.createImage(imageProducer);
			//**截取图片结束**
			BufferedImage tag=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics g=tag.getGraphics();
			g.drawImage(image3,0,0,null);
			if (null==tagfilepath&&null==typename) {
				ImageIO.write(tag, "JPEG", new File(srcfilepath));
			}
			else if (null==tagfilepath&&null!=typename) {
				ImageIO.write(tag, typename.toUpperCase().substring(1), new File(srcfilepath));
			}
			else if (null!=tagfilepath&&null==typename) {
				ImageIO.write(tag, "JPEG", new File(tagfilepath));
			}
			else {
				ImageIO.write(tag, typename.toUpperCase().substring(1), new File(tagfilepath));
			}
			if (needDel) {
				if (new File(srcfilepath).delete()) {
//					System.out.println("delete src ok!");
				}else {
//					System.out.println("delete src fail!");
				}
			}
//			this.setImgid(this.getImgid());
			flag=true;
		} catch (IOException e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 删除文件
	 * @param srcFilePath 文件的绝对路径
	 * @return
	 */
	public boolean delFile(String srcFilePath) {
		boolean flag=false;
		try {
			if (new File(srcFilePath).delete()) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	public static void main(String[] args) {
		ImgOperate img=new ImgOperate();
		img.zoom2("F:\\apache-tomcat-6.0.30\\webapps\\picMg\\upload\\goodsImage\\20120921\\2df5b372-1a96-44d7-88b8-1a6dc835282c.jpg", 300, 300);
	}
}
