package Lab8.FigPackage;

abstract public class Figure {
    final double Pi=3.14;
    double r,a,v;
    public abstract void calcArea();
    public abstract void clacVolume();
    public abstract void dispArea();
    public abstract void dispVolume();    
}
class Cone extends Figure{
    double n,s;
    public Cone(double r,double n,double s){
        this.r=r;
        this.s=s;
        this.n=n;
    }
    public void calcArea(){
        a=(Pi*r*s)+(Pi*r*r);
    }
    public void clacVolume(){
        v=(Pi*r*r*n)/3;
    }
    public void dispArea(){
        System.out.println("Area of the Cone: "+a);
    }
    public void dispVolume(){
        System.out.println("Volume of the Cone: "+v);
    }
}
class Cylinder extends Figure{
    double n;
    public Cylinder(double r,double n){
        this.r=r;
        this.n=n;
    }
    public void calcArea(){
        a=(2*Pi*r*r)+(2*Pi*r*n);
    }
    public void clacVolume(){
        v=Pi*r*r*n;
    }
    public void dispArea(){
        System.out.println("Area of the Cylinder: "+a);
    }
    public void dispVolume(){
        System.out.println("Volume of the Cylinder: "+v);
    }
}
class Sphere extends Figure{
    public Sphere(double r){
        this.r=r;
    }
    public void calcArea(){
        a=4*Pi*r*r;
    }
    public void clacVolume(){
        v=(4*Pi*r*r*r)/3;
    }
    public void dispArea(){
        System.out.println("Area of the Sphere: "+a);
    }
    public void dispVolume(){
        System.out.println("Volume of the Sphere: "+v);
    }
}
