public class ball {

    public double hight;
    public double mass;

    public double velocity;
    private static final double gravity = 9.82;

    public void Velocity_calc(){
        velocity = velocity + gravity / 10;
    }

    public ball(double hight, double mass, double velocity) {
        this.hight = hight;
        this.mass = mass;
        this.velocity = velocity;
    }
}