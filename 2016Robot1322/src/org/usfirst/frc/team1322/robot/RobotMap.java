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
	public static final int PWM_Ball_Intake = 3; // Limit is ball in place
	public static final int PWM_Shooter_Release = 4; // Limit to check cam position
	public static final int PWM_Lift_Winch = 5;
	public static final int PWM_Servo_Brake = 9;
	
	// Digital Inputs
	public static final int LIM_Loaded = 4; // Limit for Rear Limit Position
	public static final int LIM_Fired = 1; // Limit for Forward Limit Position
	public static final int LIM_Cam = 3; // Limit for CAM Position
	public static final int LIM_Ball_In = 0; // Limit for Ball Intake
	
	// Analog Inputs
	public static final int POT_ArmLift = 0; // Checks angle of Lift
	
	// USB Controllers
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
}