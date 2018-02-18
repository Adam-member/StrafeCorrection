package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sonar extends Subsystem {
	
	public void getDistance(){
		//boolean Pulse = RobotMap.digSonarUnit();
		
		//SmartDashboard.putNumber("VoltageToTarget", RobotMap.sonarUnit.getVoltage());
		double Voltage = RobotMap.sonarUnit.getAverageVoltage();
		//double Voltage = RobotMap.sonarUnit.getVoltage();
		double VoltsPerInch = Voltage * .0040; // For 3.3vdc, .0064, 5vdc, .0098
		double Distance = VoltsPerInch / 12;
		
		
		SmartDashboard.putNumber("Voltage", Voltage);
		SmartDashboard.putNumber("VoltsPerInch", VoltsPerInch);
		SmartDashboard.putNumber("Distance (ft)", Distance);
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

