class Solution {
    private int countBits(int n) {
        int c = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                c++;
            n = n >> 1;
        }
        return c;
    }

    public int minimizeXor(int num1, int num2) {
        int b1=countBits(num2);
        PriorityQueue<Integer> q=new PriorityQueue<>(b1);
        int pos=0;
        while(num1!=0){
            if((num1 & 1)==1)
            q.add(pos);
           
           if(q.size()>b1) q.remove();
           num1=num1>>1;
            pos++;
        }

        int ans=0;
        int ele=0;
        int qSize=q.size();
        while(!q.isEmpty()){
                 ele=(int)q.remove();
                ans+=Math.pow(2,ele);
        }
         ele++;
        for(int i=0;i<(b1-qSize);i++){
            ans+=Math.pow(2,ele);
            ele++;
        }
    return ans;
    }
}

// int bits = countBits(num2);
//         int bits2=countBits(num1);
//          System.out.println("Bits"+bits);
//         int k = 0;
//         int ans = 0;
//         while (num1 != 0 && bits!=0) {

//             while (num1 != 0 && (num1 & 1) == 0) {
//                 num1 = num1 >> 1;
//                 k++;
//             }
//              System.out.println(k);
//             ans += Math.pow(2, k);
//             bits--;
//             num1 = num1 >> 1;
//             k++;
//         }

//         while (bits != 0) {
//          System.out.println(k);
//             ans += Math.pow(2, k);
//             bits--;
//             k++;
//         }
//         return ans;