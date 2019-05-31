package sensor;


import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PressureAdaptor implements ReadSensor {
	private PressureSensor ps = new PressureSensor();
	private double value;
	private String report;
	
	@Override
	public String readValueStatus() {
		value = ps.readValue();
		report = ps.getReport();
		return value + " --> " + report;
		
	}

	@Override
	public JPanel getPanel() {
		JPanel  pressurePnl = new JPanel(null);
		pressurePnl.setBorder(new TitledBorder("Pressure"));

		String reading = readValueStatus();
		JLabel readingLabel = new JLabel(reading);
		readingLabel.setLocation(20, 130);
		readingLabel.setSize(250, 30);
		
		int xval = (int) (10 + value * 200 / 6.58);
		Color bgColor = Color.GREEN;
		if (report.equals("DANGER")) bgColor = Color.RED;
		else if (report.equals("CRITICAL")) bgColor = Color.YELLOW;
		
		JPanel rect = new JPanel();
		rect.setBackground(bgColor);
		rect.setLocation(20, 30);
		rect.setSize(xval, 100);
		
		pressurePnl.add(rect);
		pressurePnl.add(readingLabel);
		
		return pressurePnl;
	}

}
