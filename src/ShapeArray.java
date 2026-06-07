public class ShapeArray {
    public static void main(String[] args) {
        // Instantiate objects
        Shape mySphere = new Sphere(5.0);
        Shape myCylinder = new Cylinder(4.0, 10.0);
        Shape myCone = new Cone(4.0, 10.0);

        // Stores instances into an array
        Shape[] shapeArray = {mySphere, myCylinder, myCone};

        // Loops through the array and print instance data
        System.out.println("--- 3D Shape Properties ---");
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}