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
	public static final int CAN_D_FL = 1;
	public static final int CAN_D_RL = 2;
	public static final int CAN_D_FR = 3;
	public static final int CAN_D_RR = 4;
	
	// PWMs
	// TODO: Verify PWM Components and Ports
	public static final int PWM_A_Pivot = 2; // Only limit is POT
	public static final int PWM_Shooter_Winch = 4; // Limit is Fired and Not
	public static final int PWM_Lift_Winch2 = 6; // Limit is Fired and Not
	public static final int PWM_Lift_Winch = 3; // No Limit
	public static final int PWM_Intake_UD = 5; // Up Down Limit
	public static final int PWM_Servo_Rel_Left = 6;
	public static final int PWM_Servo_Rel_Right = 7;
	
	// Relays
	// TODO: Verify Relays Components and Ports
	public static final int R_BallIntake = 1; // No Limit
	public static final int R_WinchEngage = 0; // Limit to check cam position
	
	// Digital Inputs
	// TODO: Verify DI Components and Ports
	public static final int LIM_Cam = 3; // Limit for CAM Position
	public static final int LIM_Fired = 1; // Limit for Forward Limit Position
	public static final int LIM_Loaded = 0; // Limit for Rear Limit Position
	public static final int LIM_Intake_Up = 4;
	public static final int LIM_Intake_Down = 5;
	
	// Analog Inputs
	// TODO: Verify AI Components and Ports
	public static final int POT_ArmLift = 0; // Checks angle of Lift
	
	// USB Controllers
	public static final int USB_Driver = 0;
	public static final int USB_AUX = 1;
	

}
