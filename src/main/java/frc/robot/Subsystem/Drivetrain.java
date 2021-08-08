package frc.robot.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class Drivetrain extends SubsystemBase {

  private TalonSRX TalonR, TalonL;
  private Victor VictorLF, VictorRF, VictorLB, VictorRB;
  private DoubleSolenoid Shifter;
  private PigeonIMU pigeon;
 


  public Drivetrain() {
    TalonL = new TalonSRX(6);
    TalonR = new TalonSRX(1);
    VictorLB = new Victor(2);
    VictorLF = new Victor(3);
    VictorRB = new Victor(5);
    VictorRF = new Victor(4);
    

    Shifter = new DoubleSolenoid(1, 2);

    pigeon = new PigeonIMU(10);

  }

  public double GetLeftMotorVoltgae() {
    return this.TalonL.getMotorOutputPercent();
  }

  public double GetRightMotorVoltgae() {
    return this.TalonR.getMotorOutputPercent();
  }

  public void SetRightMotor(double percent) {
    this.TalonR.set(ControlMode.PercentOutput, percent);
  }

  public void SetLeftMotor(double percent) {
    this.TalonL.set(ControlMode.PercentOutput, percent);
  }

  public void SetPercent(double PercentL, double PercentR) {
    this.TalonL.set(ControlMode.PercentOutput, PercentL);
    this.TalonR.set(ControlMode.PercentOutput, PercentR);
  }

  public double getYaw() {
    double[] ypr = new double[0];
    this.pigeon.getYawPitchRoll(ypr);
    return ypr[0];
    
    
  }
  public double getPitch() {
    double[] ypr = new double[1];
    this.pigeon.getYawPitchRoll(ypr);
    return ypr[0];
  }
  public double getRoll() {
    double[] ypr = new double[2];
    this.pigeon.getYawPitchRoll(ypr);
    return ypr[0];
  }
  public double getEncoderl(){
    return this.TalonL.getSelectedSensorPosition();  
  }

  public enum Gear {
    high(Value.kForward), low(Value.kReverse),off(Value.kOff);
        
    private Value _value;

    private Gear(Value value) {
        this._value = value;
    }
    public Value getValue() {
      return this._value;
  }
}

  public boolean isGearLow(){
    return this.Shifter.get() == Gear.low.getValue();
  }

  public boolean isGearHigh(){
    return this.Shifter.get() == Gear.high.getValue();
  }

  public void SetGear(Value value){
    this.Shifter.set(value);
  }



   
  
  

}

