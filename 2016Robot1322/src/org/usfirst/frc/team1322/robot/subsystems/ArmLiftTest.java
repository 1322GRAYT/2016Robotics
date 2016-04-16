package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ArmLiftTest extends PIDSubsystem {

    // Initialize your subsystem here
	Victor armTilt;
    AnalogPotentiometer armPot;
	private static double currentLimit = 90;
	
    public ArmLiftTest() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("ArmTilt", 0.05, 0, 0);
    	
    	armTilt = new Victor(RobotMap.PWM_A_Pivot);
    	LiveWindow.addActuator("Arm Tilt", "Arm Tilt Motor", armTilt);
    	
    	armPot = new AnalogPotentiometer(RobotMap.POT_ArmLift, 270, -7); // TODO: Figure this line out
    	LiveWindow.addSensor("Arm Tilt", "Arm Tilt Angle", armPot);
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return armPot.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	armTilt.set(output);
    }
}
