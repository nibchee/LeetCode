class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
     Arrays.sort(asteroids);
     //boolean ans=true;

     for(int asteroid:asteroids){
        if(asteroid>mass)
        return false;
        mass+=asteroid;
     }   
     return true;
    }
}