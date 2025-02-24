for(auto edge: edges){
adj[edge[0]].push_back(edge[1]);
adj[edge[1]].push_back(edge[0]);
}
//Step-2: Find the Bob to root path
vector<int> curr_path,bob_path;
findBobPath(adj,bob,-1,curr_path,bob_path);

//Step-3: Update amount of half of the path nodes to 0
int size = bob_path.size();
int i;
for(i=0;i<size/2;++i)
amount[bob_path[i]]=0;