// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


public class Shooty extends SubsystemBase {


private Spark intakeMotorOne;
//private Spark intakeMotorTwo;

    public Shooty() {
        intakeMotorOne = new Spark(Constants.Intake.intake_Motor_ID);
        //intakeMotorTwo = new Spark(Constants.Intake.intake_Motor_ID);

        intakeMotorOne.setSafetyEnabled(true);
        intakeMotorOne.setExpiration(0.1);
    }

    
    public void intake(double speed){
        intakeMotorOne.set(speed * Constants.Intake.IntakeSpeed);

    }

    public void shoot(double speed){
        intakeMotorOne.set(speed * Constants.Intake.IntakeSpeed);

    }


    
    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }


}

