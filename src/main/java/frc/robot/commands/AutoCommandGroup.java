// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HoodSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransportSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoOneCommandGroup. */
  public AutoCommandGroup(DriveSubsystem driveSubsystem, HoodSubsystem hoodSubsystem, ShooterSubsystem shooterSubsystem, TransportSubsystem transportSubsystem, IntakeSubsystem intakeSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    if(Robot.autoNumber.getDouble(-1738) == 1){
      addCommands(
        new ShootCommand(shooterSubsystem, true, 3),
        new ParallelCommandGroup(
          new TransportCommand(transportSubsystem, true, 2),
          new ShootCommand(shooterSubsystem, true, 2)
        ),
        new WaitTimeCommand(1),
        // new DirectionalDriveCommand(driveSubsystem, new Translation2d(-0.4, 0.1), 1),
        new DriveDistanceCommand(driveSubsystem, new Translation2d(-0.4, 0.2), 1, 2),
        new WaitTimeCommand(1),
        new TurnToAngle(driveSubsystem, 165, 1, 3),
        // new RotationalDriveCommand(driveSubsystem, 0.5, 5.6),
        new WaitTimeCommand(1),
        new ParallelCommandGroup(
          // new DirectionalDriveCommand(driveSubsystem, new Translation2d(0.2, 0), 1),
          new DriveDistanceCommand(driveSubsystem, new Translation2d(0.4, 0), 1, 2),
          new IntakeCommand(intakeSubsystem, true, 3)
        ),
        new WaitTimeCommand(1),
        new TurnToAngle(driveSubsystem, -165, 1, 3),
        // new RotationalDriveCommand(driveSubsystem, 0.5, 5),
        new WaitTimeCommand(1),
        new DirectionalDriveCommand(driveSubsystem, new Translation2d(0.4, 0), 2), 
        new ShootCommand(shooterSubsystem, true, 3),
        new ParallelCommandGroup(
          new TransportCommand(transportSubsystem, true, 2),
          new ShootCommand(shooterSubsystem, true, 2)
        )
      );
    } else if(Robot.autoNumber.getDouble(-1738) == 2){
      addCommands(
        
        );
    } else if(Robot.autoNumber.getDouble(-1738) == 3){
      addCommands(
        new ShootCommand(shooterSubsystem, true, 3),
        new ParallelCommandGroup(
          new TransportCommand(transportSubsystem, true, 2),
          new ShootCommand(shooterSubsystem, true, 2)
        ),
        new WaitTimeCommand(1),
        new DirectionalDriveCommand(driveSubsystem, new Translation2d(0.4, 0.1), 2),
        new WaitTimeCommand(1),
        new TurnToAngle(driveSubsystem, 185, 1, 3),
        // new RotationalDriveCommand(driveSubsystem, 0.5, 5.6),
        new WaitTimeCommand(1),
        new ParallelCommandGroup(
          new DirectionalDriveCommand(driveSubsystem, new Translation2d(0.4, 0), 1),
          new IntakeCommand(intakeSubsystem, true, 3)
        ),
        new WaitTimeCommand(1),
        new TurnToAngle(driveSubsystem, -185, 1, 3),
        // new RotationalDriveCommand(driveSubsystem, 0.5, 5),
        new WaitTimeCommand(1),
        new DirectionalDriveCommand(driveSubsystem, new Translation2d(0.4, 0), 2), 
        new ShootCommand(shooterSubsystem, true, 3),
        new ParallelCommandGroup(
          new TransportCommand(transportSubsystem, true, 2),
          new ShootCommand(shooterSubsystem, true, 2)
        )
        );
    } else if(Robot.autoNumber.getDouble(-1738) == 4){
      addCommands(
        
        );
    } else{
      addCommands(
        
        );
    }
    System.out.println(Robot.autoNumber.getDouble(-1738));

  }
}