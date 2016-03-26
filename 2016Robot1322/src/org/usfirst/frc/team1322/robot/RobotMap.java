package org.usfirst.frc.team1322.robot;

/***************************************************
 * 
 * @author ericw
 * Code Reviewed 2/20/16
 *
 */

public class RobotMap {
	// CANs
	public static final int CAN_D_FL = 1;
	public static final int CAN_D_RL = 2;
	public static final int CAN_D_FR = 3;
	public static final int CAN_D_RR = 4;
	
	// PWMs
	public static final int PWM_A_Pivot = 2; // Only limit is POT
	public static final int PWM_Shooter_Winch = 3; // Limit is Fired and Not
	public static final int PWM_Shooter_Release = 4; // Limit to check cam position
	public static final int PWM_Lift_Winch = 5;
	public static final int PWM_Servo_Rel_Left = 6;
	public static final int PWM_Servo_Rel_Right = 7;
	public static final int PWM_Servo_Ball_Grab_Left = 8;
	public static final int PWM_Servo_Ball_Grab_Right = 9;
	
	// Digital Inputs
	public static final int LIM_Loaded = 0; // Limit for Rear Limit Position
	public static final int LIM_Fired = 1; // Limit for Forward Limit Position
	public static final int LIM_Cam = 3; // Limit for CAM Position
	
	// Analog Inputs
	public static final int POT_ArmLift = 0; // Checks angle of Lift
	
	// USB Controllers
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
}