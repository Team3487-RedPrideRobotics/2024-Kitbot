package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

    
public class Drivetrain extends SubsystemBase {

    
    private Spark left_Motor;

<<<<<<< Updated upstream
    private Spark right_Motor;
   
=======

    private Spark right_Back_Motor;
    private Spark right_Front_Motor;

    private Timer timer;
    public int counter = 0;

>>>>>>> Stashed changes

    private DifferentialDrive differentialDrive;


    
    public Drivetrain() {
        left_Back_Motor = new Spark(Constants.DriveConstants.left_Drive_ID);

        right_Back_Motor = new Spark(Constants.DriveConstants.right_Drive_ID);
        right_Back_Motor.setInverted(Constants.DriveEdits.right_Drive_Inverse);


        differentialDrive = new DifferentialDrive(left_Motor, right_Motor);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);


    }

    public void arcadeDrive(double leftSpeed, double turning){
        /* 
        if(counter == 0){
            timer.reset();
            counter++;
        } else if(timer.get() <= 2.0){
            differentialDrive.arcadeDrive(-leftSpeed*Constants.DriveEdits.DriveSpeed * timer.get()/2.02, -turning*Constants.DriveEdits.TurningSpeed * timer.get()/2.02);
        } else if(timer.get() >= 2.0){
            differentialDrive.arcadeDrive(-leftSpeed*Constants.DriveEdits.DriveSpeed, -turning*Constants.DriveEdits.TurningSpeed);
        }
        */
        differentialDrive.arcadeDrive(-leftSpeed*Constants.DriveEdits.DriveSpeed, -turning*Constants.DriveEdits.TurningSpeed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

