package org.usfirst.frc.team1322.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon EncoderedTalon;
    private int encoderValue;
    
    
    DriveSubsystem(){
    	EncoderedTalon = new CANTalon(1);
    	DriveSystem = new RobotDrive(EncoderedTalon, new CANTalon(2), new CANTalon(3), new CANTalon(4));
    	
    }
     
    public void ArcadeDrive(double forwardPower, double turnPower) {
    	DriveSystem.arcadeDrive(forwardPower, turnPower);
    }
    
    private void updateEncoder() {
    	encoderValue = EncoderedTalon.getEncPosition();
    }
    
    public int getEncoderPosition() {
    	updateEncoder();
    	return encoderValue;
    }
    
    public void resetEncoder() {
    	encoderValue = 0;
    	EncoderedTalon.setEncPosition(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
