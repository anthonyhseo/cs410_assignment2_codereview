package sensor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		ReadSensor ps = new PressureAdaptor();
		ReadSensor rs = new RadiationAdaptor();
		ReadSensor ts = new TemperatureAdaptor();
		
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		
		JPanel pressurePnl = ps.getPanel();
		add(pressurePnl);
		
		JPanel radiationPnl = rs.getPanel();
		add(radiationPnl);
		
		JPanel temperaturePnl = ts.getPanel();
		add(temperaturePnl);
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}

}
