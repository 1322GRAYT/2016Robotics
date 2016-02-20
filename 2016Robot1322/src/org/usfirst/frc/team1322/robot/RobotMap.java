package org.usfirst.frc.team1322.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// CANs
	public static int CAN_D_FL = 1;
	public static int CAN_D_RL = 2;
	public static int CAN_D_FR = 3;
	public static int CAN_D_RR = 4;
	
	// PWMs
	public static int PWM_A_Intake = 0;
	public static int PWM_A_Pivot = 1;
	public static int PWM_Winch = 2;
	public static int PWM_LoadWinch = 3;
	
	// Relays
	public static int R_BallIntake = 1;
	
	// Digital Inputs
	public static int LIM_Pivot = 3;
	public static int LIM_LoadWinch = 4;
	
	// Analog Inputs
	public static int POT_ArmLift = 0;
	
	// USB Controllers
	public static int USB_Driver = 0;
	public static int USB_AUX = 1;

}
