#include<iostream>
using namespace std;

class Complex
{
    private:
        int real;
        int imag;
    public:
        Complex()
        {
            cout<<"Inside Default Constructor"<<endl;
            this->real = 10;
            this->imag = 20;
        }
        Complex(int r, int i)
        {
            cout<<"Inside Parameterised Constructor"<<endl;
            this->real = r;
            this->imag = i;
        }
        // Complex(Complex &xyz)
        // {
        //     cout<<"Inside Copy Constructor"<<endl;
        // }
        void accept()
        {
            cout<<"Inside accept Method"<<endl;
        }
        void print()
        {
            cout<<"Inside Print Method"<<endl;
        }
        ~Complex()
        {
            cout<<"Inside Distructor"<<endl;
        }
};
int main()
{
    Complex c1(100,200);
    c1.print();
    Complex c2 = c1; //c2.Complex(c1)
    c2.print();
    return 0;
}