
package binarytree_lab4_onwude;
/*
   Chiamaka Onwude
   CSCI 308 Spring 2023
   03/06/2023
*/
public class BinaryTreeNode_Onwude {
    ElementBinaryTree_Onwude element;
    static BinaryTreeNode_Onwude parent;
    BinaryTreeNode_Onwude left;
    boolean leftVisited;
    BinaryTreeNode_Onwude right;
    boolean rightVisited;
    boolean isLeaf;
    int inOrderRank;

    /*public BinaryTreeNode_Onwude(ElementBinaryTree_Onwude element){
        element=this.element;
    }*/
    public static void insert(int intData)
    {
        parent = insert(intData, parent);
    }
    
    public static BinaryTreeNode_Onwude insert(int newNum, BinaryTreeNode_Onwude rootNode){
            
            if(rootNode==null)
            {
                /*ElementBinaryTree_Onwude element= new ElementBinaryTree_Onwude(newNum, ' ');
                rootNode = new BinaryTreeNode_Onwude();
                
                element.setIntData(newNum);
                rootNode = new BinaryTreeNode_Onwude();*/
                rootNode.element.setIntData(newNum);
                return rootNode;
            }
            else if(newNum<rootNode.element.getIntData())
            {
                rootNode.left=insert(newNum,rootNode.left);
                
            }            
            else{
                rootNode.right=insert(newNum,rootNode.right);
            } 
            return rootNode;
    }
    public void Remove(){
        //peek and return node
        //call search
        //call print
    }
   public static boolean searchList(int val)
   {
       return searchList(parent, val);
           
   }
        
    public static boolean searchList(BinaryTreeNode_Onwude rootNode,int searchNum ){
        if(rootNode.getElement().getIntData() == searchNum )
            return true;
        if(rootNode.getLeft() != null)
        {
            if(searchList(rootNode.getLeft(), searchNum))
                return true;
        }
        if(rootNode.getRight() != null)
        {
            if(searchList(rootNode.getRight(), searchNum))
                return true;
        }
       return false;
    }
    public static boolean isEmpty(){
        if(parent == null)
            return true;
        else
            return false;
    }
    public static int height()
    {
        return height(parent);
    }
    public static int height(BinaryTreeNode_Onwude heightNod)
    {
        if(heightNod == null)
        {
            return 0;
        }
        else{
            int heightCount = 1;
            heightCount += height(heightNod.getLeft());
            heightCount += height(heightNod.getRight());
            return heightCount;
        }
        
    }
    public void printList(BinaryTreeNode_Onwude curNode, int number){
        /*(//call search and printlist 
        if(curNode.element.getIntData()== number){
            System.out.println(curNode.element.getIntData());
            return true;
        }*/
    }
    public boolean IsLeaf(BinaryTreeNode_Onwude rootNode) {
        if (rootNode.left== null && rootNode.right==null)
            return true;
        else
            return false;
    }
    public ElementBinaryTree_Onwude getElement() {
        return element;
    }
    public void setElement(ElementBinaryTree_Onwude aElement) {
        element = aElement;
    }
    public BinaryTreeNode_Onwude getParent() {
        return parent;
    }
    public void setParent(BinaryTreeNode_Onwude aParent) {
        parent = aParent;
    }
    public BinaryTreeNode_Onwude getLeft() {
        return left;
    }
    public void setLeft(BinaryTreeNode_Onwude left) {
        this.left = left;
    }
    public boolean isLeftVisted() {
        return leftVisited;
    }
    public void setLeftVisted(boolean leftVisted) {
        this.leftVisited = leftVisited;
    }
    public BinaryTreeNode_Onwude getRight() {
        return right;
    }
    public void setRight(BinaryTreeNode_Onwude right) {
        this.right = right;
    }
    public boolean isRightVisited() {
        return rightVisited;
    }
    public void setRightVisited(boolean rightVisited) {
        this.rightVisited = rightVisited;
    }    
    public int getInOrderRank() {
        return inOrderRank;
    }
    public void setInOrderRank(int inOrderRank) {
        this.inOrderRank = inOrderRank;
    }
}