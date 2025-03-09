class Solution {
public:
    int numberOfAlternatingGroups(vector<int>& colors, int k) {
        int n=colors.size();
        int count=0;
        int l=0;
        int limit=n+k-1;

        while(l<n){
            //Find largest valid window
            int r=l+1;
            while(r<limit and colors[(r-1)%n]!=colors[r%n])
                r++;
            
            //Count Valid Windows
            if(r-l >= k)
                count += (r-l) - k + 1;
            
            //Set new start point
            l=r;
        }
        return count;
    }
};