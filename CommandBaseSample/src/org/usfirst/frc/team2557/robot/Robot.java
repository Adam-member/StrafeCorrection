
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.commands.ExampleCommand;
import org.usfirst.frc.team2557.robot.commands.GetLatencyCommand;
import org.usfirst.frc.team2557.robot.commands.MemoryLogCommand;
import org.usfirst.frc.team2557.robot.commands.DriveCommand;
import org.usfirst.frc.team2557.robot.commands.CorrectStrafeCommand;
import org.usfirst.frc.team2557.robot.subsystems.AutoDrive;
import org.usfirst.frc.team2557.robot.subsystems.Chassis;
import org.usfirst.frc.team2557.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2557.robot.subsystems.GetLatency;
import org.usfirst.frc.team2557.robot.subsystems.StrafeCorrection;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team2557.robot.commands.AutoCommandGroup;
import org.usfirst.frc.team2557.robot.commands.AutoDriveCommand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static GetLatency getLatency;
	public static AutoDrive autoDrive;
	public static Chassis chassis;
	public static StrafeCorrection strafeCorrection;

	Command autonomousCommand;
	Command GetLatencyCommand;
	Command AutoDriveCommand;
	Command MemoryLogCommand;
	Command DriveCommand;
	Command CorrectStrafeCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		SmartDashboard.putString("RobotStart", "RobotStarted");
		
		getLatency = new GetLatency();
		autoDrive = new AutoDrive();
		strafeCorrection = new StrafeCorrection();
		
		CorrectStrafeCommand = new CorrectStrafeCommand();
		GetLatencyCommand = new GetLatencyCommand();
		MemoryLogCommand = new MemoryLogCommand();
		DriveCommand = new DriveCommand();
		AutoDriveCommand = new AutoDriveCommand(0, 0, 0);
		chooser.addDefault("Default Auto", new AutoCommandGroup());
		chooser.addObject("My Auto", new AutoCommandGroup());
		SmartDashboard.putData("Auto mode", chooser);
		
		oi = new OI();
		OI.init();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
//		if (autonomousCommand != null)
//			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		SmartDashboard.putString("gotToRobot", "Hi there");		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		CorrectStrafeCommand.start();
//		DriveCommand.start();
//		SmartDashboard.putString("gotToPeriodic", "Good deal");
//		GetLatencyCommand.start();
//		SmartDashboard.putString("gotPastFirst", "Past!");
//		MemoryLogCommand.start();
//		System.out.println(DriverStation.getInstance().getMatchTime());
//		SmartDashboard.putNumber("Match time", DriverStation.getInstance().getMatchTime());
//		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
