//GFGv- Brute force method
//Remove And Reverse
//Time complexity: O(N^2)  
//Space complexity: O(N)  

package GFG;

public class RemoveAndReverse {
    
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
        
        int flag=1;
        while(flag==1)
        {
            int k=0;
            for( k=0; k<26; k++)
            {
                if(freq[k]>1)
                {
                    break;
                }
            }
            if( k==26) flag=0;
            
            int idx=-1;
            for(int i=0;i<s.length();i++)
            {
                if( (s.charAt(i)!='#') && (freq[s.charAt(i)-'a']>1))
                {
                    idx=i;
                    freq[s.charAt(i)-'a']--;
                    break;
                }
            }
            if(idx==-1)
            break;
            
            s.replace(idx,idx+1, "#");
            s.reverse();
            
        }
         String ans="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='#')
                ans+=s.charAt(i);
        }
        return ans;
    }
}
