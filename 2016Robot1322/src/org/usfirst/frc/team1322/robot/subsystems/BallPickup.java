package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallMoveTeleop;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallPickup extends Subsystem {
    	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Relay ballSuck;
	Victor ballMove;
	//Ball Sucker
	public BallPickup() {
		ballSuck = new Relay(1);
		ballMove = new Victor(5);
		}
	
	public void ballSuckOn() {
		ballSuckPower(Value.kOn);
	}
	public void ballSuckOff() {
		ballSuckPower(Value.kOff);
	}
	//Ball Mover
	public void ballMoveUp() {
		ballMovePower(1);
	}
	public void ballMoveDown() {
		ballMovePower(-1);
	}
	public void ballMoveStop() {
		ballMovePower(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallMoveTeleop());
    }

	public void ballMovePower(double pickupPower) {
		// TODO Auto-generated method stub
		ballMove.set(pickupPower);
	}
	public void ballSuckPower(Value suckPower) {
		ballSuck.set(suckPower);
	}
}

