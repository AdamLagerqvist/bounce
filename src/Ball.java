public class Ball {

    public double hight;
    public double X_local;

    public double Y_velocity;
    public double X_velocity;
    private static final double gravity = 9.82;

    public Ball(double hight, double X_local, double Y_velocity, double X_velocity) {
        this.hight = hight;
        this.X_local = X_local;
        this.X_velocity = X_velocity;
        this.Y_velocity = Y_velocity;
    }
    public void Y_Velocity_calc(){
        Y_velocity = Y_velocity + gravity / 10;
    }

    public void hight_calc(int time_step){
        hight = (-Y_velocity * time_step) + ((gravity * Math.pow(time_step,2)/2));
    }

}