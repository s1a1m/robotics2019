package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    public HardwareMap HwMap;

    //Motors
    public DcMotor right_front_motor;
    public DcMotor right_back_motor;
    public DcMotor left_front_motor;
    public DcMotor left_back_motor;

    public void init(HardwareMap hwm){
        HwMap = hwm;

        right_front_motor = HwMap.dcMotor.get("right_front_motor");
        right_back_motor = HwMap.dcMotor.get("right_back_motor");
        left_front_motor = HwMap.dcMotor.get("left_front_motor");
        left_back_motor = HwMap.dcMotor.get("left_back_motor");

        right_front_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        right_back_motor.setDirection(DcMotorSimple.Direction.REVERSE);
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
        this.setDriveMotorsMode(4); // STOP_AND_RESET_ENCODER
        this.setDriveMotorsMode(1); // RUN_TO_POSITION
        // Sets target position
        this.left_front_motor.setTargetPosition(encoderTicks);
        this.right_front_motor.setTargetPosition(encoderTicks);
        this.left_back_motor.setTargetPosition(encoderTicks);
        this.right_back_motor.setTargetPosition(encoderTicks);
        // Sets power
        this.left_front_motor.setPower(power);
        this.right_front_motor.setPower(power);
        this.left_back_motor.setPower(power);
        this.right_back_motor.setPower(power);
    }
    public void waitFor() {
        while(this.right_front_motor.isBusy()){
            //Waiting
        }
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
        setDriveMotorsMode(1);
        if (direction == "Right") {
            this.left_back_motor.setTargetPosition(this.left_back_motor.getCurrentPosition() - distance);
            this.left_front_motor.setTargetPosition(this.left_front_motor.getCurrentPosition() + distance);
            this.right_back_motor.setTargetPosition(this.right_back_motor.getCurrentPosition() + distance);
            this.right_front_motor.setTargetPosition(this.right_front_motor.getCurrentPosition() - distance);

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

            this.left_back_motor.setPower(power);
            this.left_front_motor.setPower(power);
            this.right_back_motor.setPower(power);
            this.right_front_motor.setPower(power);
        }
    }
}
