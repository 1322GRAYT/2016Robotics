package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonNoArmDrop extends CommandGroup {
    
    public  AutonNoArmDrop() {
    	addSequential(new DriveAuton(5, -0.75, 0));
    }
}
