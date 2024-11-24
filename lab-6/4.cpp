#include <iostream>
using namespace std;

class Vector
{
    int *arr;
    int size;

public:
    Vector(int s)
    {
        this->size = s;
        arr = new int[size];
    }

    ~Vector()
    {
        delete[] arr;
    }

    friend ostream &operator<<(ostream &out, Vector &v)
    {
        out << "[";
        for (int i = 0; i < v.size; i++)
        {
            out << v.arr[i];
            if (i < v.size - 1)
                out << ", ";
        }
        out << "]";
        return out;
    }

    friend istream &operator>>(istream &in, Vector &v)
    {
        char ch;
        in >> ch;
        for (int i = 0; i < v.size; ++i)
        {
            in >> v.arr[i];
            if (i < v.size - 1)
                in >> ch;
        }
        in >> ch;
        return in;
    }

    Vector operator+(Vector &other)
    {
        Vector result(size);
        for (int i = 0; i < size; i++)
        {
            result.arr[i] = arr[i] + other.arr[i];
        }
        return result;
    }

    Vector operator-(Vector &other)
    {
        Vector result(size);
        for (int i = 0; i < size; ++i)
        {
            result.arr[i] = arr[i] - other.arr[i];
        }
        return result;
    }
};

int main()
{
    int size;
    cout << "Enter the size of the vectors: ";
    cin >> size;

    Vector v1(size), v2(size);
    cout << "Enter first vector (e.g., [10, 20, 30]): ";
    cin >> v1;
    cout << "Enter second vector (e.g., [5, 15, 25]): ";
    cin >> v2;

    cout << "First vector: " << v1 << endl;
    cout << "Second vector: " << v2 << endl;

    Vector sum = v1 + v2;
    Vector difference = v1 - v2;

    cout << "Sum: " << sum << endl;
    cout << "Difference: " << difference << endl;

    return 0;
}
