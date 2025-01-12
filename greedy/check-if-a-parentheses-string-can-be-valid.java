class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> st=new Stack<>();
         if(s.length()==1) return false;
        st.push(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')' && !st.isEmpty() && (s.charAt(st.peek())=='('||locked.charAt(st.peek())=='0')){
              st.pop();
            }else{
                st.push(i);
            }

        }
    return st.isEmpty();
    }
}