package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BluePickUpZoneParkWall", group = "Autonomous")
public class BluePickUpZoneParkWall extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.skystoneClaw.setPosition(.4);
        sleep(500);

    }
}
