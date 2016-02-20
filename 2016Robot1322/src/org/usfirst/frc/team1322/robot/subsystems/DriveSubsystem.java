package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.TeleopDriveSystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    private RobotDrive DriveSystem;
    private CANTalon m_SpeedController_FL, m_SpeedController_RL, m_SpeedController_FR, m_SpeedController_RR;
    private int encoderValue;
    private int setPosition;
    private boolean autonActivated;
    private final static double scaleFactor = 1.0;
    
    
    public DriveSubsystem(){
    	m_SpeedController_FL = new CANTalon(1);
    	m_SpeedController_RL = new CANTalon(2);
    	m_SpeedController_FR = new CANTalon(3);
    	m_SpeedController_RR = new CANTalon(4);
    	DriveSystem = new RobotDrive(m_SpeedController_FL, m_SpeedController_RL,
    			m_SpeedController_FR, m_SpeedController_RR);
    	
    }
     
    public void ArcadeDrive(double forwardPower, double turnPower) {
    	DriveSystem.arcadeDrive(forwardPower, turnPower);
    }
    
	public void Stop() {
		ArcadeDrive(0, 0);
	}
    
    private void updateEncoder() {
    	encoderValue = m_SpeedController_FL.getEncPosition();
    }
    
    public int getEncoderPosition() {
    	updateEncoder();
    	return encoderValue;
    }

    public void setSafety(boolean safety){
    	autonActivated = safety;
    	DriveSystem.setSafetyEnabled(safety);
    }
    
    public void setPID(double Kp, double Ki, double Kd){
    	m_SpeedController_FL.setPID(Kp, Ki, Kd);
    }
    
    public void setAutonMode(){
    	setSafety(false);
    	m_SpeedController_FL.setControlMode(TalonControlMode.Position.value);
    	m_SpeedController_FL.set(0);
    	m_SpeedController_RL.setControlMode(TalonControlMode.Follower.value);
    	m_SpeedController_RL.set(m_SpeedController_FL.getDeviceID());
    	m_SpeedController_FR.setControlMode(TalonControlMode.Follower.value);
    	m_SpeedController_FR.set(m_SpeedController_FL.getDeviceID());
    	m_SpeedController_RR.setControlMode(TalonControlMode.Follower.value);
    	m_SpeedController_RR.set(m_SpeedController_FL.getDeviceID());
    }
    
    public void deactivateAutonMode(){
    	m_SpeedController_FL.setControlMode(TalonControlMode.Voltage.value);
    	m_SpeedController_FR.setControlMode(TalonControlMode.Voltage.value);
    	m_SpeedController_RL.setControlMode(TalonControlMode.Voltage.value);
    	m_SpeedController_RR.setControlMode(TalonControlMode.Voltage.value);
    	setSafety(true);
    	Stop();
    }
    
    public void resetEncoder() {
    	encoderValue = 0;
    	m_SpeedController_FL.setEncPosition(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDriveSystem());
    }

	public void setPosition(double driveToPosition) {
		// TODO Auto-generated method stub
		setPosition = (int)(driveToPosition / scaleFactor);
		if (autonActivated) m_SpeedController_FL.set(setPosition);
		
	}

	public int getError() {
		return (int)m_SpeedController_FL.getError();
	}

}
