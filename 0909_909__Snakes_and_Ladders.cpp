class Solution {
bool findBobPath(vector<vector<int>>& adj,int bob,int parent,vector<int>& curr_path,vector<int>& bob_path){
if(bob==0){
bob_path = curr_path;
return true;
}
//Traverse all nbrs
curr_path.push_back(bob);
for(int nbr: adj[bob]){
if(nbr!=parent and findBobPath(adj,nbr,bob,curr_path,bob_path))
return true;
}
curr_path.pop_back();
return false;
}
int findMaxIncomeForAlice(vector<vector<int>>& adj,int alice,int parent,vector<int>& amount){
int max_income = INT_MIN;