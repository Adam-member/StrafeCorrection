package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.OI;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class StrafeCorrection extends Subsystem {
	
	public void CorrectStrafe(){
		RobotMap.drive.arcadeDrive(OI.joystick1.getRawAxis(1), OI.joystick1.getRawAxis(0));
		SmartDashboard.putNumber("frontRightSpeed", RobotMap.frontRight.get());
		SmartDashboard.putNumber("backLeftSpeed", RobotMap.backLeft.get());
		
		SmartDashboard.putNumber("RawAxisY", OI.joystick1.getRawAxis(0));
		SmartDashboard.putNumber("RawAxisX", OI.joystick1.getRawAxis(1));
		
		if(OI.joystick1.getDirectionDegrees() >= RobotMap.gyro.getAngle() + 5 || OI.joystick1.getDirectionDegrees() <= RobotMap.gyro.getAngle() - 5){
			if((Math.abs(OI.joystick1.getDirectionDegrees())) > Math.abs(RobotMap.gyro.getAngle())){
			RobotMap.drive.arcadeDrive(0,1);
			}
			else{
				RobotMap.drive.arcadeDrive(0, -1);
			}
		}
		
		if(RobotMap.gyro.getAngle() )
		
		if(Math.abs(RobotMap.backLeft.get()) > Math.abs(RobotMap.frontRight.get())){
			RobotMap.frontRight.set(RobotMap.frontRight.get());
		}
		else if(Math.abs(RobotMap.backLeft.get()) < Math.abs(RobotMap.frontRight.get())){
			RobotMap.backLeft.set(RobotMap.frontRight.get());
		}
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

