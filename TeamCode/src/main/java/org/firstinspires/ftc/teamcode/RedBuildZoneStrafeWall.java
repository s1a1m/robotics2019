package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "RedBuildZoneStrafeWall", group = "Autonomous")
public class RedBuildZoneStrafeWall extends LinearOpMode{
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

        R.strafe("Left", 900, .3);
        R.waitFor();

        R.driveStraight(-200, .3);
        R.waitFor();
    }
}
