package frc.robot.commands;



// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class TimedAuto extends CommandBase {

  private final DriveTrain _driveTrain;
  private final Timer _time;
  /** Creates a new TankDrive. */
  public TimedAuto(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    _driveTrain = dt;
    _time = new Timer();
    addRequirements(_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _time.start();
    _time.reset();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_driveTrain.getPos() < 1){
      _driveTrain.tankDrive(0.6, 0.6);
    }
    else{
      _driveTrain.tankDrive(0, 0);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}