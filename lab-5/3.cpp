#include <iostream>
#include <cmath>
using namespace std;

class Cuboid
{
private:
    double length, width, height;

public:
    Cuboid()
    {
        cout << "Enter the length of the Cuboid(cm) : ";
        cin >> this->length;
        cout << "Enter the width of the Cuboid(cm) : ";
        cin >> this->width;
        cout << "Enter the height of the Cuboid(cm) : ";
        cin >> this->height;
    }

    double calculateArea()
    {
        return 2 * (length * width + width * height + height * length);
    }

    friend class Cube;
};

class Cube
{
public:
    void convertToCube(Cuboid &cuboid)
    {
        double side = cbrt(cuboid.length * cuboid.width * cuboid.height);
        cuboid.length = cuboid.width = cuboid.height = side;
    }

    double calculateArea(Cuboid &cuboid)
    {
        return 6 * cuboid.length * cuboid.length;
    }
};

int main()
{
    Cuboid cuboid;
    cout << "Area of Cuboid: " << cuboid.calculateArea() << "cm2" << endl;

    Cube cube;
    cube.convertToCube(cuboid);
    cout << "Cuboid converted into Cube." << endl;
    cout << "Area of Cube: " << cube.calculateArea(cuboid) << "cm2" << endl;

    return 0;
}
