package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedBuildZone", group = "Autonomous")
public class RedBuildZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.driveStraight(200, .7);
        R.waitFor();

        R.driveStraight(400, .7);
        R.waitFor();

        R.raiseLifter(-400, .7);
        R.waitLinearSlide();

        R.turn("CW", 400, .7);
        R.waitFor();

        R.driveStraight(2400, .7);
        R.waitFor();

        R.turn("CCW", 440, .7);
        R.waitFor();

        R.driveStraight(500, .7);
        R.waitFor();

        R.raiseLifter(400, .7);
        R.waitLinearSlide();

        R.driveStraight(-3300, .3);
        R.waitFor();
    }
}
