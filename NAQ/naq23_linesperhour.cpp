#include <bits/stdc++.h>

using namespace std;

int main ()
{
    int n = 0, lph = 0, myint = 0, lts = 0, j = 0;
    cin >> n >> lph;
    int loc = lph * 5;

    vector<int> v;
    for(int i = 0; i < n; i++)
    {
        cin >> myint;
        v.push_back(myint);
    }
    sort(v.begin(), v.end());

    while(lts <= loc)
    {
        for(int i = 0; i < n; i++)
        {
            lts = lts + v[i]+v[i+1];
            j++;
        }
    }
    cout << j << endl;

    return 0;
}