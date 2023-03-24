//GFGv- Optimal solution
//Remove And Reverse
//Time complexity: O(|S|)
//Space complexity O(K), K <= 26.

package GFG;

public class RemoveAndReverse_1 {
    
    public static void main(String[] args) {
        String S = "abab";
        System.out.println(removeReverse(S));
    }

    static String removeReverse(String S) 
    { 
        // code here
        StringBuffer s = new StringBuffer(S);
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
    
        int flag=0;
        int st=0; int end=s.length()-1; 
        while(st<=end)
        {
            //checking from start
            if(flag==0)
            {
                if(freq[s.charAt(st)-'a']==1) ///no reperatinng ch , check for others
                st++;
            
                else
                {
                    freq[s.charAt(st)-'a']--;
                    s.replace(st,st+1,"#");
                    st++;
                    flag=1; // string is reverse , traverse from 'end' ptr for f==1
                }
            }
            
            else
            {
                if(freq[s.charAt(end)-'a']==1) ///no reperatinng ch , check for others
                end--;
            
                else
                {
                    freq[s.charAt(end)-'a']--;
                    s.replace(end,end+1,"#");
                    end--;
                    flag=0; // string is reverse , traverse from start
                }
            }
        }
        //after processing for flag==0, it passes to flag==1 ( but here i cannot found any char freq >1)
        //but still i have to reveres it
        if(flag==1)
        s.reverse();
        
         String ans="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='#')
                ans+=s.charAt(i);
        }
        return ans;
    }
}
