#include <iostream>
using namespace std;
struct Arthimetic
{
    int no1;
    int no2;
};
void add(Arthimetic num)
{

    cout << "Addition of two numbers is " << num.no1 + num.no2 << endl;
}
void sub(Arthimetic num)
{
    cout << "Subtraction of two numbers is " << num.no1 - num.no2 << endl;
}
void mul(Arthimetic num)
{
    cout << "Multiplication of two numbers is " << num.no1 * num.no2 << endl;
}
void div(Arthimetic num)
{
    cout << "Division of two numbers is " << (float)num.no1 / (float)num.no2 << endl;
}
int main()
{
    Arthimetic num;
    int n;
    char ch;
    cout << "enter the operator:";
    cin >> ch;
    num.no1 = 5;
    num.no2 = 9;
    switch (ch)
    {
    case '+':
        add(num);
        break;
    case '-':
        sub(num);
        break;
    case '*':
        mul(num);
        break;
    case '/':
        div(num);
        break;

    default:
        break;
    }
    return 0;
}