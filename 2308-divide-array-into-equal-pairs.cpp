class Solution {
public:
    bool divideArray(vector<int>& nums) {
        unordered_set<int> remaining;
        for(int ele: nums){
            if(remaining.count(ele))    remaining.erase(ele);
            else                        remaining.insert(ele);
        }
        return remaining.size()==0;
    }
};