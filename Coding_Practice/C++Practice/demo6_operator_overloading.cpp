#include<iostream>
using namespace std;
class Arithmetic
{
    private:
    int num1;
    int num2;

    public:
    Arithmetic(int num1, int num2)
    {
        this->num1=num1;
        this->num2=num2;
    }
    void sum()
    {
        cout<<"Addition = "<<num1+num2<<endl;
    }
    void print()
    {
        cout<<"Num 1 = "<<num1<<endl;
        cout<<"Num 2 = "<<num2<<endl;
    }
    void sub()
    {
        cout<<"Subraction = "<<num1-num2<<endl;
    }
    Arithmetic operator+ (Arithmetic &other)
    {
        Arithmetic temp(0,0);
        temp.num1 = this->num1+other.num1;
        temp.num2 = this->num2+other.num2;
        return temp;
    }
};

int main()
{
    Arithmetic a1(20,10);
    cout<<"Operator a1"<<endl;
    a1.print();

    Arithmetic a2(30,50);
    cout<<"Operator a2"<<endl;
    a2.print();

    cout<<"Sum of operator a1 and a2"<<endl;
    Arithmetic a3=a1+a2; //a1.operator+(a2)
    a3.print();

    return 0;
}