package OpenPrograme;

import java.io.File;
import java.io.IOException;

public class openDir {

	public static void start() {
		try {
			java.awt.Desktop.getDesktop().open(new File("D:\\网盘下载\\华仔给的java教程\\Java高级\\前三周\\Mybatis\\03 MyBatis第三天\\02 视频"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
