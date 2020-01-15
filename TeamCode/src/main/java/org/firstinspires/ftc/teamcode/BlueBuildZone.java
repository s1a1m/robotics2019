package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "BlueBuildZone", group = "Autonomous")
public class BlueBuildZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.driveStraight(400, .7);
        R.waitFor();

        R.raiseLifter(-400, .7);
        R.waitLinearSlide();

        R.turn("CCW", 400, .7);
        R.waitFor();

        R.driveStraight(2400, .7);
        R.waitFor();

        R.turn("CW", 440, .7);
        R.waitFor();

        R.driveStraight(500, .7);
        R.waitFor();

        R.raiseLifter(400, .7);
        R.waitLinearSlide();

        R.driveStraight(-3300, .3);
        R.waitFor();

        R.raiseLifter(-300, .7);
        R.waitLinearSlide();

        R.driveStraight(200, .7);
        R.waitFor();

        R.strafe("Right", 1500, .3);
        R.waitFor();

        R.raiseLifter(-300, .7);
        R.waitLinearSlide();

        R.strafe("Right", 1500, .3);
        R.waitFor();

    }
}
