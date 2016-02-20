package org.usfirst.frc.team1322.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int leftDrives = 1;
	public static int righDrives = 2;
	public static int armPivot = 3;
	public static int climbWinch = 4;
	public static int loadWinch = 5;
	public static int ballIntake = 1;
	public static int ballMove = 1;
	public static int leftEncoder = 1;
	public static int rightEncoder = 2;
	public static int pivotLimit = 3;
	public static int loadWinchLimit = 4;

}
