#include<iostream>
using namespace std;

class A
{
    private:
        int num1;
    protected:
        int num2;
    public:
        int num3;

        friend void myFun();

        void printA()
        {
            cout<<num1<<num2<<num3;
        }
};
class B : private A
{
    int num4;

    public:
    void printB()
    {
        cout<<num1<<num2<<num3<<num4;
    }
};
class C : private B
{
    int num5;

    public:
    void printC()
    {
        cout<<num1<<num2<<num3<<num4<<num5;
    }
};

void myFun()
{
    A a;
    a.num1;
    a.num2;
    a.num3;   
}

int main()
{
    A a;
    a.num1;
    a.num2;
    a.num3;

    B b;
    b.num1;
    b.num2;
    b.num3;

return 0;
}