package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.ArmTiltTeleop;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

// TODO: Investigate PID control for this subsystem

public class ArmTilt extends Subsystem {
    Victor armTilt;
    AnalogPotentiometer armPot;
	private static double currentLimit = 90;
    
    public ArmTilt(){
    	armTilt = new Victor(RobotMap.PWM_A_Pivot);
    	armPot = new AnalogPotentiometer(RobotMap.POT_ArmLift, 90, 30); // TODO: Figure this line out
    }
    
    public void armTiltPower(double power) {
    	// TODO: Insert Clause to go past 90 deg
    	if ((armPot.get() > currentLimit && power > 0) || (armPot.get() > 0 && power < 0)){
    		armTiltStop();
    	}
    	else {
    		armTilt.set(power);
    	}
    }
    
    public void setArmLimit(){
    	currentLimit = 120; // TODO: Investigate how far the tilt needs to go.
    }
    
    public void armTiltUp() {
    	armTiltPower(1);
    }
    public void armTiltStop() {
    	armTilt.set(0);
    }
    public void armTiltDown() {
    	armTiltPower(-1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArmTiltTeleop());
    }
}

