#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(){

    int T;
    cin >> T;

    for(int i = 0; i < T; i++) {
        int n;
        cin >> n;
        vector<string> places;
        for(int j = 0; j < n; j++) {
            string city;
            cin >> city;
            if(find(places.begin(), places.end(), city) == places.end()){
                places.push_back(city);
            }
        }
        cout << places.size() << endl;
    }    
    return 0;
}