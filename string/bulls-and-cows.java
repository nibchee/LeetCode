class Solution {
    public String getHint(String secret, String guess) {
       HashMap<Character,ArrayList<Integer>> pos=new HashMap<>();

       for(int i=0;i<secret.length();i++){
        char ch=secret.charAt(i);
        ArrayList<Integer> s=pos.getOrDefault(ch,new ArrayList<>());
        s.add(i);
        pos.put(ch,s);
       }
        
    Integer cows=0;
    Integer bulls=0;
       for(int i=0;i<guess.length();i++){
        char ch=guess.charAt(i);
        if(pos.containsKey(ch)){
            ArrayList<Integer> s=pos.get(ch);
            if(s.contains(i)){
              s.remove(new Integer(i));
              bulls++;  
             
            }else{
                s.remove(s.size()-1);
                cows++;
    
            }
             if(s.size()>0)
              pos.put(ch,s);
              else
              pos.remove(ch);
        }

       }
       return Integer.toString(bulls)+'A'+Integer.toString(cows)+'B';
    }
}