//Leetcode
//1472. Design Browser History
//Time complexity:
//Space complexity:

package LeetcodeNew;

public class BrowserHistory {

    class Node{
        Node prev, next;
        String url;
        Node(String url){
            next = null;
            prev = null;
            this.url = url;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = curr.next;
    }

    public String back(int steps) {
        while(curr.prev != null && steps-->0){
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(curr.next != null && steps-->0){
            curr = curr.next;
        }
        return curr.url;
    }

}
