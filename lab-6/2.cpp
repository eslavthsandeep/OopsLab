#include <iostream>
using namespace std;

class class_2;

class class_1
{
    int value1;

public:
    class_1(int v)
    {
        this->value1 = v;
    }
    void display()
    {
        cout << "Value in class_1: " << value1 << endl;
    }
    friend inline void exchange(class_1 &c1, class_2 &c2);
};

class class_2
{
    int value2;

public:
    class_2(int v)
    {
        this->value2 = v;
    }
    void display() { cout << "Value in class_2: " << value2 << endl; }
    friend inline void exchange(class_1 &c1, class_2 &c2);
};

inline void exchange(class_1 &c1, class_2 &c2)
{
    int temp = c1.value1;
    c1.value1 = c2.value2;
    c2.value2 = temp;
}

int main()
{
    class_1 obj1(10);
    class_2 obj2(20);
    cout << "Before exchange : " << endl;
    obj1.display();
    obj2.display();
    exchange(obj1, obj2);
    cout << "After exchange : " << endl;
    obj1.display();
    obj2.display();
    return 0;
}
