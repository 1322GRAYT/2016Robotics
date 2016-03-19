package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor sc_Winch;
	Relay sc_Engage;
	DigitalInput l_Fired, l_Loaded, l_CamPosition;
	
	public ShooterSystem(){
		sc_Winch = new Victor(RobotMap.PWM_Shooter_Winch);
		sc_Engage = new Relay(RobotMap.R_WinchEngage);
		l_Fired = new DigitalInput(RobotMap.LIM_Fired);
		l_Loaded = new DigitalInput(RobotMap.LIM_Loaded);
		l_CamPosition = new DigitalInput(RobotMap.LIM_Cam);
	}
	
	public void SetWinchPower(double power){
		sc_Winch.set(power);
	}
	
	public void SetEngage(Value power){
		sc_Engage.set(power);
	}
	
	public boolean GetFiredLim(){
		return !l_Fired.get();
	}
	
	public boolean GetLoadedLim(){
		return !l_Loaded.get();
	}
	
	public boolean GetCamPosition(){
		return l_CamPosition.get();
	}
	
	public void EngageCam(){
		SetEngage(Value.kForward);
	}
	
	public void StopCam(){
		SetEngage(Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new BallFireTele());
    }

	public void SetWinchEngage() {
		SetWinchPower(-1);
	}
	
	public void StopWinch(){
		SetWinchPower(0);
	}
}

