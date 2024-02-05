package frc.robot.commands;




import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.ColorSensor;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooty;

public class Teleop extends Command {


    private Drivetrain m_drive;
    private Shooty m_intake;
    private ColorSensor m_colorSensor;
    XboxController drive_controller;
    XboxController operator_Controller;

    public Teleop(Drivetrain drive, Shooty intake){

        m_drive = drive;
        addRequirements(m_drive);

        m_intake = intake;
        addRequirements(m_intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drive_controller = RobotContainer.getInstance().getDriveController();
        operator_Controller = RobotContainer.getInstance().getOperatorController();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
              
        
        //System.out.println("Distance: " + m_colorSensor.returnProximity());

        //drive code, no sprinting just get good
<<<<<<< Updated upstream

        if(drive_controller.getLeftY() >= 0.05 || drive_controller.getLeftY() <= -0.05 || drive_controller.getRightY() >= 0.05 || drive_controller.getRightY() <= -0.05) {
            m_drive.TankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        } else {
            m_drive.TankDrive(0, 0);
=======
        if(drive_controller.getLeftY() >= 0.05 || drive_controller.getLeftY() <= -0.05 || 
        drive_controller.getRightX() >= 0.05 || drive_controller.getRightX() <= -0.05)
        {
            m_drive.arcadeDrive(drive_controller.getLeftY(), drive_controller.getRightX()); 
        } else {
            m_drive.arcadeDrive(0, 0);
            m_drive.counter = 0;
>>>>>>> Stashed changes
        }


        if(operator_Controller.getRightTriggerAxis() >= 0.01){
            m_intake.shoot();
        } 
        else if(operator_Controller.getLeftTriggerAxis() >= 0.01){

            m_intake.bottomIntake(-1);
            m_intake.topIntake(-1);
        } else {
            m_intake.reset();

        }


    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}