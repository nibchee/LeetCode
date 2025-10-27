class Solution {
    public int numberOfBeams(String[] bank) {
        int total = 0,prev = 0;
        for(String s : bank){
                int level = 0;
            for(int i=0;i<s.length();++i){
                char c = s.charAt(i);
                if(c == '1'){
                    total += prev;
                    ++level;
                }   
            }
            if(level>0){
                prev = level;
            }
        }
        return total;
    }
}