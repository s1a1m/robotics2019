package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name="TeleOp", group="Linear Opmode")
public class TeleopMode extends LinearOpMode {
    public Robot R = new Robot();
    public HardwareMap HwMap;

    @Override
    public void runOpMode() {
        R.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {

            final double v1 = -gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
            final double v2 = -gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;
            final double v3 = -gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
            final double v4 = -gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;

            // D-Pad Strafe
            if(gamepad1.dpad_left || gamepad1.dpad_right) {
                R.left_front_motor.setPower(-(gamepad1.dpad_left ? 1.0 : 0.0) + (gamepad1.dpad_right ? 1.0 : 0.0));
                R.left_back_motor.setPower((gamepad1.dpad_left ? 1.0 : 0.0) - (gamepad1.dpad_right ? 1.0 : 0.0));
                R.right_front_motor.setPower((gamepad1.dpad_left ? 1.0 : 0.0) - (gamepad1.dpad_right ? 1.0 : 0.0));
                R.right_back_motor.setPower(-(gamepad1.dpad_left ? 1.0 : 0.0) + (gamepad1.dpad_right ? 1.0 : 0.0));
            }
            else if(gamepad1.dpad_up){
                //D-Pad Forward
                R.left_back_motor.setPower(1);
                R.left_front_motor.setPower(1);
                R.right_back_motor.setPower(1);
                R.right_front_motor.setPower(1);
            }
            else if(gamepad1.dpad_down){
                //D-Pad Backward
                R.left_back_motor.setPower(-1);
                R.left_front_motor.setPower(-1);
                R.right_back_motor.setPower(-1);
                R.right_front_motor.setPower(-1);
            }
            else if(gamepad1.y){
                //D-Pad Forward
                R.left_back_motor.setPower(.4);
                R.left_front_motor.setPower(.4);
                R.right_back_motor.setPower(.4);
                R.right_front_motor.setPower(.4);
            }
            else if(gamepad1.a){
                //D-Pad Backward
                R.left_back_motor.setPower(-.4);
                R.left_front_motor.setPower(-.4);
                R.right_back_motor.setPower(-.4);
                R.right_front_motor.setPower(-.4);
            }
            else if(gamepad1.b){
                //D-Pad Forward
                R.left_back_motor.setPower(.4);
                R.left_front_motor.setPower(.4);
                R.right_back_motor.setPower(-.4);
                R.right_front_motor.setPower(-.4);
            }
            else if(gamepad1.x){
                //D-Pad Backward
                R.left_back_motor.setPower(-.4);
                R.left_front_motor.setPower(-.4);
                R.right_back_motor.setPower(.4);
                R.right_front_motor.setPower(.4);
            }
            else{
                // Mech Drive
                R.left_front_motor.setPower(v1);
                R.left_back_motor.setPower(v2);
                R.right_front_motor.setPower(v3);
                R.right_back_motor.setPower(v4);
            }

            // Claws
            if(gamepad2.y){
                R.claw.setPosition(1);
                R.claw2.setPosition(0);
            }
            if(gamepad2.a) {
                R.claw.setPosition(.5);
                R.claw2.setPosition(.5);
            }
            if(gamepad2.b){
                R.skystoneClaw.setPosition(.55);
            }
            if(gamepad2.x){
                R.skystoneClaw.setPosition(0);
            }

            //Linear Slide
            R.linearSlide.setPower(gamepad2.left_stick_y);
            R.linearSlide2.setPower(gamepad2.left_stick_y);

            telemetry.addData("Left Front: ", R.left_front_motor.getCurrentPosition());
            telemetry.addData("Right Front: ", R.right_front_motor.getCurrentPosition());
            telemetry.addData("Left Back: ", R.left_back_motor.getCurrentPosition());
            telemetry.addData("Right Back: ", R.right_back_motor.getCurrentPosition());
            telemetry.addData("Mode: ", R.left_front_motor.getMode());
            telemetry.update();

        }
    }
}