package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Subsystem.Drivetrain;


/**
 * A simple command that grabs a hatch with the {@link HatchSubsystem}.  Written explicitly for
 * pedagogical purposes.  Actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.InstantCommand}.
 */
public class ShiftGear extends CommandBase {

    
 
  public Drivetrain drivetrain;

  public ShiftGear(){
      this.drivetrain = new Drivetrain();

  }

  @Override
  public void initialize() {
    if(this.drivetrain.isGearHigh()){
        this.drivetrain.SetGear(Value.kForward);
    }else{
        if(this.drivetrain.isGearLow()){
            this.drivetrain.SetGear(Value.kReverse);
            }
        }

    } 
        
    
  

  @Override
  public boolean isFinished() {
    return true;
  }
}