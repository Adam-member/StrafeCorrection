package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 *
 */
public class AdvancedNetworkTablesSample extends Subsystem {
	NetworkTable table;
	NetworkTableEntry xTable;
	NetworkTableEntry yTable;
	public void Network(){
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		table = inst.getTable("datatable");
		xTable = table.getEntry("x");
		yTable = table.getEntry("y");
	
	
	double x = 0;
	double y = 0;
	
	xTable.setDouble(x);
	yTable.setDouble(y);
	
	x += 0.05;
	y += 1.0;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

