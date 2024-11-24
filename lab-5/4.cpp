#include <iostream>
using namespace std;

class Complex
{
private:
    double real, imag;

public:
    Complex(double real, double imag);

    Complex multiply(Complex &c);

    void display();
};

Complex::Complex(double real, double imag)
{
    this->real = real;
    this->imag = imag;
}

Complex Complex::multiply(Complex &c)
{
    Complex result((this->real * c.real) - (this->imag * c.imag),
                   (this->real * c.imag) + (this->imag * c.real));
    return result;
}

void Complex::display()
{
    cout << real << (imag >= 0 ? " + " : " - ") << abs(imag) << "i" << endl;
}

int main()
{
    double real, imag, real1, imag1;

    cout << "Enter the real part of the first complex number: ";
    cin >> real;
    cout << "Enter the imaginary part of the first complex number: ";
    cin >> imag;
    Complex c1(real, imag);

    cout << "Enter the real part of the second complex number: ";
    cin >> real1;
    cout << "Enter the imaginary part of the second complex number: ";
    cin >> imag1;
    Complex c2(real1, imag1);

    Complex c3 = c1.multiply(c2);

    cout << "First Complex Number: ";
    c1.display();

    cout << "Second Complex Number: ";
    c2.display();

    cout << "Result of Multiplication: ";
    c3.display();

    return 0;
}
