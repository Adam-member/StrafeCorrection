package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sonar extends Subsystem {
	
	public void getDistance(){
		//SmartDashboard.putNumber("VoltageToTarget", RobotMap.sonarUnit.getVoltage());
		double Voltage = RobotMap.sonarUnit.getVoltage();
		double VoltsPerInch = RobotMap.sonarUnit.getVoltage() / 512;
		double Distance = Voltage / VoltsPerInch;
		
		SmartDashboard.putNumber("Voltage", Voltage);
		SmartDashboard.putNumber("VoltsPerInch", VoltsPerInch);
		SmartDashboard.putNumber("Distance", Distance);
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

