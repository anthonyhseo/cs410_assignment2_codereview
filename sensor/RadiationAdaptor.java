package sensor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class RadiationAdaptor implements ReadSensor {
	private RadiationSensor rs = new RadiationSensor();
	private double value;
	private String report;

	@Override
	public String readValueStatus() {
		value = rs.getRadiationValue();
		report = rs.getStatusInfo();
		return value + " --> " + report;
	}

	@Override
	public JPanel getPanel() {
		JPanel  radiationPnl = new JPanel(null);
		radiationPnl.setBorder(new TitledBorder("Radiation"));
	
		String reading = readValueStatus();
		JLabel readingLabel = new JLabel(reading);
		readingLabel.setLocation(20, 130);
		readingLabel.setSize(250, 30);
		
		int xval = (int) (10 + value * 200 / 5);
		Color bgColor = Color.GREEN;
		if (report.equals("DANGER")) bgColor = Color.RED;
		else if (report.equals("CRITICAL")) bgColor = Color.YELLOW;
		
		JPanel rect = new JPanel();
		rect.setBackground(bgColor);
		rect.setLocation(20, 30);
		rect.setSize(xval, 100);
		
		radiationPnl.add(rect);
		radiationPnl.add(readingLabel);
		return radiationPnl;
	}
	
	
}
