
/* Sample openCV Java Application to do some simple image thresholding
 * Author: Simon McLoughlin
 * For setting up openCV for java development in Eclipse see the link below!
 * You can use version 2.4.11 of openCV as this has the javadoc as part of the download (opencv 3 does not it appears)
 * http://docs.opencv.org/2.4/doc/tutorials/introduction/java_eclipse/java_eclipse.html#java-eclipse
 * Remember to set the PATH environment variable either in windows or locally in Eclipse, to do it in eclipse:
 * Run->Run Configurations->Java Application->Your Project->Environment tab->New
 * Variable: PATH  Value: opencv bin directory. e.g C:\Users\simon\Downloads\opencv2411\opencv\build\x64\vc12\bin
 */

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class OringInspection {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Create and set up the window.
		JFrame frame = new JFrame("OpenCV");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel imageHolder = new JLabel();
		frame.getContentPane().add(imageHolder, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

		// press Q to quit application
		frame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_Q)
					System.exit(0);
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyTyped(KeyEvent arg0) {
			}
		});
		System.out.println("Stream Opened");
		Mat img = new Mat();
		Mat out = new Mat();
		Mat histim = new Mat(256, 256, CvType.CV_8UC3);
		int i = 1;
		BufferedImage jimg;
		while (true) {
			/* READ */
			img = Highgui.imread("C:\\Users\\darren\\workspace\\CV\\orings\\Oring" + i + ".jpg", 0);
			//img = Highgui.imread("C:\\Users\\darren\\workspace\\CV\\orings\\Oring8.jpg", 0);

			/* PROCESSING */
			int[] h = hist(img);
			// calculate the mean processing time per frame and display it
			double before = (double) System.nanoTime() / 1000000000;// secs
			drawHist(histim, h);

			// threshold the image
			int t = findHistPeak(h) - 75;// 50
			threshold(img, t);

			// filling in black holes
			dilation(img);
			erode(img);

			// removing noise
			/*erode(img);
			erode(img);
			dilation(img);
			dilation(img);*/

			// Labels all white pixel
			byte labels[] = labelComponents(img);

			// Analyzing regions to see is passed or failed
			boolean passed = regionAnalysis(img, labels);

			/* DISPLAY */
			// convert to color so we can put text into the image using whatever
			// color we want!
			Imgproc.cvtColor(img, out, Imgproc.COLOR_GRAY2BGR);

			double after = (double) System.nanoTime() / 1000000000;// secs
			// write the text string below into the image
			Core.putText(out, "Processing Time: " + String.format("%.4f", after - before) + "'s", new Point(0, 15),
					Core.FONT_HERSHEY_PLAIN, 1, new Scalar(255, 0, 0));
			//passed=true;
			if(passed==true){
				Core.putText(out, "Pass: " + passed, new Point(0, 215), Core.FONT_HERSHEY_PLAIN, 2, new Scalar(0, 255, 0));
			} else {
				Core.putText(out, "Pass: " + passed, new Point(0, 215), Core.FONT_HERSHEY_PLAIN, 2, new Scalar(0, 0, 255));
			}

			jimg = Mat2BufferedImage(out);
			imageHolder.setIcon(new ImageIcon(jimg));
			frame.pack();
			frame.setLocationRelativeTo(null);
			i++;

			if (i == 16) {
				i = 1;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	// ********************************************
	public static boolean regionAnalysis(Mat img, byte[] labels) {
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		
		return false;
	}

	// ********************************************
	// Labels all white pixel
	public static byte[] labelComponents(Mat img) {
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		byte labels[] = new byte[data.length];
		int currentLabel = 50;
		Queue<Integer> q = new LinkedList<Integer>();
		try {
			for (int i = 0; i < data.length; i++) {
				if ((data[i] & 0xff) == 255 && (labels[i] == 0)) {
					labels[i] = (byte) currentLabel;
					q.add(i);
					while (!q.isEmpty()) {
						int pos = q.remove();
						if ((data[pos + 1] & 0xff) == 255 && labels[pos + 1] == 0) {
							labels[pos + 1] = (byte) currentLabel;
							q.add(pos + 1);
						}
						if ((data[pos - 1] & 0xff) == 255 && labels[pos - 1] == 0) {
							labels[pos - 1] = (byte) currentLabel;
							q.add(pos - 1);
						}
						if ((data[pos + img.cols()] & 0xff) == 255 && labels[pos + img.cols()] == 0) {
							labels[pos + img.cols()] = (byte) currentLabel;
							q.add(pos + img.cols());
						}
						if ((data[pos + img.cols() + 1] & 0xff) == 255 && labels[pos + img.cols() + 1] == 0) {
							labels[pos + img.cols() + 1] = (byte) currentLabel;
							q.add(pos + img.cols() + 1);
						}
						if ((data[pos + img.cols() - 1] & 0xff) == 255 && labels[pos + img.cols() - 1] == 0) {
							labels[pos + img.cols() - 1] = (byte) currentLabel;
							q.add(pos + img.cols() - 1);
						}
						if ((data[pos - img.cols()] & 0xff) == 255 && labels[pos - img.cols()] == 0) {
							labels[pos - img.cols()] = (byte) currentLabel;
							q.add(pos - img.cols());
						}
						if ((data[pos - img.cols() - 1] & 0xff) == 255 && labels[pos - img.cols() - 1] == 0) {
							labels[pos - img.cols() - 1] = (byte) currentLabel;
							q.add(pos - img.cols() - 1);
						}
						if ((data[pos - img.cols() + 1] & 0xff) == 255 && labels[pos - img.cols() + 1] == 0) {
							labels[pos - img.cols() + 1] = (byte) currentLabel;
							q.add(pos - img.cols() + 1);
						}
					}currentLabel=+160;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("error: " + e);
		}
		
		for(int i=0; i<data.length; i++){
			if((labels[i] & 0xff) > 50)
			{
				data[i] = 0;
			}
		}
		
		// System.exit(0);
		img.put(0, 0, data);
		return labels;
	}

	// Shrinking the ring back to normal size now that it has no black dots
	// inside of it and also used to remove noise
	public static void erode(Mat img) {
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		byte copy[] = data.clone();
		for (int i = 0; i < data.length; i++) {
			int[] neighbours = { i + 1, i - 1, i - img.cols(), i + img.cols(), i - img.cols() - 1, i - img.cols() + 1,
					i + img.cols() - 1, i + img.cols() + 1 };
			try {
				for (int j = 0; j < neighbours.length; j++) {
					if ((copy[neighbours[j]] & 0xff) == 0) {
						data[i] = (byte) 0;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// e.printStackTrace();
			}
		}
		img.put(0, 0, data);
	}

	// Filling in the black holes within the white ring
	public static void dilation(Mat img) {
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		byte copy[] = data.clone();
		for (int i = 0; i < data.length; i++) {
			int[] neighbours = { i + 1, i - 1, i - img.cols(), i + img.cols(), i - img.cols() - 1, i - img.cols() + 1,
					i + img.cols() - 1, i + img.cols() + 1 };
			try {
				for (int j = 0; j < neighbours.length; j++) {
					if ((copy[neighbours[j]] & 0xff) == 255) {
						data[i] = (byte) 255;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// e.printStackTrace();
			}
		}
		img.put(0, 0, data);
	}

	// Find the highest value in the hist, to get the best threshold value for
	// images
	public static int findHistPeak(int[] hist) {
		int largest = hist[0];
		int largest_gl = 0;
		for (int i = 0; i < hist.length; i++) {
			if (hist[i] > largest) {
				largest = hist[i];
				largest_gl = i;
			}
		}
		return largest_gl;
	}

	public static void threshold(Mat img, int t) {
		/*
		 * threshold the image (img), note here that we need to do an & with
		 * 0xff. this is because Java uses signed two's complement types. The &
		 * operation will give us the pixel in the range we are used to, 0..255
		 */
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		for (int i = 0; i < data.length; i++) {
			int unsigned = (data[i] & 0xff);
			if (unsigned > t)
				data[i] = (byte) 0;
			else
				data[i] = (byte) 255;
		}
		img.put(0, 0, data);
	}

	public static int[] hist(Mat img) {
		int hist[] = new int[256];
		byte data[] = new byte[img.rows() * img.cols() * img.channels()];
		img.get(0, 0, data);
		for (int i = 0; i < data.length; i++) {
			hist[(data[i] & 0xff)]++;
		}
		return hist;
	}

	public static void drawHist(Mat img, int[] hist) {
		// get max hist value for range adjustment
		int max = 0;
		for (int i = 0; i < hist.length; i++) {
			if (hist[i] > max)
				max = hist[i];
		}
		int scale = max / 256;
		for (int i = 0; i < hist.length - 1; i++) {
			// Core.circle(img, new Point(i*2+1,img.rows()-(hist[i]/scale)+1),
			// 1, new Scalar(0,255,0));
			Core.line(img, new Point(i + 1, img.rows() - (hist[i] / scale) + 1),
					new Point(i + 2, img.rows() - (hist[i + 1] / scale) + 1), new Scalar(0, 0, 255));
		}
	}

	public static BufferedImage Mat2BufferedImage(Mat m) {
		// source:
		// http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
		// Fastest code
		// The output can be assigned either to a BufferedImage or to an Image
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;
	}
}