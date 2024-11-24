#include <iostream>
using namespace std;
struct Complex
{
    int real;
    int imag;
};
Complex add(Complex a, Complex b)
{
    Complex result;
    result.real = a.real + b.real;
    result.imag = a.imag + b.imag;
    return result;
}
Complex sub(Complex a, Complex b)
{
    Complex result;
    result.real = a.real - b.real;
    result.imag = a.imag - b.imag;
    return result;
}
Complex mul(Complex a, Complex b)
{
    Complex result;
    result.real = (a.real * b.real) + ((-1) * a.imag * b.imag);
    result.imag = (a.real * b.imag) + (a.imag * b.real);
    return result;
}
Complex div(Complex a, Complex b)
{
    int din = (b.real * b.real) + (b.imag * b.imag);
    if (din == 0)
    {
        cout << "Division not possible" << endl;
        exit(1);
    }

    else
    {
        Complex result;
        result.real = ((float)(a.real * b.real) + (a.imag * b.imag)) / (float)din;
        result.imag = ((float)(a.imag * b.real) - (a.real * b.imag)) / (float)din;
        return result;
    }
}
int main()
{
    char ch;
    cout << "enter the operator:";
    cin >> ch;
    Complex c1;
    Complex c2;
    Complex result;
    c1.real = 2;
    c1.imag = 2;
    c2.real = 1;
    c2.imag = 1;
    switch (ch)
    {
    case '+':
        result = add(c1, c2);
        break;
    case '-':
        result = sub(c1, c2);
        break;
    case '*':
        result = mul(c1, c2);
        break;
    case '/':
        result = div(c1, c2);
        break;
    default:
        break;
    }
    cout << result.real << "+" << result.imag << "i" << endl;
    return 0;
}