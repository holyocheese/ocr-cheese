package com.ocr.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HoughLineUtil {

	static {
		//在使用OpenCV前必须加载Core.NATIVE_LIBRARY_NAME类,否则会报错
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		houghLines();
	}

	/**
	 * OpenCV-4.0.0 霍夫变换-直线检测
	 * @return:void
	 * @date: 2019年1月18日 上午9:18:08
	 */
	public static void houghLines() {
		Mat src=Imgcodecs.imread("D:\\0001.png");
		Mat gary=new Mat();
		Mat lines=new Mat();
		//1.边缘处理
		Imgproc.Canny(src, gary, 100,200);
		// 腐蚀+膨胀
		Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT,new Size(15,15));
		//进行腐蚀操作
		Imgproc.erode(src, src, element);
		//进行膨胀操作
		Imgproc.dilate(src, src, element);
		//2.霍夫变换-直线检测
		Imgproc.HoughLinesP(gary,lines, 1,Imgproc.HOUGH_GRADIENT/180.0, 100, 90, 30);
		double[] date;
		for(int i=0,len=lines.rows();i<len;i++) {
			date=lines.get(i, 0).clone();
			Imgproc.line(src,new Point((int)date[0],(int)date[1]), new Point((int)date[2],(int)date[3]) ,new Scalar(0, 255, 0) , 2, Imgproc.LINE_AA);
		}
		HighGui.imshow("直线检测", src);
		HighGui.waitKey(0);
	}

}
