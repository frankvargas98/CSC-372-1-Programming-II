public class Cone extends Shape {
    private double radius;
    private double height;

    // Parameterized constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        // Using Pythagorean theorem for the slant height
        double slantHeight = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * (height / 3.0);
    }

    @Override
    public String toString() {
        return String.format("Cone     [Radius: %.2f, Height: %.2f] -> Surface Area: %.2f, Volume: %.2f",
                radius, height, surface_area(), volume());
    }
}