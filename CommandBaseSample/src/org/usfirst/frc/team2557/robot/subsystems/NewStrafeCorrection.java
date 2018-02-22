package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NewStrafeCorrection extends Subsystem {
	private double directionDegrees = OI.joystick1.getDirectionDegrees();
	private double gyroAngle = RobotMap.gyro.getAngle();
	
	private boolean offSet = false;
	
	public void CorrectIt(){
		if((directionDegrees + gyroAngle >= gyroAngle + 10) || (directionDegrees + gyroAngle <= gyroAngle - 10)){
			offSet = true;
		}
		if(offSet = true){
			if(directionDegrees + gyroAngle >= gyroAngle + 10){
				RobotMap.drive.arcadeDrive(OI.joystick1.getRawAxis(1), OI.joystick1.getRawAxis(0) + 0.01);
			}
			else{
				RobotMap.drive.arcadeDrive(OI.joystick1.getRawAxis(1), OI.joystick1.getRawAxis(0) - 0.01);
			}
		}
	
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

