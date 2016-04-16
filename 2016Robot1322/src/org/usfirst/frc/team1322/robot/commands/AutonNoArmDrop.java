package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonNoArmDrop extends CommandGroup {
    
    public  AutonNoArmDrop() {
    	addSequential(new DriveAuton(2.75, -1.0, 0));
    }
}