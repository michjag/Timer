package timer;


import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Timer implements Runnable {
	private JFrame jFrame = new JFrame();		
	private Date nowTime;
	private Thread thread;
	private int pause = 100;
	private JLabel lblTime;
	private JLabel lblDateLabel;
	int dayOfYear = LocalDate.now().getDayOfYear();
	int dayToEndOfYear = 365 - dayOfYear;
	private JLabel lblDayOfThe;
	private JLabel lblDayToThe;
	
	public Timer()
	{
	jFrame.setResizable(false);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setSize(300, 300);
	jFrame.setTitle("Timer");
	jFrame.getContentPane().setLayout(null);
	
	lblTime = new JLabel("time label");
	lblTime.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblTime.setBounds(10, 11, 143, 41);
	jFrame.getContentPane().add(lblTime);
	
	lblDateLabel = new JLabel("date label");
	lblDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblDateLabel.setBounds(10, 63, 182, 37);
	jFrame.getContentPane().add(lblDateLabel);
	
	lblDayOfThe = new JLabel("day of the year");
	lblDayOfThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblDayOfThe.setBounds(10, 111, 193, 41);
	lblDayOfThe.setText("Day of the year: " + dayOfYear);
	jFrame.getContentPane().add(lblDayOfThe);
	
	lblDayToThe = new JLabel("Day to the end of the year:");
	lblDayToThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblDayToThe.setBounds(10, 163, 221, 25);
	lblDayToThe.setText("Day to the end of the year: " + dayToEndOfYear);
	jFrame.getContentPane().add(lblDayToThe);
	jFrame.setVisible(true);
		
	}

	public void start()
	{
		if (thread == null)
			thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		while (thread == Thread.currentThread()) 
		{
			nowTime = new Date();
			SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");	
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			lblTime.setText(formatTime.format(nowTime));
			lblDateLabel.setText(formatDate.format(nowTime));

			try 
			{
				thread.sleep(pause);
			}
			catch(InterruptedException e)
			{
				System.out.println("catch exception");
			}
		}
		
	}
	
}
