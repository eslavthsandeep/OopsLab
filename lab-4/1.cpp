#include <iostream>
using namespace std;
class Employee
{
private:
    string name;
    int earning;
    float bonus = 0;

public:
    void getInput()
    {
        cout << "Enter the of the employee" << endl;
        cin >> this->name;
        cout << "Enter the salary of the employee" << endl;
        cin >> this->earning;
    }

    void computeData()
    {
        if (earning >= 2000)
        {
            this->bonus = earning / 10;
        }
    }
    void display()
    {
        cout << "name : " << name << endl;
        cout << "Earnings : " << earning << endl;
        cout << "Bonus : " << bonus << endl;
    }
};
int main()
{
    Employee e;
    e.getInput();
    e.computeData();
    e.display();
}