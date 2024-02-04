#include <iostream>
#include <iomanip>

using namespace std;

int main(){
    int divisor = 0;
    double sum = 0.00000000000;
    double avg;
    
    int M;
    
    cin>>M;
    
    for(int i = 0; i < M; i++){
        double M = 0, S = 0;
        cin>>M>>S;
        
        divisor += M;        
        sum += S/60;
    }
    avg = sum/divisor;
    
    if(avg <= 1){
        cout<<"measurement error"<<endl;
    }
    else{
        cout<<setprecision(12)<<avg<<endl;
    }
}