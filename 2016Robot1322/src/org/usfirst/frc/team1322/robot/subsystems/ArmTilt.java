package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallPickupTeleop;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmTilt extends Subsystem {
    Victor armTilt;
    AnalogPotentiometer armPot;
    AnalogInput armPotInput;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public ArmTilt(){
    	armTilt = new Victor(2);
    	armPot = new AnalogPotentiometer(0, 90, 30);
    	AnalogInput ai = new AnalogInput(1);
    	armPot = new AnalogPotentiometer(ai, 360, 30);
    }
    public void armTiltPower(double power) {
    	if (armPot.get() < 90){
    		armTilt.set(power);
    	}
    	else {
    		armTilt.set(0);
    	}
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

