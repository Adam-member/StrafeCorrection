package org.usfirst.frc.team2557.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_TalonSRX frontLeft;
	public static WPI_TalonSRX backLeft;
	public static WPI_TalonSRX frontRight;
	public static WPI_TalonSRX backRight;
	
	public static Gyro gyro;
	
	public static SpeedControllerGroup leftMotors;
	public static SpeedControllerGroup rightMotors;
	
	public static DifferentialDrive drive;
	
	public static void init(){
		frontLeft = new WPI_TalonSRX(7);
		backLeft = new WPI_TalonSRX(6);
		frontRight = new WPI_TalonSRX(8);
		backRight = new WPI_TalonSRX(5);
		
		leftMotors = new SpeedControllerGroup(frontLeft, backLeft);
		rightMotors = new SpeedControllerGroup(backLeft, backRight);
		
		drive = new DifferentialDrive(leftMotors, rightMotors);
	}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
