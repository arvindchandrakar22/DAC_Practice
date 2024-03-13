#include<iostream>
using namespace std;

class Complex
{
private:
    int real;
    const int imag;

public:
    Complex():imag(0),real(0)
    {

    }

    Complex(int imag):imag(imag)
    {
        this->real = 20;
    }

    Complex(int real, int imag):real(real),imag(imag)
    {
        cout<<"Inside :: Complex(int real, int imag):real(real),imag(imag)"<<endl;
    }

    void print()
    {
        cout<<"Real = "<<this->real<<endl;
        cout<<"Imag = "<<this->imag<<endl;
    }

};

void takeInput(int &a, int &b)
    {
        cout<<"Enter Real No.  ::  "<<endl;
        cin>>a;
        cout<<"Enter Imag No.  ::  "<<endl;
        cin>>b;
    }


int main()
{
    int a;
    int b;
    
    takeInput(a,b);

    Complex c1(a,b);
    c1.print();

    return 0;
}
