import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.*;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

public class LaneDetection {
	public static void main(String[]args){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Create and set up the window.
		JFrame frame = new JFrame("OpenCV");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel imageHolder = new JLabel("Starting up!!");
		JLabel edgeDetector = new JLabel();
		JLabel houghLines = new JLabel();
		frame.getContentPane().add(imageHolder);
		frame.getContentPane().add(edgeDetector);
		frame.getContentPane().add(houghLines);
		frame.getContentPane().setLayout(new GridLayout(3,1));
		// Display the window.
		//frame.pack();
		frame.setSize(656, 657);
		//frame.setLocation(50, 50);
		frame.setLocationRelativeTo(null);
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
		
		String video = "C:\\Users\\darren\\workspace\\CV2\\StayingInLane.avi";
		//String video = "http://c-cam.uchicago.edu/mjpg/video.mjpg";
		VideoCapture vCap = new VideoCapture();
		Mat vFrame = new Mat();
		//Rect roi = new Rect(190, 0, 440, 180);
		//Rect roi = new Rect(190, 40, 450, 140);
		Rect roi = new Rect(190, 40, 430, 120);
		//Rect roi = new Rect(0, 0, 640, 180);
		//Rect roi = new Rect(80, 40, 540, 120);

		//vCap.open(video);
		if (!vCap.open(video)){
			System.out.println("Error opening video stream");
			imageHolder.setText("Error opening video stream");
			return;
		}
		
		System.out.println("Stream Opened");
		int f = 0;
		while(true){
			if(vCap.read(vFrame)){
				f++;
				//System.out.println(temp.size());
				//vFrame = temp.submat(roi);
				double before = (double) System.nanoTime() / 1000000000;// secs
				
				//Gray scale image 
				Mat gray = new Mat();
				Imgproc.cvtColor(vFrame, gray, Imgproc.COLOR_BGR2GRAY);
				ImageIcon image = new ImageIcon(Mat2BufferedImage(gray));
				imageHolder.setIcon(image);
				imageHolder.repaint();
				
				//Get the edges from the image
				Mat edge = new Mat();
				//Imgproc.Canny(vFrame, edge, 140, 100);
				Imgproc.Canny(vFrame, edge, 180, 100);
				image = new ImageIcon(Mat2BufferedImage(edge));
				edgeDetector.setIcon(image);
				edgeDetector.repaint();
				
				//TODO
				//TEST VALUES
				//Find the lines in a area of the image 
				Mat lines = new Mat();
				//image in, image out, "" , "", treshold, min line , max line
				Mat temp = edge.submat(roi);
				Imgproc.HoughLinesP(temp, lines, 1, Math.PI / 180, 10, 10, 10);
				//Imgproc.HoughLinesP(edge, lines, 1, Math.PI / 180, 50, 50, 10);
				
				//Draw lines on the image
				double posX = -190;
				double posY = -40;
				for(int i = 0; i < lines.cols(); i++) {
					double[] val = lines.get(0, i);
					Core.line(vFrame, new Point(val[0]-posX, val[1]-posY), new Point(val[2]-posX, val[3]-posY), new Scalar(0, 255, 0), 4);
				}
				
				Core.rectangle(vFrame, new Point(190,40), new Point(620,160), new Scalar(0, 0, 255));
				
				double after = (double) System.nanoTime() / 1000000000;// secs
				// write the text string below into the image
				Core.putText(vFrame, "Processing Time: " + String.format("%.4f", after - before) + "'s frame: "+f, new Point(0, 15),
						Core.FONT_HERSHEY_PLAIN, 1, new Scalar(0, 0, 255));
				image = new ImageIcon(Mat2BufferedImage(vFrame));
				houghLines.setIcon(image);
				houghLines.repaint();
				
				
				
				frame.pack();
				//System.out.println(frame.getSize());
				imageHolder.setText("");
			} else {
				System.out.println("No frame");
				imageHolder.setText("No frame");
				f=0;
				vCap.open(video);
				/*frame.dispose();
				frame.setVisible(true);*/
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static BufferedImage Mat2BufferedImage(Mat m){
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if ( m.channels() > 1 ) {
		    type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels()*m.cols()*m.rows();
		byte [] b = new byte[bufferSize];
		m.get(0,0,b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);  
		return image;
	}
}