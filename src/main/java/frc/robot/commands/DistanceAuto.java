package frc.robot.commands;



// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DistanceAuto extends CommandBase {

  private final DriveTrain _driveTrain;
  private double pos;
  /** Creates a new TankDrive. */
  public DistanceAuto(DriveTrain dt, double pos) {
    // Use addRequirements() here to declare subsystem dependencies.
    _driveTrain = dt;
    this.pos = pos;
    addRequirements(_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _driveTrain.setPos(0);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_driveTrain.getPos() < pos){
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
    if(_driveTrain.getPos() < pos) {
      return true;
    }
    return false;
  }
}