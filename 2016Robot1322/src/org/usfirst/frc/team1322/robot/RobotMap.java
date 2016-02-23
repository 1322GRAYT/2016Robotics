package org.usfirst.frc.team1322.robot;

/***************************************************
 * 
 * @author ericw
 * Code Reviewed 2/20/16
 *
 */

public class RobotMap {
	
	// CANs
	// TODO: Update ID's on roboRIO
	public static int CAN_D_FL = 1;
	public static int CAN_D_RL = 2;
	public static int CAN_D_FR = 3;
	public static int CAN_D_RR = 4;
	
	// PWMs
	// TODO: Verify PWM Components and Ports
	public static int PWM_A_Intake = 0;
	public static int PWM_A_Pivot = 1;
	public static int PWM_Winch = 2;
	public static int PWM_LoadWinch = 3;
	
	// Relays
	// TODO: Verify Relays Components and Ports
	public static int R_BallIntake = 1;
	
	// Digital Inputs
	// TODO: Verify DI Components and Ports
	public static int LIM_Pivot = 3;
	public static int LIM_LoadWinch = 4;
	
	// Analog Inputs
	// TODO: Verify AI Components and Ports
	public static int POT_ArmLift = 0;
	
	// USB Controllers
	public static int USB_Driver = 0;
	public static int USB_AUX = 1;

}
