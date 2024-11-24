#include <iostream>
using namespace std;

class Array
{
    int *arr;
    int size;

public:
    Array(int s)
    {
        size = s;
        arr = new int[size];
    }

    void input()
    {
        for (int i = 0; i < size; i++)
        {
            cout << "Enter element " << i + 1 << ": ";
            cin >> arr[i];
        }
    }

    void display()
    {
        for (int i = 0; i < size; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    ~Array()
    {
        delete[] arr;
    }
};

int main()
{
    int size;
    cout << "Enter the size of the array: ";
    cin >> size;
    Array arr(size);
    arr.input();
    cout << "Elements of the array: " << endl;
    arr.display();
    return 0;
}
