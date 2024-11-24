#include <iostream>
using namespace std;
class Tax
{
private:
    string name;
    double income;
    double tax = 0;

public:
    void inputData()
    {
        cout << "Enter your name :";
        cin >> this->name;
        cout << "Enter your income :";
        cin >> this->income;
    }
    void computeTax()
    {
        if (income > 100000 && income < 150001)
        {
            this->tax = income / 10;
        }
        else if (income > 150000 && income <= 200000)
        {
            this->tax = income / 20;
        }
        else if (income > 200000)
        {
            this->tax = income / 30;
        }
    }
    void display()
    {
        cout << "Employee name : " << name << endl;
        cout << "Income : " << income << endl;
        cout << "Tax due : " << tax << endl;
    }
};
int main()
{
    Tax e;
    e.inputData();
    e.computeTax();
    e.display();
}