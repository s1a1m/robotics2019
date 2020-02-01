package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedPickUpZoneParkWall", group = "Autonomous")
public class RedPickUpZoneParkWall extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.skystoneClaw.setPosition(.4);
        sleep(500);

    }
}
