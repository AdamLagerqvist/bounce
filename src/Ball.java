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
    public void Y_Velocity_calc(double time_step){
        Y_velocity += (gravity) * time_step;
    }

    public void hight_calc(double time_step){
        if ((hight+(-Y_velocity * time_step) + ((gravity * Math.pow(time_step,2)/2))) > 0) {
            hight += (-Y_velocity * time_step) + ((gravity * Math.pow(time_step, 2) / 2));
        } else {
            Y_bounce();
        }
    }

    public void Y_bounce(){
        hight_calc(Y_velocity*2/gravity);
        Y_velocity*=-0.9;
        X_velocity*=0.9;
    }

    public void X_Clac(double time_step){
        if ((X_local+X_velocity*time_step)>890 || (X_local+X_velocity*time_step)<0) {
            X_bouce(time_step);
        } else{
            X_local += (X_velocity * time_step);
        }
    }

    public void X_bouce(double time_step){
        if (X_local+X_velocity*time_step >= 890){
            X_Clac(((890 - X_local)/X_velocity));
            Y_velocity*=0.9;
            X_velocity*=-0.9;
            //X_local += (X_velocity * time_step);
            //X_local = 0 - X_local
        } else {
            X_Clac(-X_local/X_velocity);
            Y_velocity*=0.9;
            X_velocity*=-0.9;
        }
    }

}