package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "RedBuildZoneStrafeBridge", group = "Autonomous")
public class RedBuildZoneStrafeBridge extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode() {
        R.init(hardwareMap);
        waitForStart();

        R.skystoneClaw.setPosition(.75);
        sleep(500);

        R.driveStraight(200, .3);
        R.waitFor();

        R.raiseLifter(-400, .7);
        R.waitLinearSlide();

        R.turn("CW", 200, .3);
        R.waitFor();

        R.driveStraight(600, .3);
        R.waitFor();

        R.turn("CCW", 200, .3);
        R.waitFor();

        R.driveStraight(500, .3);
        R.waitFor();

        R.raiseLifter(400, .3);
        R.waitLinearSlide();

        R.driveStraight(-1200, .1);
        R.waitFor();

        R.raiseLifter(-300, .7);
        R.waitLinearSlide();

        R.strafe("Left", 1000, .3);
        R.waitFor();

        R.raiseLifter(300, .7);
        R.waitLinearSlide();

        R.strafe("Left", 950, .3);
        R.waitFor();

        R.skystoneClaw.setPosition(.65);
        sleep(1000);

        R.left_front_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        R.right_front_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        R.left_back_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        R.right_back_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        R.left_front_motor.setPower(-.5);
        R.right_front_motor.setPower(-.5);
        R.left_back_motor.setPower(-.5);
        R.right_back_motor.setPower(-.5);

        sleep(500);

        R.left_front_motor.setPower(0);
        R.right_front_motor.setPower(0);
        R.left_back_motor.setPower(0);
        R.right_back_motor.setPower(0);

        R.driveStraight(900, .3);
        R.waitFor();
    }
}
