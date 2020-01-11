package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {

    public HardwareMap HwMap;

    //Motors
    public DcMotor right_front_motor;
    public DcMotor right_back_motor;
    public DcMotor left_front_motor;
    public DcMotor left_back_motor;

    public DcMotor linearSlide;
    public DcMotor linearSlide2;

    public Servo claw;
    public Servo claw2;

    public void init(HardwareMap hwm){
        HwMap = hwm;

        right_front_motor = HwMap.dcMotor.get("right_front_motor"); //Hub 2, Port 3
        right_back_motor = HwMap.dcMotor.get("right_back_motor"); //Hub 2, Port 2
        left_front_motor = HwMap.dcMotor.get("left_front_motor"); //Hub 2, Port 0
        left_back_motor = HwMap.dcMotor.get("left_back_motor"); //Hub 2, Port 1

        linearSlide = HwMap.dcMotor.get("linearSlide");
        linearSlide2 = HwMap.dcMotor.get("linearSlide2");

        claw = HwMap.servo.get("claw");
        claw2 = HwMap.servo.get("claw2");

        right_back_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        right_front_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        this.setDriveMotorsMode(4); // RESET
        this.setDriveMotorsMode(2); // RUN USING ENCODER

    }
  
    public boolean driveMotorsBusy() {
        if( this.left_front_motor.getPower() + this.right_front_motor.getPower() + this.left_back_motor.getPower() + this.right_back_motor.getPower() != 0.0){
            return true;
        }
        else {
            return false;
        }
    }

    public void setDriveMotorsMode(int option) {
        switch(option) {
            case 1:
                this.left_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                this.right_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                this.left_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                this.right_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                break;
            case 2:
                this.left_front_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.right_front_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.left_back_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                this.right_back_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                break;
            case 3:
                this.left_front_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                this.right_front_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                this.left_back_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                this.right_back_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                break;
            case 4:
                this.left_front_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                this.right_front_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                this.left_back_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                this.right_back_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                break;
            default:
                System.out.println("Error: Invalid argument!");
        }
    }

    public void driveStraight(int encoderTicks, double power) {
//        this.setDriveMotorsMode(4); // STOP_AND_RESET_ENCODER
        this.left_front_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.right_front_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.left_back_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.right_back_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        this.left_front_motor.setTargetPosition(encoderTicks);
        this.right_front_motor.setTargetPosition(encoderTicks);
        this.left_back_motor.setTargetPosition(encoderTicks);
        this.right_back_motor.setTargetPosition(encoderTicks);
        //Sets target Position
//        this.setDriveMotorsMode(1); // RUN_TO_POSITION
        this.left_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.right_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.left_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.right_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // Sets power
        this.left_front_motor.setPower(power);
        this.right_front_motor.setPower(power);
        this.left_back_motor.setPower(power);
        this.right_back_motor.setPower(power);
    }

    public void waitFor() {
        while(this.right_front_motor.isBusy() ){
            //Waiting
        }
    }
    public void waitLinearSlide() {
        while(this.linearSlide.isBusy() ){
            //Waiting
        }
    }

    public void raiseLifter(int distance, double power){
        this.linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        this.linearSlide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.linearSlide.setTargetPosition(distance);
//        this.linearSlide2.setTargetPosition(distance);
        this.linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        this.linearSlide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.linearSlide.setPower(power);
//        this.linearSlide2.setPower(power);

    }

    public void turn(String direction, int encoderTicks, double power) {
        this.setDriveMotorsMode(4); // STOP_AND_RESET_ENCODER
        this.setDriveMotorsMode(1); // RUN_TO_POSITION
        if(direction == "CW") {
            // Turning  ClockWise
            this.left_front_motor.setTargetPosition(encoderTicks);
            this.left_back_motor.setTargetPosition(encoderTicks);
            this.right_front_motor.setTargetPosition(-encoderTicks);
            this.right_back_motor.setTargetPosition(-encoderTicks);
        }
        else if(direction == "CCW") {
            // Turning Counter ClockWise
            this.left_front_motor.setTargetPosition(-encoderTicks);
            this.left_back_motor.setTargetPosition(-encoderTicks);
            this.right_front_motor.setTargetPosition(encoderTicks);
            this.right_back_motor.setTargetPosition(encoderTicks);
        } else {
            System.out.println("Error: Invalid argument!");
            return;
        }
        // Sets power
        this.left_front_motor.setPower(power);
        this.right_front_motor.setPower(power);
        this.left_back_motor.setPower(power);
        this.right_back_motor.setPower(power);
    }

    public void strafe(String direction, int distance, double power) {
        if (direction == "Right") {
            this.left_back_motor.setTargetPosition(this.left_back_motor.getCurrentPosition() - distance);
            this.left_front_motor.setTargetPosition(this.left_front_motor.getCurrentPosition() + distance);
            this.right_back_motor.setTargetPosition(this.right_back_motor.getCurrentPosition() + distance);
            this.right_front_motor.setTargetPosition(this.right_front_motor.getCurrentPosition() - distance);

            this.left_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.right_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.left_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.right_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            this.left_back_motor.setPower(power);
            this.left_front_motor.setPower(power);
            this.right_back_motor.setPower(power);
            this.right_front_motor.setPower(power);
        }
        if(direction == "Left"){
            this.left_back_motor.setTargetPosition(this.left_back_motor.getCurrentPosition() + distance);
            this.left_front_motor.setTargetPosition(this.left_front_motor.getCurrentPosition() - distance);
            this.right_back_motor.setTargetPosition(this.right_back_motor.getCurrentPosition() - distance);
            this.right_front_motor.setTargetPosition(this.right_front_motor.getCurrentPosition() + distance);

            this.left_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.right_front_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.left_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.right_back_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            this.left_back_motor.setPower(power);
            this.left_front_motor.setPower(power);
            this.right_back_motor.setPower(power);
            this.right_front_motor.setPower(power);
        }
    }
}
