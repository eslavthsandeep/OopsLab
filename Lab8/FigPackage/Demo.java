package Lab8.FigPackage;
public class Demo  {
    public static void main(String[] args) {
        Figure f1=new Cone(2, 3, 5);
        Figure f2=new Cylinder(2,  5);
        Figure f3=new Sphere(2);
        f1.calcArea();
        f1.clacVolume();
        f1.dispArea();
        f1.dispVolume();
        f2.calcArea();
        f2.clacVolume();
        f2.dispArea();
        f2.dispVolume();
        f3.calcArea();
        f3.clacVolume();
        f3.dispArea();
        f3.dispVolume();
    }
}
