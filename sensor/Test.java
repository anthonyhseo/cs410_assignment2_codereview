package sensor;

public class Test {
	
	
	public static void main(String[] args) {
//		PressureSensor ps = new PressureSensor();
//		TemperatureSensor ts = new TemperatureSensor();
//		RadiationSensor rs = new RadiationSensor();
//		
//		System.out.println("Pressure value: " + ps.readValue());
//		System.out.println("Pressure indicator: " + ps.getReport());
//		
//		System.out.println("Temperature value: " + ts.senseTemperature());
//		System.out.println("Temperature indicator: " + ts.getTempReport());
//		
//		System.out.println("Radiation value: " + rs.getRadiationValue());
//		System.out.println("Radiation indicator: " + rs.getStatusInfo());
		
		ReadSensor ps = new PressureAdaptor();
		ReadSensor rs = new RadiationAdaptor();
		ReadSensor ts = new TemperatureAdaptor();
		System.out.println(ps.readValueStatus());
		System.out.println(rs.readValueStatus());
		
	}
}
