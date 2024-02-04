#include <iostream>
#include <vector>


int main() {
    //read # of testcases T
        //loop T times
            //read # of candidates C
            //loop C times
                //read C candidates and print winner,
                //If no winner, print draw
    
    int T;
    std::cin >> T;

    for(int i = 0; i < T; i++){
        int C;
        std::cin >> C;
        std::vector<int> votes;
        for(int j = 0; j < C; j++){
            int vote;
            std::cin >> vote;
            votes.push_back(vote);
        }
    }
    return 0;
}