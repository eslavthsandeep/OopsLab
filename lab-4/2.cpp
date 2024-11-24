#include <iostream>
using namespace std;
class Call
{
private:
    string name;
    int noc;
    float bill = 200;

public:
    void inputData()
    {
        cout << "Enter your name :";
        cin >> this->name;
        cout << "Enter the no of calls you have dailed :";
        cin >> this->noc;
    }
    void computeData()
    {
        if (noc > 100 && noc < 151)
        {
            bill += (noc - 100) * 0.6;
        }
        else if (noc > 150 && noc < 201)
        {
            bill += ((noc - 100) * 0.6) + (noc - 150) * 0.5;
        }
        else if (noc > 200)
        {
            bill += ((noc - 100) * 0.6) + ((noc - 150) * 0.5) + ((noc - 200) * 0.4);
        }
    }
    void display()
    {
        cout << "Name of the customer : " << this->name << endl;
        cout << "Number of calls : " << this->noc << endl;
        cout << "Bill Amount : " << this->bill << endl;
    }
};

int main()
{
    Call c;
    c.inputData();
    c.computeData();
    c.display();
}