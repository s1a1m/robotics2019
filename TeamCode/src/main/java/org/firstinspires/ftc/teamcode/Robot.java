package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

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
    public Servo skystoneClaw;

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
        skystoneClaw = HwMap.servo.get("skystoneClaw");

        right_back_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        right_front_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        this.setDriveMotorsMode(4); // RESET
        this.setDriveMotorsMode(2); // RUN USING ENCODER

    }

    public void initVuforia() {

        final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

        final String VUFORIA_KEY = "AW/D0F3/////AAABmT6CO76ZukEWtNAvh1kty819QDEF9SG9ZxbfUcbjoxBCe0UcoTGK19TZdmHtWDwxhrL4idOt1tdJE+h9YGDtZ7U/njHEqSZ7jflzurT4j/WXTCjeTCSf0oMqcgduLTDNz+XEXMbPSlnHbO9ZnEZBun7HHr6N06kpYu6QZmG6WRvibuKCe5IeZJ21RoIeCsdp3ho/f/+QQLlnqaa1dw6i4xMFM0e2IaxujhQiWnd4by23CkMPvzKhy6YP3wPBq+awpzEPLDZcD8l1i0SqmX7HNpmw4kXBrWzEimAzp1aqONVau4kIwCGwJFusMdErw9IL7KQ5VqMKN4Xl67s0pwotoXsA+5SlWQAIodipYKZnPzwO";

        // Class Members
        VuforiaLocalizer vuforia = null;
        boolean targetVisible = false;

        int cameraMonitorViewId = HwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", HwMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection   = CAMERA_CHOICE;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Load the data sets for the trackable objects. These particular data
        // sets are stored in the 'assets' part of our application.
        VuforiaTrackables targetsSkyStone = vuforia.loadTrackablesFromAsset("Skystone");

        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
        stoneTarget.setName("Stone Target");


        // For convenience, gather together all the trackable objects in one easily-iterable collection */
        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();
        allTrackables.addAll(targetsSkyStone);
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
        this.setDriveMotorsMode(4);
        // Sets target Position
        this.left_front_motor.setTargetPosition(encoderTicks);
        this.right_front_motor.setTargetPosition(encoderTicks);
        this.left_back_motor.setTargetPosition(encoderTicks);
        this.right_back_motor.setTargetPosition(encoderTicks);
        // Starts Moving
        this.setDriveMotorsMode(1); // RUN_TO_POSITION
        // Sets power
        this.left_front_motor.setPower(power);
        this.right_front_motor.setPower(power);
        this.left_back_motor.setPower(power);
        this.right_back_motor.setPower(power);
    }

//    public void correctedStrafe(int encoderTicks, double power, String direction) {
//        this.setDriveMotorsMode(4);
//        this.setDriveMotorsMode(2);
//        if(direction == "left") {
//            this.left_front_motor.setPower();
//            this.right_front_motor.setPower();
//            this.left_back_motor.setPower();
//            this.right_back_motor.setPower();
//        }
//        if(direction == "right") {
//
//        }
//
//
//        // Sets target Position
//        this.left_front_motor.setTargetPosition(encoderTicks);
//        this.right_front_motor.setTargetPosition(encoderTicks);
//        this.left_back_motor.setTargetPosition(encoderTicks);
//        this.right_back_motor.setTargetPosition(encoderTicks);
//        // Starts Moving
//        this.setDriveMotorsMode(1); // RUN_TO_POSITION
//        // Sets power
//        this.left_front_motor.setPower(power);
//        this.right_front_motor.setPower(power);
//        this.left_back_motor.setPower(power);
//        this.right_back_motor.setPower(power);
//    }


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
