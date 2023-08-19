package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class servop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        Servo s1 = hardwareMap.servo.get("s1");
        Servo s2 = hardwareMap.servo.get("s2");
        DcMotor gregory = hardwareMap.dcMotor.get("gregory");

        s1.setPosition(0.5);
        s2.setPosition(0.5);
        gregory.setDirection(DcMotorSimple.Direction.FORWARD);

        boolean turnMovement;
        boolean stopMovement;
        double s1Position = 0;
        double s2Position = 0;
        gregory.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        while (opModeIsActive()) {
            turnMovement = gamepad1.a;
            stopMovement = gamepad1.y;
            double gregoryPower = -1;
            double gregory2Power = 1;
            double maxPower = maxAbsValueDouble(gregoryPower);

            if (turnMovement == true) {
                s1Position += 0.05;
                s2Position -= 0.05;
            }

            if (stopMovement == true) {
                s1Position -= 0.05;
                s2Position += 0.05;
            }

            if (gamepad1.dpad_up == true){
                gregory.setPower(gregoryPower);
            }

            if (gamepad1.dpad_down == true) {
                gregory.setPower(gregory2Power);
            }

            if (gamepad1.dpad_down == false){
                gregoryPower = 0;
                gregory.setPower(gregoryPower);
            }

            if (gamepad1.dpad_up == false) {
                gregory2Power = 0;
                gregory.setPower(gregory2Power);
            }

            s1.setPosition(s1Position);

            s2.setPosition(s2Position);
        }

        }

    private double maxAbsValueDouble(double gregoryPower) {
        return gregoryPower;
    }


}

