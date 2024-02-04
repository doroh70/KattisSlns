#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> vec = {1, 2, 3, -2, 5, -4, 2, -10, 2, 6};

    int maxSubArray = 0;


    for(int i = 0; i < vec.size(); i++){ //try every possible length

        int currentSum = 0;
        for(int j = i; j < vec.size(); j++){
            //get magnitude of subarray
            currentSum += vec.at(j);
            if(currentSum > maxSubArray){
                maxSubArray = currentSum;
            }
        }
    }

    cout<<maxSubArray<<endl;

    return 0;
}