package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.commands.BallPickupTeleop;

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
	
	Victor ballMove;
	public BallPickup() {

		ballMove = new Victor(5);
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
        setDefaultCommand(new BallPickupTeleop());
    }

	public void ballMovePower(double pickupPower) {
		// TODO Auto-generated method stub
		ballMove.set(pickupPower);
		setDefaultCommand(new BallPickupTeleop());
	}
}



