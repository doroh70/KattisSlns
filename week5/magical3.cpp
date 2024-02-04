#include <iostream>
#include <cmath>
#include <vector>

long getSmallestBase(long n) {
    long base = -1;
    for(long i = 1; i <= std::sqrt(n); i++){
        if((n % i == 0) && ((n + 3) % i == 3)){
            if((base == -1) || (base > i)){
                base = i;
            }
        }
        if((i != n/i) && ((n + 3) % (n/i) == 3)){
            if((base == -1) || (base > n/i)){
                base = n/i;
            }
        }
    }
    return base;
}

int main() {
    long in;

    while(std::cin >> in) {
        if(in == 0) {
            break;
        }
        if(in < 3){
            std::cout << "No such base" << std::endl;
            continue;
        }
        if(in == 3){
            std::cout << 4 << std::endl;
            continue;
        }

        long cValue = in - 3;
        long smallestBase = getSmallestBase(cValue);

        if (smallestBase == -1) {
            std::cout << "No such base" << std::endl;
            continue;
        }
        std::cout << smallestBase << std::endl;
    }

    return 0;
}
