package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.ArmTiltTeleop;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ArmTilt extends Subsystem {
    Victor armTilt;
    
    public ArmTilt(){
    	armTilt = new Victor(RobotMap.PWM_A_Pivot);
  //  	LiveWindow.addActuator("Arm Tilt", "Arm Tilt Motor", armTilt);
    }
    
	public void armPower(double power){
		armTilt.set(power);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ArmTiltTeleop());
    }
}

