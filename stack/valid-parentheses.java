class Solution {
    public boolean isValid(String s) {
         
         if(s.length()%2==1)
         return false;
         
         Stack<Character> stack=new Stack<>();
         
         for(int k=0;k<s.length();k++){

           if(!stack.isEmpty())
           {

             if(stack.peek()=='{' && s.charAt(k)=='}'){
                 stack.pop();
             }
             else if(stack.peek()=='(' && s.charAt(k)==')'){
                 stack.pop();
             }
           else if(stack.peek()=='[' && s.charAt(k)==']'){
                 stack.pop();
             }
             else
             stack.push(s.charAt(k));
           }
             else{
                 stack.push(s.charAt(k));
             }
        }

        if(!stack.isEmpty())
        return false;

        return true;
    }
}