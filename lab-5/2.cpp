#include <iostream>
using namespace std;

class ClassA
{

public:
    int numA;
    ClassA()
    {
        cout << "Enter the A value : ";
        cin >> this->numA;
    }
};
class ClassB
{

public:
    int numB;
    ClassB()
    {
        cout << "Enter the b value : ";
        cin >> this->numB;
    }

    friend float findMean(ClassA &a, ClassB &b);
};

float findMean(ClassA &a, ClassB &b)
{
    return (a.numA + b.numB) / 2.0;
}

int main()
{
    ClassA objA;
    ClassB objB;

    cout << "Mean of numbers: " << findMean(objA, objB) << endl;

    return 0;
}
