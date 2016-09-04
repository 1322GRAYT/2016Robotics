package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonimousMode1 extends CommandGroup {
    
    public  AutonimousMode1() {
    	addSequential(new ArmTiltTimed(1,-0.5));
    	//Passing Through Variable in this order: Pickup Timer, Pickup Power
    	addSequential(new DriveAuton(5, -0.75, 0));
    	//Passing Through Variables in this order: Time Out, Forward Power, Turn Power
    }
}
