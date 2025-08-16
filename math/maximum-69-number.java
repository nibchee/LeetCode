class Solution {
    public int maximum69Number (int num) {
        Integer x=num;
        String s=x.toString();
        String res=s;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='6')
            {
            res=s.substring(0,i)+'9'+s.substring(i+1);
            break;
            }
        }        
        int m=Integer.parseInt(res);
    return m;
     }
}