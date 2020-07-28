
public  class BSTreeNode {
        private int value;
        private int count;
        private BSTreeNode left;
        private BSTreeNode right;
    
        public BSTreeNode(int value, int count) {
            this.value = value;
            this.count = count;
            left = null;
            right = null;
        }
    
        public int getValue() {
            return value;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    
        public int getCount() {
            return count;
        }
    
        public void setCount(int count) {
            this.count = count;
        }
    
        public BSTreeNode getLeftNode() {
            return left;
        }
    
        public void setLeftNode(BSTreeNode node) {
            this.left = node;
        }
    
        public BSTreeNode getRightNode() {
            return right;
        }
    
        public void setRightNode(BSTreeNode node) {
            this.right = node;
        }
         
}


