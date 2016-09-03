package org.usfirst.frc.team1322.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CANs
	public static final int CAN_D_FL = 1;
	public static final int CAN_D_RL = 2;
	public static final int CAN_D_FR = 3;
	public static final int CAN_D_RR = 4;
	public static final int CAN_Lift_WinchR = 5;
	public static final int CAN_Lift_WinchL = 6;
	public static final int CAN_Ball_Holder = 7;
	public static final int CAN_A_Pivot = 8;
	
	//PWMs
	public static final int PWM_Ball_Intake = 0;
	
	//Digital Inputs
	
	//Analog Inputs
	//None
	
	// USB Controllers
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
}
