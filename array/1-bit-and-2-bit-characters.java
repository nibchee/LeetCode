class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        return (bits[n-1]==0 && (n-1)%2==0);
    }
}