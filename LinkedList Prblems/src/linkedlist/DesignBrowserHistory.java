package linkedlist;

public class DesignBrowserHistory {
    class Node{
        String url;
        Node prev,next;
        public Node(String url){
            this.url=url;
            next=prev=null;
        }
    }
    // curr pointer keeps track of the currently open page.
    Node curr;

    //initialize the browser with a homepage and create the first node for it. The curr pointer is set to this node.
    public DesignBrowserHistory(String homepage) {
        curr=new Node(homepage);
    }
    //When we visit a new URL, I create a new node, set it as the next of curr, and update the curr pointer. I also remove any forward history by not maintaining the old curr.next chain
    public void visit(String url) {
        Node node=new Node(url);
        curr.next=node;
        node.prev=curr;
        curr=node;

    }
    //To move back in history, I just follow the prev pointer up to steps times or until no more back steps are possible
    public String back(int steps) {
        while(curr.prev!=null && steps-- >0){
            curr=curr.prev;
        }
        return curr.url;

    }
    // "Similarly, to move forward, I use the next pointer up to steps times or until there's no next node."
    public String forward(int steps) {
        while(curr.next!=null && steps-- >0){
            curr=curr.next;
        }
        return curr.url;

    }

    public static void main(String[] args) {
        DesignBrowserHistory obj=new DesignBrowserHistory("priya@gmail.com");
        obj.visit("vvp.com");
        String p1=obj.back(1);
        String p2=obj.forward(2);

    }
}
/*
1. Start with the Problem Statement
"I implemented a simplified browser history system that mimics the real-life browser navigation behavior: visiting a new page, going back in history, and going forward."

🔷 2. Talk About the Data Structure Chosen
"To support back and forward operations efficiently, I used a doubly linked list. Each node represents a webpage with a URL, and has links to the previous and next pages."

Doubly Linked List helps us move backward and forward in O(1) time.

No need to maintain additional stacks or arrays—simple and efficient.

All operations (visit, back, forward) are done in O(steps) time, and each visit adds a new node, so the space complexity is O(n), where n is the number of unique visits."
 */

/*
✅ DesignBrowserHistory – Short Interview Explanation
I built a browser history system using a doubly linked list. Each node stores a URL and links to the previous and next pages. I maintain a curr pointer to track the current page.

Constructor: Initializes the browser with the homepage as the first node.

visit(url): Creates a new node, links it as curr.next, and updates curr. Any forward history is discarded.

back(steps): Moves curr to prev node up to steps times.

forward(steps): Moves curr to next node up to steps times.

🕒 All operations run in O(steps) time.
📦 Space is O(n) for n visited pages.

It’s a clean, real-world use of doubly linked lists—efficient for back and forward navigation.


 */
