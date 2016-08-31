package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TeleopDriveSystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_CAN_D_FL, m_CAN_D_RL, m_CAN_D_FR, m_CAN_D_RR;
    
    
    public DriveSubsystem(){
    	m_CAN_D_FL = new CANTalon(RobotMap.CAN_D_FL);
    	m_CAN_D_RL = new CANTalon(RobotMap.CAN_D_RL);
    	m_CAN_D_FR = new CANTalon(RobotMap.CAN_D_FR);
    	m_CAN_D_RR = new CANTalon(RobotMap.CAN_D_RR);
    	DriveSystem = new RobotDrive(m_CAN_D_FL, m_CAN_D_RL,
    			m_CAN_D_FR, m_CAN_D_RR);
    	
    	LiveWindow.addActuator("Robot Drive", "Front Left", m_CAN_D_FL);
    	LiveWindow.addActuator("Robot Drive", "Rear Left", m_CAN_D_RL);
    	LiveWindow.addActuator("Robot Drive", "Front Right", m_CAN_D_FR);
    	LiveWindow.addActuator("Robot Drive", "Rear Right", m_CAN_D_RR);
    	
    }
     
    public void ArcadeDrive(double forwardPower, double turnPower) {
    	DriveSystem.arcadeDrive(forwardPower, turnPower);
    	System.out.println(forwardPower);
    }
    
	public void Stop() {
		ArcadeDrive(0, 0);
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDriveSystem());
    }

	public int getError() {
		return (int)m_CAN_D_FL.getError();
	}
	

}
