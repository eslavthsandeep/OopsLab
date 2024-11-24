#include <iostream>
using namespace std;
class Bank
{
private:
    string name;
    double acc_no;
    string toa;
    double amount = 0;

public:
    void inputData()
    {
        cout << "Enter your name :";
        cin >> this->name;
        cout << "Enter your account no :";
        cin >> acc_no;
        cout << "Enter your type of account :";
        cin >> toa;
        deposite();
    }
    void deposite()
    {
        cout << "Enter the amount to deposite :";
        int temp;
        cin >> temp;
        amount += temp;
    }
    void withdraw()
    {
        cout << "Enter the amount to withdraw :";
        float wd;
        cin >> wd;
        if (wd > amount)
        {
            cout << "Insufficiant Balance" << endl;
        }
        else
        {
            amount -= wd;
        }
    }
    void display()
    {
        cout << "Account holder name : " << name << endl;
        cout << "Account number : " << acc_no << endl;
        cout << "Type of account : " << toa << endl;
        cout << "Balance amount : " << amount << endl;
    }
};

int main()
{
    Bank c;
    c.inputData();
    c.withdraw();
    c.display();
}