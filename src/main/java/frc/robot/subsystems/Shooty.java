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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Shooty extends SubsystemBase {


private Spark intakeMotorTop;
private Spark intakeMotorBottom;
private double startRamp;
private Timer timer;


    public Shooty() {
        intakeMotorTop = new Spark(Constants.Intake.intake_Motor_ID_Top);
        intakeMotorBottom = new Spark(Constants.Intake.intake_Motor_ID_Bottom);
        timer = new Timer();
        timer.start();
    }

    
    public void topIntake(double speed){
        intakeMotorTop.set(speed * Constants.Intake.IntakeSpeed);
    }
    public void bottomIntake(double speed){
        intakeMotorBottom.set(speed * Constants.Intake.IntakeSpeed);
    }

    public void shoot(){
        var currentTime = timer.get();
        topShoot(1*Constants.Intake.IntakeSpeed);
        //System.out.println("Start time: " + startRamp);
        //System.out.println("Current time: " + currentTime);
        if(0 == startRamp) {
            startRamp = currentTime;
        }
            
        if(currentTime - startRamp  >= Constants.Intake.waitingNumber){
            intakeMotorBottom.set(1*Constants.Intake.IntakeSpeed);
        }
    }  
    
    public void topShoot(double speed){
        intakeMotorTop.set(speed * Constants.Intake.IntakeSpeed);
    }
    public void bottomShoot(double speed){
        intakeMotorBottom.set(-speed * Constants.Intake.IntakeSpeed);
    }

    public void reset(){
        startRamp = 0;
        timer.reset();
        intakeMotorTop.set(0);
        intakeMotorBottom.set(0);
    }




    
    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }


}

