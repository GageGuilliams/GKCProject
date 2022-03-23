// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ElevatorSequence;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class EAngleArm extends CommandBase {

  ElevatorSubsystem elevatorSubsystem;
  Timer timer;

  /** Creates a new AngleArm. */
  public EAngleArm(ElevatorSubsystem elevatorSubsystem) {
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // elevatorSubsystem.angleMotor(0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.get() >= elevatorSubsystem.elevatorAngleTimeEntry.getDouble(0.0));
  }
}
